package Question3;

public class IdObject {
    private static int idCounter = 1;

    private int id; 

    public IdObject(){
        this.id = idCounter++; 
    }
    
    public int getId() {
        return id;
    }
}
