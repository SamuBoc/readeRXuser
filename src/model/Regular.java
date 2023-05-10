package model;

public class Regular extends User {

    public Regular(String id, String name, String nickname) {
        super(id, name, nickname);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        
        return "\nId: " +this.getId() +"\nName: " +this.getName()+ "\nNickname: " + this.getNickname()+ "\n";
    }
    
}
