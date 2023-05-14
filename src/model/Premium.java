package model;

import java.util.ArrayList;

public class Premium extends User{

    private ArrayList<Products> products;
    

    public Premium(String id, String name, String nickname) {
        super(id, name, nickname);
        products = new ArrayList<Products>();
    }


    @Override
    public String toString() {
        
        return "Id: " +this.getId() +"\nName: " +this.getName()+ "\nNickname: " + this.getNickname()+ "\nCategory: Premium" ;
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


}
