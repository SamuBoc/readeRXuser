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

    @Override
    public String printMagazine() {
        String msg = "";

        for(int i= 0; i<products.size();i++){
            if(products.get(i) instanceof Magazine){
                msg += " " +  products.get(i).getIdentifier() + " " + products.get(i).getName() + " \n ";
            }
        }
        return msg; 
    }


    @Override
    public boolean magazineDelete(String position) {
        for(int i = 0; i<products.size(); i++){
            String product = products.get(i).getIdentifier();
            if(product.equals(position)){
                products.remove(i);
                return true;
            }
        }

        return false;
    }


    
}
