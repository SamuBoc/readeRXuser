package model;

public class Premium extends User{


    public Premium(String id, String name, String nickname) {
        super(id, name, nickname);
        
    }


    @Override
    public String toString() {
        
        return "\nId: " +this.getId() +"\nName: " +this.getName()+ "\nNickname: " + this.getNickname()+ "\nCategory:" ;
    }
    
    
    

    
    
    
}
