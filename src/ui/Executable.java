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
			System.out.println("3. Eliminar un usuario");
			System.out.println("4. Eliminar un libro");
			System.out.println("5. Modificar un libro");
			System.out.println("6. Vender un libro");
			System.out.println("7. Vender una suscripcion");
			System.out.println("8.");
			System.out.println("9.");
			System.out.println("10. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerUser();
				break;
			case 2:
				registerProducts();
				break;
			case 3:
				deletUser();
				break;
			case 4:
				deletProduct();
				break;
			case 5:
				printProducts();
				break;
			case 6:
				saleBook();
				break;
			case 7:
				;
				break;
			case 8:
				;
				break;
			case 9:
			;
				break;
			case 10:
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

		System.out.println("Digite el id del producto:");
		String id = reader.nextLine();

		System.out.println("Digite el nombre del libro:");
		String name = reader.nextLine();

		System.out.println("Digite el numero de paginas:");
		int numberPages = reader.nextInt();

		System.out.println("Digite el dia de publiacion de el producto");
		int pDay = reader.nextInt();

		System.out.println("Digite el mes de publiacion de el producto");
		int pMounth = reader.nextInt();

		System.out.println("Digite el año de publiacion de el producto");
		int pYear = reader.nextInt();

		System.out.println("Digite la URl que lleva al repositorio del libro:");
		String url = reader.nextLine();


		System.out.println("Digite el tipo de producto que desea registrar \n 1. Libro \n 2. Revista");
		int typeProduct = reader.nextInt();
		reader.nextLine();

		if(typeProduct == 1){

			System.out.println("Digite una pequeña review del libro:");
			String review = reader.nextLine();

			System.out.println("Digite el genero del libro: \n 1. SCIENCE_FICTION \n 2. FANTASY \n 3. HISTORICAL_NOVELS");
			int genre = reader.nextInt();
			
			System.out.println("Digite el valor de la venta:");
			double price = reader.nextInt();

			if(rXSystem.registerProduc(id, name, numberPages, review, genre, price, numberPages, genre, typeProduct, url, pDay, pMounth, pYear)){
				System.out.println("Registrado exitosamente");
			}else{
				System.out.println("Ocurrio un problema");
			}

		}else{

			System.out.println("Digite la periodicidad de emicion \n 1. WEEKLY  \n 2. MONTHLY \n 3. BIWEEKLY");
			int periodicity = reader.nextInt();

			System.out.println("Digite el genero del libro \n 1. VARIETY \n 2. SCIENTIFIC \n 3. DESIGN");
			int category = reader.nextInt();
	
			System.out.println("Digite el valor de la suscripcion :");
			double price = reader.nextDouble();

			if(rXSystem.registerProduc(id, name, numberPages, name, numberPages, price, category, periodicity, typeProduct, url, pDay, pMounth, pYear)){
				System.out.println("Registrado exitosamente");
			}else{
				System.out.println("Ocurrio un problema");
			}



		

		}
	}

	private void deletUser(){

		System.out.println("Digite el usuario que desea eliminar");
		System.out.println(rXSystem.printUs());
		int query1 = reader.nextInt();
		
		if(rXSystem.verifier(query1, 1) == true){
			rXSystem.deletUser(query1);
		}else{
			System.out.println("Esta opcion no es correcta");
		}

	}

	private void deletProduct(){

		String query1 = rXSystem.printoProducts();
		
		System.out.println(query1);
		System.out.println("\n Digite el producto que desea eliminar: ");
		int query2 = reader.nextInt();
		
		if(rXSystem.verifier(query2-1, 2) == true){
			rXSystem.deletProduct(query2);
			System.out.println("Se ha eliminado correctamente");
		}else{
			System.out.println("Esta opcion no es correcta");
		}

	}

	private void editProduct(){

		String query1 = rXSystem.printoProducts();
		System.out.println(query1);
		System.out.println("Que producto desea editar : \n");
		int query2 = reader.nextInt();
		
		if(rXSystem.verifier(query2-1, 2) == true){
			
			if(rXSystem.typeProduct(query2) == 1){
				System.out.println("1. Editar todo");
				System.out.println("2. ID");
				System.out.println("3. Nombre");
				System.out.println("4. Número de páginas");
				System.out.println("5. Reseña corta");
				System.out.println("6. Género");
				System.out.println("7. URL de la portada");
				System.out.println("8. Valor de venta");
				int param = reader.nextInt();

				switch (param) {
					case 1:
					System.out.println(" Digite el nuevo nombre : \n ");


						break;
					case 2:
					System.out.println("Digite el nuevo nombre : \n ");
						break; 
					default:
						break;
				}
				
			}else{

			}

		}else{
			System.out.println("Esta opcion no es correcta");
		}


	}

	private void saleBook(){

		printus();

		System.out.println("A que usuario desea venderle el libro: ");
		int user = reader.nextInt();

		printProducts();
		System.out.println("\n" + "Que libro desea venderle: ");
		int sale = reader.nextInt();

		if(){
			
		}

	}

	private void printProducts(){
		System.out.println(rXSystem.printoProducts());
	}

	private void printus(){
		System.out.println(rXSystem.printUs());
	}

	


}