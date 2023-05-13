package model;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Controller {

	private ArrayList<User> users;
	private ArrayList<Products> products;

	public Controller() {

		products = new ArrayList<Products>();
		users = new ArrayList<User>();
		testCases();
		
	}

	public void testCases() {
	
		users.add(new Regular("3232", "samu", "Sammm"));
		users.add(new Premium("5678", "Pocahontas", "Pocah"));
		products.add(new Book("Harry potter", 250, transformCalendar("04-05-2000"),"urllllll", "A00", "un mago con una barita magica", 2, 25.4));

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

	public boolean registerProduc(String id, String name, int numberPages, String review, String datePublic, int genre, double price, int category, double valueSuscription, int periodicity, int typeProduct, String url){

		if(typeProduct == 1){

			products.add(new Book(name, numberPages, transformCalendar(datePublic), url, id, review, genre, price));

			return true;
		}else{

			products.add(new Magazine(name, numberPages, transformCalendar(datePublic), url, id, category, valueSuscription, periodicity));

			return true;
		}

	}

	public Calendar transformCalendar(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date d = null;
		try {
		  d = sdf.parse(date);
		} catch (ParseException e) {
		  e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar;
	  }

	public String printBooks(){

		String msg = "";

		for(int i = 0; i<products.size(); i++){

			if(products.get(i) != null){

				msg += (i+1) + ". " + products.get(i).getName() + products.get(i).getPublicationDate() ;

			}

		}

		return msg;

	}

}
