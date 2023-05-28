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
        int yearComparator = products.get(0).getPublicationDate().get(Calendar.YEAR);
        int monthComparator = products.get(0).getPublicationDate().get(Calendar.MONTH);
        int dayComparator = products.get(0).getPublicationDate().get(Calendar.DAY_OF_MONTH);
        Calendar a;
        int aYear = 0;
        int aMonth = 0;
        int aDay = 0;

        ArrayList<String> dates = new ArrayList<String>();

        for (int i = 0; i < products.size(); i++) {

            a = products.get(i).getPublicationDate();
            aMonth = a.get(Calendar.MONTH);
            aDay = a.get(Calendar.DAY_OF_MONTH);
            aYear = a.get(Calendar.YEAR);
        
            for (int j = 0; j < products.size(); j++) {
                if (aYear >= yearComparator) {
                    if (aYear > yearComparator) {
                        yearComparator = aYear;
                        monthComparator = aMonth;
                        dayComparator = aDay;
                        dates.add(0, products.get(i).getIdentifier());
                    } else {
                        if (aMonth >= monthComparator) {
                            if (aMonth > monthComparator) {
                                yearComparator = aYear;
                                monthComparator = aMonth;
                                dayComparator = aDay;
                                dates.add(0, products.get(i).getIdentifier());
                            } else {
                                if (aDay >= dayComparator) {
                                    if (aDay > dayComparator) {
                                        yearComparator = aYear;
                                        monthComparator = aMonth;
                                        dayComparator = aDay;
                                        dates.add(0, products.get(i).getIdentifier());
                                    }
                                }
                            }
                        }
                    }
                }else{
                    dates.add(products.get(i).getIdentifier());
                }
            }
        }

        

        int empies = dates.size() - 25;

        for(int i = 0; i<empies; i++){
            dates.add("__");
        }

        int index = 0;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (index < dates.size()) {
                    newMatrix[i][j] = dates.get(index);
                    index++;
                } else {
                    newMatrix[i][j] = "__";
                }
            }
        }

        for (int i = 0; i < newMatrix.length; i++) { // filas numbers.length
			for (int j = 0; j < newMatrix[0].length; j++) { // columnas numbers[0].length
				msg += newMatrix[i][j] + " ";
			}
			msg += "\n";
		}
        
            
        return msg;
        }

}
