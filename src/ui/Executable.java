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

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("\n1. Registrar usuario");
			System.out.println("2. Registra un producto");
			System.out.println("3. ");
			System.out.println("4. ");
			System.out.println("5. ");
			System.out.println("6. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerUser();
				break;
			case 2:
				registerProducts();
				break;
			case 3:
				printProducts();
				break;
			case 4:
				;
				break;
			case 5:
				;
				break;
			case 6:
				flag = true;
				break;
			default:
				System.out.println("Opcion invalida");
				break;

			}

		}

	}

	private void registerUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();

		System.out.println("Digite el tipo de usuario \n1.Regular \n2.Premium");
		int userType = reader.nextInt();

		if (rXSystem.registerUser(id, name, nickname, userType)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}


	}

	private void registerProducts(){

		System.out.println("Digite el tipo de producto que desea registrar \n 1. Libro \n 2. Revista");
		int typeProduct = reader.nextInt();
		reader.nextLine();

		String id = "";
		String name = "";
		int numPages = 0;
		String date = "";
		int genre = 0;
		String url = "";
		double price = 0;
		int periodicity = 0;
		String review = "";

		if(typeProduct == 1){

			System.out.println("Digite el id del libro:");
			id = reader.nextLine();
	
			System.out.println("Digite el nombre del libro:");
			name = reader.nextLine();
	
			System.out.println("Digite el numero de paginas:");
			numPages = reader.nextInt();
	
			System.out.println("Digite una reseña corta:");
			review = reader.nextLine();
			reader.nextLine();
	
			System.out.println("Digite una fecha de publicacion con el siguiente esquema: (dd-MM-yyyy):");
			date = reader.nextLine();
	
			// Limpieza de buffer
			reader.nextLine();

			System.out.println("Digite el genero del libro \n 1. SCIENCE_FICTION \n 2. FANTASY \n 3. HISTORICAL_NOVELS :");
			genre = reader.nextInt();
	
			System.out.println("Digite la URl que lleva al repositorio del libro:");
			url = reader.nextLine();
	
			System.out.println("Digite el valor de la venta :");
			price = reader.nextDouble();

			if(rXSystem.registerProduc(id, name, numPages, review, date, genre, price, genre, price, periodicity, typeProduct, url)){
				System.out.println("Registrado exitosamente");
			}else{
				System.out.println("Ocurrio un problema");
			}

		}else{

			System.out.println("Digite el id de la revista:");
			 id = reader.nextLine();
			reader.nextLine();
	
			System.out.println("Digite el nombre :");
			 name = reader.nextLine();
	
			System.out.println("Digite el numero de paginas:");
			 numPages = reader.nextInt();
	
			System.out.println("Digite una fecha de publicacion con el siguiente esquema: (dd-MM-yyyy):");
			date = reader.nextLine();
	
			System.out.println("Digite la periodicidad de emicion \n 1. VARIETY \n 2. SCIENTIFIC \n 3. DESIGN:");
			periodicity = reader.nextInt();

			System.out.println("Digite el genero del libro \n 1. SCIENCE_FICTION \n 2. FANTASY \n 3. HISTORICAL_NOVELS :");
			genre = reader.nextInt();
	
			System.out.println("Digite la URl que lleva al repositorio del libro:");
			url = reader.nextLine();
	
			System.out.println("Digite el valor de la suscripcion :");
			price = reader.nextDouble();

			if(rXSystem.registerProduc(id, name, numPages, review, date, genre, price, genre, price, periodicity, typeProduct, url)){
				System.out.println("Registrado exitosamente");
			}else{
				System.out.println("Ocurrio un problema");
			}

		}
	}

	private void printProducts(){
		rXSystem.printBooks();
	}



}