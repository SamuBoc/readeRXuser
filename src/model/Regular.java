package model;

public class Regular extends User{

    private Book[] books;
    private Magazine[] magazine;

    public Regular(String id, String name, String nickname) {
        super(id, name, nickname);
        //TODO Auto-generated constructor stub

        books = new Book[5];
        magazine = new Magazine[2];

    }

    @Override
    public String toString() {
        
        return "Id: " +this.getId() +"\nName: " +this.getName()+ "\nNickname: " + this.getNickname()+ "\nCategory: Regular" ;

    }

    @Override
    public Boolean addBook(Book product) {
       for(int i = 0; i<books.length; i++){
        if(books[i] != null){
            books[i] = product;
            return true;
        }
       }
    return false;
    }

    @Override
    public Boolean addMagazine(Magazine product) {
        for(int i = 0; i<magazine.length; i++){
            if(magazine[i] != null){
                magazine[i] = product;
                return true;
            }
           }
        return false;
    }

    @Override
    public String printMagazine() {
        String msg = "";

        for(int i= 0; i<magazine.length;i++){
            if(magazine[i] != null){
                msg += " " +  magazine[i].getIdentifier() + " " + magazine[i].getName() + " \n ";
            }
        }
        return msg; 
    }

    @Override
    public boolean magazineDelete(String position) {
        for(int i = 0; i<magazine.length; i++){
            String product = magazine[i].getIdentifier();
            if(product.equals(position)){
                magazine[i] = null;
                return true;
            }
        }
        

        return false;
    }

}
