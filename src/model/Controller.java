package model;

import java.util.ArrayList;

public class Controller {

	private ArrayList<User> users;

	public Controller() {

		users = new ArrayList<User>();
		testCases();
		
	}

	public void testCases() {
	
		users.add(new Regular("3232", "samu", "Sammm"));
		users.add(new Premium("5678", "Pocahontas", "Pocah"));;
	}

	/**
	 * Returns a String containing the list of all registered users.
	 *
	 * @return A String containing the list of all registered users.
	 */

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i) != null) {
				msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();
			}

		}

		return msg;

	}

	/**
	 * Registers a new user with the given ID, name, nickname, user type, and
	 * category.
	 *
	 * @param id       The ID of the new user.
	 * @param name     The name of the new user.
	 * @param nickname The nickname of the new user.
	 * @param userType The type of user (1 for regular, 2 for premium).
	 * @param category The category of the premium user (1 for silver, 2 for gold, 3
	 *                 for diamond).
	 * @return True if the user was successfully registered, false otherwise.
	 */
	public boolean registerUser(String id, String name, String nickname, int userType) {

		if(userType == 1){
			users.add(new Regular(id, name, nickname));
			return true;
		}else{
			users.add(new Premium(id, name, nickname));
			return true;
		}

	}



}
