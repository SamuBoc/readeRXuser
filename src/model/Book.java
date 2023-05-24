package model;
import java.util.Calendar;

public class Book extends Products{

    private String review;
    private GenreBook genreBook ;
    private double price;
    private Calendar publicationDate;
    private double totalsold;
    
    
    public Book(String name, int numberPages, Calendar publicationDate, String url, String review, int i, double price, String identifier) {
        super(name, numberPages, url, publicationDate, identifier);
        //TODO Auto-generated constructor stub

        switch (i) {
            case 1:
                this.genreBook = GenreBook.SCIENCE_FICTION;
                break;
            case 2: 
                this.genreBook = GenreBook.FANTASY;
                break;
            case 3:
                this.genreBook = GenreBook.HISTORICAL_NOVELS;
                break;
        
            default:
                break;
        }

        this.review = review; 
        this.price = price;
        this.publicationDate = publicationDate;
        this.totalsold = 0;

    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public GenreBook getGenreBook() {
        return genreBook;
    }

    public void setGenreBook(GenreBook genreBook) {
        this.genreBook = genreBook;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public Calendar getPublicationDate() {
        return publicationDate;
    }



    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String toString(){

        String msg = "";

        msg = "" + getName() + "  |  " + " Book " ;

        return msg;
        
    }



    public double getTotalsold() {
        return totalsold;
    }



    public void setTotalsold(double totalsold) {
        this.totalsold = totalsold;
    }


    

}
