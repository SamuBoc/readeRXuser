package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Premium extends User {

    private ArrayList<Products> products;

    public Premium(String id, String name, String nickname) {
        super(id, name, nickname);
        products = new ArrayList<Products>();
    }

    @Override
    public String toString() {

        return "Id: " + this.getId() + "\nName: " + this.getName() + "\nNickname: " + this.getNickname()
                + "\nCategory: Premium";
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    @Override
    public Boolean addBook(Book product) {
        products.add(product);
        return true;
    }

    @Override
    public Boolean addMagazine(Magazine product) {
        products.add(product);
        return true;
    }

    @Override
    public String printMagazine() {
        String msg = "";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Magazine) {
                msg += " " + products.get(i).getIdentifier() + " " + products.get(i).getName() + " \n ";
            }
        }
        return msg;
    }

    @Override
    public boolean magazineDelete(String position) {
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i).getIdentifier();
            if (product.equals(position)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String viewLibrary() {
        String msg = "";

        // global variables
        String[][] newMatrix = new String[5][5];
        
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
    
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                msg += newMatrix[i][j] + " ";
            }
            msg += "\n";
        }

        return msg;
        }



}
