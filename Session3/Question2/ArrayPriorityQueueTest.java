package Session3.Question2; 

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArrayPriorityQueueTest {
    private ArrayPriorityQueue priorityQueue;

    @Before
    public void setUp() {
        priorityQueue = new ArrayPriorityQueue(5);
    }

    @Test
    public void testInsertAndPeek() {
        priorityQueue.insert(10);
        priorityQueue.insert(5);
        priorityQueue.insert(20);

        assertEquals(3, priorityQueue.size());
        assertEquals(20, priorityQueue.peek());
    }

    @Test
    public void testRemove() {
        priorityQueue.insert(10);
        priorityQueue.insert(5);
        priorityQueue.insert(20);

        assertEquals(20, priorityQueue.remove());
        assertEquals(10, priorityQueue.peek()); 
        assertEquals(2, priorityQueue.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(priorityQueue.isEmpty());

        priorityQueue.insert(10);
        assertFalse(priorityQueue.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveFromEmptyQueue() {
        priorityQueue.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekFromEmptyQueue() {
        priorityQueue.peek();
    }

    @Test
    public void testDynamicArrayResize() {
        priorityQueue.insert(10);
        priorityQueue.insert(20);
        priorityQueue.insert(30);
        priorityQueue.insert(40);
        priorityQueue.insert(50); 
        priorityQueue.insert(60); 

        assertEquals(6, priorityQueue.size()); 
        assertEquals(60, priorityQueue.peek());
    }
}