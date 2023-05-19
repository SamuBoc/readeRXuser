package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Bill {
    
    private String id;
    private Calendar dateSold;
    private String name;
    private double quantityTransaction;

    public Bill(String id, String name, double quantityTransaction){

        
		Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1; // 0-based
        int year = calendar.get(Calendar.YEAR);
        Calendar datePublication = new GregorianCalendar(year, month, day);


        this.dateSold = datePublication;
        this.quantityTransaction = quantityTransaction;
        this.id = id;
        this.name = name; 
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getDateSold() {
        return dateSold;
    }

    public void setDateSold(Calendar dateSold) {
        this.dateSold = dateSold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantityTransaction() {
        return quantityTransaction;
    }

    public void setQuantityTransaction(double quantityTransaction) {
        this.quantityTransaction = quantityTransaction;
    }



}
