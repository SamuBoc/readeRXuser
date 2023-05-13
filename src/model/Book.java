package model;

import java.util.Calendar;

public class Book extends Products{

    private String id;
    private String review;
    private GenreBook genreBook ;
    private double price;
    private Calendar publicationDate;

    public Book(String name, int numberPages, Calendar publicationDate, String url, String id, String review, int genreBook, double price) {
        super(name, numberPages, publicationDate, url);
        //TODO Auto-generated constructor stub

        switch (genreBook) {
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

        this.id = id;
        this.review = review; 
        this.price = price;
        this.publicationDate = publicationDate;

    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    
    
}
