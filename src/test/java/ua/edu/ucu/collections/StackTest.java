package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack mainStack;
    private Stack emptyStack;

    @Before
    public void setUp() {
        mainStack = new Stack(new Integer[] {3, -5, 1, 5});
        emptyStack = new Stack(new Integer[0]);
    }

    @Test
    public void testPeek() {
        assertNull(emptyStack.peek());
        assertEquals(5, mainStack.peek());
    }

    @Test
    public void testPop() {
        assertNull(emptyStack.pop());
        assertEquals(5, mainStack.pop());
        assertEquals(1, mainStack.pop());
    }

    @Test
    public void testPush() {
        emptyStack.push(2);
        emptyStack.push(3);
        assertEquals(3, emptyStack.peek());
    }
}
