package Question2;

public interface Queue<T> {

    // Enter value to the Queue
    public void enque(T value);
    
    // Remove value from the Queue
    public T deque(); 

    // Checking if Queue is Empty
    public boolean isEmpty(); 

    // Checking if Queue is Full
    public boolean isFull(); 
}