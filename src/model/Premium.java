package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

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


    @Override
    public String viewLibrary() {
        String msg = "";

        //global variables 
        int[][] newMatrix = new int[5][5];
        int comparator = 0;
        Calendar a;
        int aYear;
        ArrayList<Integer> dates = new ArrayList<Integer>();

        for(int i = 0; i<products.size(); i++){
            a = products.get(i).getPublicationDate();
            aYear = a.get(Calendar.YEAR);
            dates.add(aYear);
        }

        Collections.sort(dates, Collections.reverseOrder());

        for(int i = 0; i<5; i++){
            for(int j = 0; i< 5; i++){
                
            }
        }

        return msg; 
    }

    
}
