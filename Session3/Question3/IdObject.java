package Session3.Question3; 

public class IdObject {
    private static int idCounter = 1;

    private final int id; 

    public IdObject(){
        this.id = idCounter++; 
    }
    
    public int getId() {
        return id;
    }
}
