package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Regular extends User {

    private Book[] books;
    private Magazine[] magazine;

    public Regular(String id, String name, String nickname) {
        super(id, name, nickname);
        // TODO Auto-generated constructor stub

        books = new Book[5];
        magazine = new Magazine[2];

    }

    @Override
    public String toString() {

        return "Id: " + this.getId() + "\nName: " + this.getName() + "\nNickname: " + this.getNickname()
                + "\nCategory: Regular";

    }

    @Override
    public Boolean addBook(Book product) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = product;
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean addMagazine(Magazine product) {
        for (int i = 0; i < magazine.length; i++) {
            if (magazine[i] == null) {
                magazine[i] = product;
                return true;
            }
        }
        return false;
    }

    @Override
    public String printMagazine() {
        String msg = "";

        for (int i = 0; i < magazine.length; i++) {
            if (magazine[i] != null) {
                msg += " " + magazine[i].getIdentifier() + " " + magazine[i].getName() + " \n ";
            }
        }
        return msg;
    }

    @Override
    public boolean magazineDelete(String position) {
        for (int i = 0; i < magazine.length; i++) {
            String product = magazine[i].getIdentifier();
            if (product.equals(position)) {
                magazine[i] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public String viewLibrary() {
        String msg = "";
        String[][] newMatrix = new String[5][5];

        ArrayList<Products> products = new ArrayList<Products>();

        for (int i = 0; i < magazine.length; i++) {
            if (magazine[i] != null) {
                products.add(magazine[i]);
            }
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                products.add(books[i]);
            }
        }

        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                Calendar date1 = products.get(i).getPublicationDate();
                Calendar date2 = products.get(j).getPublicationDate();

                if (date1.after(date2)) {
                    Products temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }

        int index = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (index < products.size()) {
                    newMatrix[i][j] = products.get(index).getIdentifier();
                    index++;
                } else {
                    newMatrix[i][j] = "___"; 
                }
            }
        }

        msg += "  " + " 0  " + " 1  " + " 2  " + " 3  " + " 4  " + " \n";
        
        for (int i = 0; i < newMatrix.length; i++) {
            msg += i + " ";
            for (int j = 0; j < newMatrix[0].length; j++) {
                msg += newMatrix[i][j] + " ";
            }
            msg += "\n";
        }

        return msg;
    }

}
