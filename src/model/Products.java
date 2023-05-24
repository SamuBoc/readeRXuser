package model;

import java.util.Calendar;

public abstract class Products {
    
	private String name;
	private int numberPages;
	private Calendar publicationDate;
    private String url; 
    private int totalPages;
    private String identifier;

	public Products(String name, int numberPages,String url , Calendar publicationDate, String identifier) {
		super();

		this.name = name;
        this.numberPages = numberPages;
        this.publicationDate = publicationDate;
        this.url = url;
        this.totalPages = 0;
        this.identifier = identifier;
       
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    

}
