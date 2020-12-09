package products;

import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductTracker {
	////////////////////
	// TEMP CODE FOR WEB SCRAPPER TESTING
	String scrapperstring = "null";

	try
	{
		Document doc = Jsoup.connect("https://www.amazon.in/Crucial-4gb-ddr4-2666-Desktop/dp/B07GMRJTS9").get();
		Element elementByID = doc.getElementById("priceblock_ourprice");
		scrapperstring = scrapperstring + (String) elementByID.val();

	}catch(
	IOException e)
	{
		e.printStackTrace();
	}

	PrintWriter writer = response.getWriter();
	String htmlRespone = "<html>";htmlRespone+="<h2>Your email is: "+email+"<br/>";htmlRespone+="website price is: "+scrapperstring+"</h2>";htmlRespone+="</html>";

	// return response
	writer.println(htmlRespone);
	////////////////////
}
