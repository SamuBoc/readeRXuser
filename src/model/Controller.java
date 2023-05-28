package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private ArrayList<User> users;
	private ArrayList<Products> products;
	private ArrayList<Bill> bills;

	public Controller() {

		products = new ArrayList<Products>();
		users = new ArrayList<User>();
		bills = new ArrayList<Bill>();
		testCases();

	}

	public void testCases() {

		Calendar publicationTest1 = new GregorianCalendar(1992, 05 - 1, 02);
		Calendar publicationTest2 = new GregorianCalendar(2011, 06 - 1, 26);
		Calendar publicationTest3 = new GregorianCalendar(2000, 02 - 1, 20);
		Calendar publicationTest4 = new GregorianCalendar(1980, 10 - 1, 30);

		users.add(new Regular("3232", "samu", "Sammm"));
		users.add(new Premium("5678", "Pocahontas", "Pocah"));

		products.add(new Book("Harry potter", 250, publicationTest1, "urllllll", "un mago con una barita magica", 2, 2,
				"J22"));
		products.add(new Book("MAD", 40, publicationTest2, "www.yo", "D92", 1, 10.70, "A22"));

		products.add(new Magazine("SEMANA", 20, publicationTest3, "WWW.la mejor clase es apo", 3, 20.3, 2, "I22"));
		products.add(new Magazine("REVISTA", 15, publicationTest4, "buena revista", 2, 8.2, 1, "PW2"));

		saleProduct(0, "I22");
		saleProduct(0, "PW2");
		saleProduct(0, "A22");
		saleProduct(0, "J22");
		saleProduct(1, "I22");
		saleProduct(1, "PW2");
		saleProduct(1, "A22");
		saleProduct(1, "J22");

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

		if (userType == 1) {
			users.add(new Regular(id, name, nickname));
			return true;
		} else {
			users.add(new Premium(id, name, nickname));
			return true;
		}

	}

	public String processString(String input) {
		return input.toUpperCase().substring(0, Math.min(input.length(), 3));
	}

	/**
	 * Registers a new product (book or magazine) with the given details.
	 * 
	 * @param id          The identifier of the product.
	 * @param name        The name of the product.
	 * @param numberPages The number of pages in the product.
	 * @param review      The review of the product.
	 * @param genre       The genre of the product.
	 * @param price       The price of the product.
	 * @param category    The category of the product.
	 * @param periodicity The periodicity of the product.
	 * @param typeProduct The type of the product (1 for book, 2 for magazine).
	 * @param url         The URL of the product.
	 * @param pDay        The publication day of the product.
	 * @param pMonth      The publication month of the product.
	 * @param pYear       The publication year of the product.
	 * @return True if the product was successfully registered, false otherwise.
	 */
	public boolean registerProduc(String id, String name, int numberPages, String review, int genre, double price,
			int category, int periodicity, int typeProduct, String url, int pDay, int pMounth, int pYear) {

		Calendar publicationDate = new GregorianCalendar(pYear, pMounth - 1, pDay);

		String stringProcess;
		stringProcess = processString(id);

		if (stringProcess.equals("String does not contain exactly 3 characters")) {
			return false;
		} else {
			id = stringProcess;
		}

		if (typeProduct == 1) {

			products.add(new Book(name, numberPages, publicationDate, url, review, genre, price, id));

			return true;
		} else {

			products.add(new Magazine(name, numberPages, publicationDate, url, category, pYear, periodicity, id));

			return true;
		}

	}

	/**
	 * Deletes a user at the specified position.
	 * 
	 * @param position The position of the user to delete.
	 * @return True if the user was successfully deleted, false otherwise.
	 */
	public boolean deletUser(int position) {

		users.remove(position - 1);
		return true;

	}

	/**
	 * Deletes a product at the specified position.
	 * 
	 * @param position The position of the product to delete.
	 * @return True if the product was successfully deleted, false otherwise.
	 */
	public boolean deletProduct(int position) {

		products.remove(position - 1);
		return true;

	}

	/**
	 * Sells a product to a user.
	 * 
	 * @param user    The position of the user.
	 * @param product The identifier of the product.
	 * @return True if the product was successfully sold to the user, false
	 *         otherwise.
	 */
	public boolean saleProduct(int user, String product) {

		int position = -1;
		for (int i = 0; i < products.size(); i++) {
			String comparator = products.get(i).getIdentifier();
			if (comparator.equals(product)) {
				position = i;
			}
		}

		if (position == -1) {
			return false;
		}
		if (products.get(position) instanceof Book) {
			Book sale = (Book) products.get(position);
			users.get(user).addBook(sale);
			bills.add(new Bill(products.get(position).getIdentifier(), sale.getName(), sale.getPrice()));
			Double sold = sale.getTotalsold();
			sale.setTotalsold(sold++);
			return true;
		} else {
			Magazine sale = (Magazine) products.get(position);
			users.get(user).addMagazine(sale);
			bills.add(new Bill(products.get(position).getIdentifier(), sale.getName(), sale.getValueSuscription()));
			int suscribe = sale.getActiveSuscription();
			sale.setActiveSuscription(suscribe++);
			;
			return true;
		}

	}

	/**
	 * Verifies if a user exists at the specified position.
	 * 
	 * @param position The position of the user to verify.
	 * @return True if the user exists, false otherwise.
	 */
	public boolean verifyUser(int position) {

		if (users.get(position - 1) != null) {
			return true;
		}

		return false;
	}

	/**
	 * Verifies if a product with the given identifier exists.
	 * 
	 * @param identifier The identifier of the product to verify.
	 * @return True if the product exists, false otherwise.
	 */
	public boolean verifyProduct(String position) {

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getIdentifier().equals(position)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Prints the details of all products.
	 * 
	 * @return A string representation of all products.
	 */
	public String printoProducts() {

		String msg = "";
		msg += "\n" + "|   Name   |	  Type	  |";
		msg += "\n" + "_  _ _ _ _ _ _ _ _ _ _ _ ";

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i) != null) {

				msg += "\n " + (i + 1) + " | " + products.get(i).toString() + " | " + " \n ";
				msg += "_ _  _ _ _ _ _ _ _ _ _ _ _";
			}

		}

		return msg;

	}

	/**
	 * Prints the inventory of books.
	 * 
	 * @return A string representation of the book inventory.
	 */
	public String printBook() {

		String[][] matriz = new String[5][5];
		String msg = "";
		int index = 0;

		String[][] books = new String[5][5];

		for (int i = 0; i < books.length; i++) {
			for (int j = 0; j < books[i].length; j++) {
				if (index < products.size()) {
					if (products.get(index) instanceof Book) {
						books[i][j] = products.get(index).getIdentifier();
					} else {
						break;
					}
					index++;
				}
			}
		}

		index = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (index < products.size()) {
					if (i == 0 && books[0][j] != null) {
						matriz[i][j] = books[0][j];
					} else if (products.get(index) instanceof Book) {
						matriz[i][j] = products.get(index).getIdentifier();
					} else {
						matriz[i][j] = "___"; // Rellenar espacios vacíos con "___"
					}
					index++;
				} else {
					matriz[i][j] = "___";
				}
			}
		}

		msg += "  " + " 0  " + " 1  " + " 2  " + " 3  " + " 4  " + " \n";

		for (int i = 0; i < matriz.length; i++) {
			msg += i + " ";
			for (int j = 0; j < matriz[i].length; j++) {
				msg += matriz[i][j] + " ";
			}
			msg += "\n";
		}

		return msg;

	}

	/**
	 * Prints the inventory of magazines.
	 * 
	 * @return A string representation of the magazine inventory.
	 */
	public String printMagazine() {

		String[][] matriz = new String[5][5];
		String msg = "";
		int index = 0;

		String[][] magazine = new String[5][5];

		for (int i = 0; i < magazine.length; i++) {
			for (int j = 0; j < magazine[i].length; j++) {
				if (index < products.size()) {
					if (products.get(index) instanceof Magazine) {
						magazine[i][j] = products.get(index).getIdentifier();
					} else {
						break;
					}
					index++;
				}
			}
		}

		index = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (index < products.size()) {
					if (i == 0 && magazine[0][j] != null) {
						matriz[i][j] = magazine[0][j];
					} else if (products.get(index) instanceof Magazine) {
						matriz[i][j] = products.get(index).getIdentifier();
					} else {
						matriz[i][j] = "___";
					}
					index++;
				} else {
					matriz[i][j] = "___";
				}
			}
		}

		msg += "  " + " 0  " + " 1  " + " 2  " + " 3  " + " 4  " + " \n";

		for (int i = 0; i < matriz.length; i++) {
			msg += i + " ";
			for (int j = 0; j < matriz[i].length; j++) {
				msg += matriz[i][j] + " ";
			}
			msg += "\n";
		}

		return msg;
	}

	/**
	 * Prints the details of all users.
	 * 
	 * @return A string representation of all users.
	 */
	public String printUs() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i) != null) {

				msg += "\n" + (i + 1) + " - " + users.get(i).toString();

			}

		}

		return msg;

	}

	/**
	 * Returns the type of product at the specified position.
	 * 
	 * @param position The position of the product.
	 * @return 1 for magazines, 2 for books.
	 */
	public int typeProduct(int position) {

		if (products.get(position) instanceof Magazine) {
			return 1;
		}

		return 2;
	}

	/**
	 * Unsubscribes a user from a magazine.
	 * 
	 * @param user    The position of the user.
	 * @param product The identifier of the magazine to unsubscribe from.
	 * @return True if the unsubscription is successful, false otherwise.
	 */
	public Boolean unSuscribe(int user, String product) {

		users.get(user - 1).magazineDelete(product);

		return true;
	}

	/**
	 * Prints the magazines of a specific user.
	 * 
	 * @param position The position of the user.
	 * @return A string representation of the user's magazines.
	 */
	public String userPrintMagazine(int position) {

		String msg = users.get(position - 1).printMagazine();

		return msg;

	}

	/**
	 * Views the library of a specific user.
	 * 
	 * @param user The position of the user.
	 * @return A string representation of the user's library.
	 */
	public String viewLibrary(int user) {

		String msg = users.get(user - 1).viewLibrary();

		return msg;

	}

}
