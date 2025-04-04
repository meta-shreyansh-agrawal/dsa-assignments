package Question3;

public class Program extends IdObject {

    final private String name; 

    final private int capacity;
    private int capacityRemaining;

    public String getName() {
        return name;
    }

    public boolean hasCapacity(){
        return capacityRemaining>0; 
    }

    public void decrementCapacity(){
        capacityRemaining--; 
    }

    public Program(String name, int capacity) {
        this.name = name;
        this.capacityRemaining = capacity;
        this.capacity = capacity; 
    } 
}