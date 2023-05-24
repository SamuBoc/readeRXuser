package model;

import java.util.Calendar;

public class Magazine extends Products{

    private CategoryMagazine categoryMagazine;
    private double valueSuscription;
    private Periodicity periodicity;
    private int activeSuscription;

    public Magazine(String name, int numberPages, Calendar publicationDate, String url, int categoryMagazine, double valueSuscription, int periodicity, String identifier) {
        super(name, numberPages, url, publicationDate, identifier);
        //TODO Auto-generated constructor stub

        //VARIETY , SCIENTIFIC , DESIGN
        switch (categoryMagazine) {
            case 1:
                this.categoryMagazine = CategoryMagazine.VARIETY;
                break;
            case 2:
                this.categoryMagazine = CategoryMagazine.SCIENTIFIC;
                break;
            case 3:
                this.categoryMagazine = CategoryMagazine.DESIGN;
                break;
            default:
                break;
        }

        //WEEKLY , MONTHLY , BIWEEKLY
        switch (periodicity) {
            case 1:
                this.periodicity = Periodicity.WEEKLY;
                break;
            case 2:
                this.periodicity = Periodicity.MONTHLY;
                break;
            case 3:
                this.periodicity = Periodicity.BIWEEKLY;
                break;
            default:
                break;
        }

        this.valueSuscription = valueSuscription;

    }

    public CategoryMagazine getCategoryMagazine() {
        return categoryMagazine;
    }

    public void setCategoryMagazine(CategoryMagazine categoryMagazine) {
        this.categoryMagazine = categoryMagazine;
    }

    public double getValueSuscription() {
        return valueSuscription;
    }

    public void setValueSuscription(double valueSuscription) {
        this.valueSuscription = valueSuscription;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public int getActiveSuscription() {
        return activeSuscription;
    }

    public void setActiveSuscription(int activeSuscription) {
        this.activeSuscription = activeSuscription;
    }
    
    public String toString(){

        String msg = "";

        msg = "" + getName() + "  |  " + " Mazagine " ;

        return msg;

    }

    

}
