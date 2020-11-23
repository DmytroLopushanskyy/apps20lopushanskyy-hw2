package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class ImmutableLinkedListTest {
    private Integer[] intData;

    @Test
    public void add() {  // Add one
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList actualList2 = actualList1.add(10);

        Integer[] expectedData = new Integer[] {3, -5, 1, 5, 10};

        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void testAdd() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList actualList2 = actualList1.add(2, 10);

        Integer[] expectedData = new Integer[] {3, -5, 10, 1, 5};

        System.out.println(Arrays.toString(actualList1.toArray()));
        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test  // Add multiple
    public void addAll() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList actualList2 = actualList1.addAll(new Integer[] {3, -5, 1, 5});

        Integer[] expectedData = new Integer[] {3, -5, 1, 5, 3, -5, 1, 5};

        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void testAddAll() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList emptyList = new ImmutableLinkedList(new Integer[0]);
        ImmutableList actualList2 = actualList1.addAll(1, new Integer[] {3, -5, 1, 5});
        ImmutableList filledList = emptyList.addAll(0, new Integer[] {3, -5, 1, 5});

        Integer[] expectedData = new Integer[] {3, 3, -5, 1, 5, -5, 1, 5};

        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
        assertArrayEquals(intData, filledList.toArray());
    }

    @Test
    public void testGet() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableLinkedList(intData);
        ImmutableLinkedList emptyArr = new ImmutableLinkedList(new Integer[0]);

        assertEquals(-5, actualArr.get(1));
        assertNull(emptyArr.getFirst());
        assertNull(emptyArr.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnAdd() {
        ImmutableList actualArr = new ImmutableLinkedList(new Integer[] {3, -5, 1, 5});
        actualArr.get(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnAddAll() {
        ImmutableList actualArr = new ImmutableLinkedList(new Integer[] {3, -5, 1, 5});
        actualArr.addAll(10, new Integer[0]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnRemove() {
        ImmutableList actualArr = new ImmutableLinkedList(new Integer[] {3, -5, 1, 5});
        actualArr.remove(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnSet() {
        ImmutableList actualArr = new ImmutableLinkedList(new Integer[] {3, -5, 1, 5});
        actualArr.set(10, 10);
    }

    @Test
    public void remove() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList actualList2 = actualList1.remove(2);

        Integer[] expectedData = new Integer[] {3, -5, 5};

        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void set() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList actualList2 = actualList1.set(1, 0);

        Integer[] expectedData = new Integer[] {3, 0, 1, 5};

        assertArrayEquals(intData, actualList1.toArray());
        System.out.println(Arrays.toString(actualList2.toArray()));
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void indexOf() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableLinkedList(intData);

        assertEquals(2, actualArr.indexOf(1));
        assertEquals(-1, actualArr.indexOf(10));  // If not found
    }

    @Test
    public void size() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableLinkedList(intData);

        assertEquals(4, actualArr.size());
    }

    @Test
    public void clear() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList actualList2 = actualList1.clear();

        Integer[] expectedData = new Integer[] {};

        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
    }

    @Test
    public void isEmpty() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList actualList2 = actualList1.clear();

        assertFalse(actualList1.isEmpty());
        assertTrue(actualList2.isEmpty());
    }

    @Test
    public void toArray() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualList1 = new ImmutableLinkedList(intData);
        ImmutableList actualList2 = actualList1.clear();

        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(new Integer[0], actualList2.toArray());
    }

    @Test
    public void testAddFirst() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableLinkedList actualList1 = new ImmutableLinkedList(intData);
        ImmutableLinkedList emptyList = new ImmutableLinkedList(new Integer[0]);
        ImmutableLinkedList emptyList2 = emptyList.addFirst(10);
        ImmutableLinkedList actualList2 = actualList1.addFirst(10);
        ImmutableLinkedList actualList3 = actualList2.removeFirst();

        Integer[] expectedData = new Integer[] {10, 3, -5, 1, 5};

        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
        assertEquals(10, actualList2.getFirst());
        assertEquals(10, emptyList2.getFirst());
        assertArrayEquals(intData, actualList3.toArray());
    }

    @Test
    public void testAddLast() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableLinkedList actualList1 = new ImmutableLinkedList(intData);
        ImmutableLinkedList actualList2 = actualList1.addLast(10);
        ImmutableLinkedList actualList3 = actualList2.removeLast();

        Integer[] expectedData = new Integer[] {3, -5, 1, 5, 10};

        assertArrayEquals(intData, actualList1.toArray());
        assertArrayEquals(expectedData, actualList2.toArray());
        assertEquals(10, actualList2.getLast());
        assertArrayEquals(intData, actualList3.toArray());
    }
}

