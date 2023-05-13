package model;

import java.util.Calendar;

public class Products {
    
	private String name;
	private int numberPages;
	private Calendar publicationDate;
    private String url; 
    private int totalPages;

	public Products(String name, int numberPages, Calendar publicationDate,String url ) {
		super();
		this.name = name;
        this.numberPages = numberPages;
        this.publicationDate = publicationDate;
        this.url = url;
        this.totalPages = 0;
       
	}
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public int getTotalPages() {
        return totalPages;
    }



    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    

}
