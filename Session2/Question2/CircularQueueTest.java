package Question2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CircularQueueTest {

    @Test
    void testDeque() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        assertEquals(1, queue.deque());
        assertEquals(2, queue.deque());
        assertFalse(queue.isEmpty());
        queue.deque();
        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class,()->queue.deque());
    }

    @Test
    void testEnque() {
        CircularQueue<Integer> queue = new CircularQueue<>(2);
        queue.enque(10);
        queue.enque(20);
        assertTrue(queue.isFull());
        assertThrows(IllegalStateException.class, () -> queue.enque(30));
    }

    @Test
    void testIsEmpty() {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        assertTrue(queue.isEmpty());
        queue.enque(42);
        assertFalse(queue.isEmpty());
    }

    @Test
    void testIsFull() {
        CircularQueue<Integer> queue = new CircularQueue<>(2);
        assertFalse(queue.isFull());
        queue.enque(99);
        queue.enque(100);
        assertTrue(queue.isFull());
    }
}