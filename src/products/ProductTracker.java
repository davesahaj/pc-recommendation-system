package products;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dao.ProductTrackerDAO;

public class ProductTracker implements ServletContextListener {

	//private ScheduledExecutorService scheduler;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Prices updation stopped");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Price Updation started");

		/*scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new Updater(), 0, 1, TimeUnit.HOURS);*/

	}

}

class Updater implements Runnable {
	public int sanatizePriceData(String price) {

		char[] digits = price.toCharArray();
		price = "";

		for (char digit : digits) {
			if (digit == '.')
				break;

			if (Character.isDigit(digit))
				price += digit;

		}
		return Integer.parseInt(price);
	}

	public int PriceFetcher(int id, String platform) throws SQLException {
		try {
			// "https://www.amazon.in/ADATA-AD4U2400J4G17-R-2400MHz-DDR4-U-DIMM/dp/B0752P9QVM";
			// https://www.amazon.in/Crucial-4gb-ddr4-2666-Desktop/dp/B07GMRJTS9

			ProductTrackerDAO Producttrackerdao = new ProductTrackerDAO();
			System.out.println("price fetcher invoked, calling getURL");
			String url = Producttrackerdao.getURL(id, platform);

			Document document = Jsoup.connect(url).get();

			// get the webpage text
			Elements elements = document.select("#priceblock_ourprice");
			if (elements.size() > 0)
				for (Element e : elements) {
					return sanatizePriceData(e.ownText());
				}
			else {
				elements = document.select("#priceblock_dealprice");

				for (Element e : elements) {
					return sanatizePriceData(e.ownText());
				}

			}
		} catch (IOException ioe) {
			System.out.println("Unable to connect to the URL");
			ioe.printStackTrace();
			return -1;
		}

		return -1;
	}

	public void PriceUpdater(int id, String platform) throws SQLException {

		int price = PriceFetcher(id, platform);
		ProductTrackerDAO Producttrackerdao = new ProductTrackerDAO();
		Producttrackerdao.setPrice(id, price, platform);

	}

	@Override
	public void run() {
		
		
	}

}