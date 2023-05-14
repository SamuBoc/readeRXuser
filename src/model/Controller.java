package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private ArrayList<User> users;
	private ArrayList<Products> products;

	public Controller() {

		products = new ArrayList<Products>();
		users = new ArrayList<User>();
		testCases();
		
	}

	public void testCases() {
	
		Calendar publicationTest1 = new GregorianCalendar(1992, 05-1, 02);
		Calendar publicationTest2 = new GregorianCalendar(2011, 06-1, 26);
		Calendar publicationTest3 = new GregorianCalendar(2000, 02-1, 20);
		Calendar publicationTest4 = new GregorianCalendar(1980, 10-1, 30);

		users.add(new Regular("3232", "samu", "Sammm"));
		users.add(new Premium("5678", "Pocahontas", "Pocah"));

		products.add(new Book("Harry potter", 250, publicationTest1,"urllllll", "A00", "un mago con una barita magica", 2, 25.4));
		products.add(new Book("MAD", 40, publicationTest2,"www.yo", "D92", "un mago con una barita magica", 1, 10.70));

		products.add(new Magazine("SEMANA", 20, publicationTest3, "WWW.la mejor clase es apo", "el mejor profeee woaaa", 3, 20.3, 2));
		products.add(new Magazine("REVISTA", 15, publicationTest4, "buena revista", "A00", 2, 8.2, 1));

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

	public boolean registerProduc(String id, String name, int numberPages, String review, int genre, double price, int category, int periodicity, int typeProduct, String url, int pDay, int pMounth, int pYear){

		Calendar publicationDate = new GregorianCalendar(pYear, pMounth-1, pDay);

		if(typeProduct == 1){

			products.add(new Book(name, numberPages, publicationDate, url, id, review, genre, price));

			return true;
		}else{

			products.add(new Magazine(name, numberPages, publicationDate, url, id, category, price, periodicity));

			return true;
		}

	}

	public boolean deletUser(int position){

		users.remove(position-1);
		return true;
		
	}

	public boolean deletProduct(int position){

		products.remove(position-1);
		return true;
		
	}

	public boolean saleProduct(int  user, int product){

		if(products.get(product) instanceof Book){
			Book sale = (Book)products.get(product);
			users.get(user).addBook(sale);
			return true;
		}else{
			Magazine sale = (Magazine)products.get(product);
			users.get(user).addMagazine(sale);
			return true;
		}
	}

	public boolean verifier(int position){

		if(users.get(position-1) instanceof User){
			return true;
		}

		if(products.get(position-1) instanceof Book | products.get(position) instanceof Magazine){
			return true;
		}

		return false;
	}

	public String printoProducts(){

		String msg = "";
		msg += "\n" + "|   Name   |	  Type	  |";
		msg += "\n" + "_  _ _ _ _ _ _ _ _ _ _ _ ";

		for(int i = 0; i<products.size(); i++){

			if(products.get(i) != null){

			msg +=  "\n " + (i+1) + " | " + products.get(i).toString() + " | " +" \n "; 
			msg += "_ _  _ _ _ _ _ _ _ _ _ _ _";
		}

		}

		return msg;

	}

	public String printBook(){

		String msg = "";
		msg += "\n" + "|   	     Name 		  |";
		msg += "\n" + "_  _ _ _ _ _ _ _ _ _ _ _ ";

		for(int i = 0; i<products.size(); i++){

			if(products.get(i) != null){

			if(products.get(i) instanceof Book){
				msg +=  "\n " + (i+1) + " | " + products.get(i).toString() + " | " +" \n "; 
				msg += "_ _  _ _ _ _ _ _ _ _ _ _ _";
			}
		}

		}

		return msg;
	}

	public String printUs(){

		String msg = "";

		for(int i = 0; i<users.size(); i++){

			if(users.get(i) != null){

				msg += "\n" +(i+1) + " - " + users.get(i).toString(); 

			}

		}

		return msg;

	}

	 public int typeProduct(int position){

			if(products.get(position) instanceof Magazine){
				return 1;
			}

		return 2;
	 }

}
