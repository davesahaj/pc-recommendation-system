package users;

import java.util.ArrayList;
import java.util.Iterator;

public class SessionManager {

	private static SessionManager instance = null;
	private static ArrayList<User> userlist = new ArrayList<User>();

	private SessionManager() {
	}

	public static SessionManager SessionManager() {
		if (instance == null) {
			instance = new SessionManager();
		}

		return instance;
	}

	public void addUser(User user) {
		userlist.add(user);
	}

	public User getUser(String username) {

		for (User user : userlist)
			if (user.getUsername().equals(username))
				return user;

		return null;
	}

	public void removeUser(String username) {

		for (User user : userlist)
			if (user.getUsername().equals(username))
			{
				userlist.remove(user);
				break;
			}
	}

}
