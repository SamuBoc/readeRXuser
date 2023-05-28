package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	private void menu() {

		System.out.println("Welcome to ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMAIN MENU");
			System.out.println("\n1. Register user");
			System.out.println("2. Register a product");
			System.out.println("3. Delete a user");
			System.out.println("4. Delete a book");
			System.out.println("5. Modify a book");
			System.out.println("6. Sell a book");
			System.out.println("7. Sell a subscription");
			System.out.println("8. Cancel a subscription");
			System.out.println("9. Show user's library");
			System.out.println("10. Reading simulation");
			System.out.println("11. Exit");
			int option = reader.nextInt();

			switch (option) {

				case 1:
					registerUser();
					break;
				case 2:
					registerProducts();
					break;
				case 3:
					deleteUser();
					break;
				case 4:
					deleteProduct();
					break;
				case 5:
					editProduct();
					break;
				case 6:
					saleBook();
					break;
				case 7:
					saleMagazine();
					break;
				case 8:
					unsubscribe();
					break;
				case 9:
					viewLibrary();
					break;
				case 10:
					readingSection();
					break;
				case 11:
					System.out.println("Thank you for running the program");
					flag = true;
					break;
				default:
					System.out.println("Invalid option");
					break;

			}

		}

	}

	private void registerUser() {

		System.out.println("Enter the information of a new user");

		// Clear buffer
		reader.nextLine();

		System.out.println("Enter the ID");
		String id = reader.nextLine();

		System.out.println("Enter the name");
		String name = reader.nextLine();

		System.out.println("Enter the nickname");
		String nickname = reader.nextLine();

		System.out.println("Enter the user type \n1. Regular \n2. Premium");
		int userType = reader.nextInt();

		if (rXSystem.registerUser(id, name, nickname, userType)) {

			System.out.println("User registered successfully");

		} else {

			System.out.println("Memory full, unable to register the user");
		}

	}

	private void registerProducts() {

		System.out.println("Enter the product ID:");
		String id = reader.nextLine();

		reader.nextLine();

		System.out.println("Enter the book name:");
		String name = reader.nextLine();

		System.out.println("Enter the number of pages:");
		int numberPages = reader.nextInt();

		System.out.println("Enter the publication day of the product");
		int pDay = reader.nextInt();

		System.out.println("Enter the publication month of the product");
		int pMonth = reader.nextInt();

		System.out.println("Enter the publication year of the product");
		int pYear = reader.nextInt();

		System.out.println("Enter the URL that leads to the book repository:");
		String url = reader.nextLine();

		reader.nextLine();

		System.out.println("Enter the type of product you want to register \n 1. Book \n 2. Magazine");
		int typeProduct = reader.nextInt();
		reader.nextLine();

		if (typeProduct == 1) {

			System.out.println("Enter a short review of the book:");
			String review = reader.nextLine();

			System.out.println(
					"Enter the genre of the book: \n 1. SCIENCE_FICTION \n 2. FANTASY \n 3. HISTORICAL_NOVELS");
			int genre = reader.nextInt();

			System.out.println("Enter the selling price:");
			double price = reader.nextInt();

			if (rXSystem.registerProduc(id, name, numberPages, review, genre, price, numberPages, genre, typeProduct,
					url, pDay, pMonth, pYear)) {
				System.out.println("Successfully registered");
			} else {
				System.out.println("\n"
						+ "An error occurred, please check if the ID has more than 3 characters \n or if you filled in all the fields correctly");
			}

		} else {

			System.out.println("Enter the emission periodicity \n 1. WEEKLY  \n 2. MONTHLY \n 3. BIWEEKLY");
			int periodicity = reader.nextInt();

			System.out.println("Enter the genre of the book \n 1. VARIETY \n 2. SCIENTIFIC \n 3. DESIGN");
			int category = reader.nextInt();

			System.out.println("Enter the subscription price:");
			double price = reader.nextDouble();

			if (rXSystem.registerProduc(id, name, numberPages, name, numberPages, price, category, periodicity,
					typeProduct, url, pDay, pMonth, pYear)) {
				System.out.println("Successfully registered");
			} else {
				System.out.println("An error occurred");
			}

		}
	}

	private void deleteUser() {

		System.out.println("Enter the user you want to delete");
		System.out.println(rXSystem.printUs());
		int query1 = reader.nextInt();

		if (rXSystem.verifyUser(query1) == true) {
			rXSystem.deletUser(query1);
		} else {
			System.out.println("This option is not correct");
		}

	}

	private void deleteProduct() {

		String query1 = rXSystem.printoProducts();

		System.out.println(query1);
		System.out.println("\n Enter the product you want to delete: ");
		int query2 = reader.nextInt();

		if (rXSystem.verifyUser(query2 - 1) == true) {
			rXSystem.deletProduct(query2);
			System.out.println("Deleted successfully");
		} else {
			System.out.println("This option is not correct");
		}

	}

	private void editProduct() {

		String query1 = rXSystem.printoProducts();
		System.out.println(query1);
		System.out.println("Which product do you want to edit : \n");
		int query2 = reader.nextInt();

		if (rXSystem.verifyUser(query2 - 1) == true) {

			if (rXSystem.typeProduct(query2) == 1) {
				System.out.println("1. Edit everything");
				System.out.println("2. ID");
				System.out.println("3. Name");
				System.out.println("4. Number of pages");
				System.out.println("5. Short review");
				System.out.println("6. Genre");
				System.out.println("7. Cover URL");
				System.out.println("8. Selling price");
				int param = reader.nextInt();

				switch (param) {
					case 1:
						System.out.println("Enter the new name: \n ");
						break;
					case 2:
						System.out.println("Enter the new name: \n ");
						break;
					default:
						break;
				}

			} else {

			}

		} else {
			System.out.println("This option is not correct");
		}

	}

	private void saleBook() {

		String query1 = rXSystem.printoProducts();
		System.out.println(query1);
		System.out.println("Which product do you want to edit : \n");
		int query2 = reader.nextInt();

		if (rXSystem.verifyUser(query2 - 1) == true) {

			if (rXSystem.typeProduct(query2) == 1) {
				System.out.println("1. Edit everything");
				System.out.println("2. ID");
				System.out.println("3. Name");
				System.out.println("4. Number of pages");
				System.out.println("5. Short review");
				System.out.println("6. Genre");
				System.out.println("7. Cover URL");
				System.out.println("8. Selling price");
				int param = reader.nextInt();

				switch (param) {
					case 1:
						System.out.println("Enter the new name: \n ");
						break;
					case 2:
						System.out.println("Enter the new name: \n ");
						break;
					default:
						break;
				}

			} else {

			}

		} else {
			System.out.println("This option is not correct");
		}

	}

	private void saleMagazine() {

		printus();
		System.out.println("To which user do you want to sell the book: ");
		int user = reader.nextInt();

		if (rXSystem.verifyUser(user) == true) {

			System.out.println(rXSystem.printMagazine());
			reader.nextLine();
			System.out.println("\n" + "Which book do you want to sell: ");
			String sale = reader.nextLine();

			if (rXSystem.verifyProduct(sale)) {
				if (rXSystem.saleProduct(user - 1, sale) == true) {
					System.out.println("\n" + "Book sold successfully ");
				} else {
					System.out.println("\n" + "The library is full ");
				}
			} else {
				System.out.println("This book is not available ");
			}

		} else {
			System.out.println("This user is not registered:");
		}

	}

	private void unsubscribe() {

		printus();
		System.out.println("From which user do you want to cancel the subscription: ");
		int user = reader.nextInt();

		if (rXSystem.verifyUser(user) == true) {

			reader.nextLine();
			System.out.println(rXSystem.userPrintMagazine(user));
			System.out.println("Enter the ID of the magazine you want to delete: ");
			String magazine = reader.nextLine();

			if (rXSystem.verifyProduct(magazine) == true) {

				if (rXSystem.unSuscribe(user, magazine)) {
					System.out.println("Subscription successfully deleted");
				} else {
					System.out.println("It was not possible to delete the subscription");
				}

			} else {
				System.out.println("Magazine not found ");
			}

		} else {
			System.out.println("This user is not registered: ");
		}

	}

	private void viewLibrary() {

		printus();
		System.out.println("Whose library do you want to view: ");
		int user = reader.nextInt();

		if (rXSystem.verifyUser(user) == true) {

			System.out.println(rXSystem.viewLibrary(user));

		} else {
			System.out.println("This user is not registered: ");
		}

	}

	private void readingSection() {

		printus();
		System.out.println("Whose library do you want to view: ");
		int user = reader.nextInt();

		if (rXSystem.verifyUser(user) == true) {

			System.out.println(rXSystem.viewLibrary(user));

		} else {
			System.out.println("This user is not registered:  ");
		}

	}

	private void printus() {
		System.out.println(rXSystem.printUs());
	}

}