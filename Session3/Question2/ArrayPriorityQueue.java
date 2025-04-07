package Session3.Question2;

import java.util.Arrays;

public class ArrayPriorityQueue implements PriorityQueue {
    private int[] queue;
    private int size;

    public ArrayPriorityQueue(int capacity) {
        queue = new int[capacity];
        size = 0;
    }

    @Override
    public void insert(int element) {
        // If array is full then double the size
        if (size == queue.length) {
            queue = Arrays.copyOf(queue, queue.length * 2);
        }
        queue[size++] = element;
        Arrays.sort(queue, 0, size);
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return queue[--size];
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return queue[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}