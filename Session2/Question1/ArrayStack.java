package Question1; 
import java.util.*;


public class ArrayStack<E> implements StackInterface<E> {
    private List<E> elements = new ArrayList<>();

    @Override
    public void push(E item) {
        elements.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
