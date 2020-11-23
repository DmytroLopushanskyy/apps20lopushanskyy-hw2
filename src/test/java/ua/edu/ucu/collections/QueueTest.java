package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    private Queue mainQueue;
    private Queue emptyQueue;

    @Before
    public void setUp() {
        mainQueue = new Queue(new Integer[] {3, -5, 1, 5});
        emptyQueue = new Queue(new Integer[0]);
    }

    @Test
    public void testPeek() {
        assertNull(emptyQueue.peek());
        assertEquals(3, mainQueue.peek());
    }

    @Test
    public void testDequeue() {
        assertNull(emptyQueue.dequeue());
        assertEquals(3, mainQueue.dequeue());
        assertEquals(-5, mainQueue.dequeue());
    }

    @Test
    public void testEnqueue() {
        emptyQueue.enqueue(2);
        emptyQueue.enqueue(3);
        assertEquals(2, emptyQueue.peek());
    }
}
