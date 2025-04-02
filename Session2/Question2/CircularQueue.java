package Question2;

public class CircularQueue<T> implements Queue<T> {

    private T[] arr; 
    private int front,rear,size,capacity; 

    /**
     * Creating Queue
     * @param capacity is max size of the queue
     * @throws IllegalArgumentException when Invalid capacity is input
     */
    CircularQueue(int capacity)throws IllegalArgumentException{
        if(capacity<1)throw new IllegalArgumentException("Enter valid size of queue"); 
        this.capacity = capacity; 
        this.size = 0; 
        this.front = 0; 
        this.rear = -1;
        arr = (T[])new Object[capacity]; 
    }

    /**
     * Adding value to the Queue
     * @param value to be added to Queue
     * @throws IllegalStateException when Queue is Full
     */
    @Override
    public void enque(T value)throws IllegalStateException {
        if(isFull())throw new IllegalStateException("Queue is Full"); 
        rear = (rear+1)%capacity; 
        arr[rear] = value; 
        size++; 
    }

    /**
     * Removing value from the Queue
     * @throws IllegalStateException when Queue is Empty
     * @return Value that is removed
     */
    @Override
    public T deque() throws IllegalStateException {
        if(isEmpty())throw new IllegalStateException("Queue is Empty"); 
        T temp = arr[front]; 
        arr[front] = null; 
        front = (front+1)%capacity; 
        size--; 
        return temp; 
    }

    /**
     * Check if Queue is Empty
     * @return true if Queue is empty else False
     */
    @Override
    public boolean isEmpty() {
        return size == 0; 
    }

    /**
     * Check if Queue is Full
     * @return true if Queue is full else false
     */
    @Override
    public boolean isFull() {
        return size == capacity; 
    }
}
