package Question1; 

interface StackInterface<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
}