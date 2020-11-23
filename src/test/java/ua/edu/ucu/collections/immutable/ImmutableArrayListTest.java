package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private Integer[] intData;

    @Test
    public void add() {  // Add one
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.add(10);

        Integer[] expectedData = new Integer[] {3, -5, 1, 5, 10};

        assertArrayEquals(intData, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void testAdd() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.add(1, 10);

        Integer[] expectedData = new Integer[] {3, 10, -5, 1, 5};

        assertArrayEquals(intData, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test  // Add multiple
    public void addAll() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.addAll(new Integer[] {3, -5, 1, 5});

        Integer[] expectedData = new Integer[] {3, -5, 1, 5, 3, -5, 1, 5};

        assertArrayEquals(intData, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void testAddAll() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.addAll(1, new Integer[] {3, -5, 1, 5});

        Integer[] expectedData = new Integer[] {3, 3, -5, 1, 5, -5, 1, 5};

        assertArrayEquals(intData, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void get() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableArrayList(intData);

        assertEquals(-5, actualArr.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnAdd() {
        ImmutableList actualArr = new ImmutableArrayList(new Integer[] {3, -5, 1, 5});
        actualArr.get(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnAddAll() {
        ImmutableList actualArr = new ImmutableArrayList(new Integer[] {3, -5, 1, 5});
        actualArr.addAll(10, new Integer[0]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnRemove() {
        ImmutableList actualArr = new ImmutableArrayList(new Integer[] {3, -5, 1, 5});
        actualArr.remove(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowErrorOnSet() {
        ImmutableList actualArr = new ImmutableArrayList(new Integer[] {3, -5, 1, 5});
        actualArr.set(10, 10);
    }

    @Test
    public void remove() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.remove(1);

        Integer[] expectedData = new Integer[] {3, 1, 5};

        assertArrayEquals(intData, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void set() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.set(1, 0);

        Integer[] expectedData = new Integer[] {3, 0, 1, 5};

        assertArrayEquals(intData, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void indexOf() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableArrayList(intData);

        assertEquals(2, actualArr.indexOf(1));
        assertEquals(-1, actualArr.indexOf(10));  // If not found
    }

    @Test
    public void size() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr = new ImmutableArrayList(intData);

        assertEquals(4, actualArr.size());
    }

    @Test
    public void clear() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.clear();

        Integer[] expectedData = new Integer[] {};

        assertArrayEquals(intData, actualArr1.toArray());
        assertArrayEquals(expectedData, actualArr2.toArray());
    }

    @Test
    public void isEmpty() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.clear();

        assertFalse(actualArr1.isEmpty());
        assertTrue(actualArr2.isEmpty());
    }

    @Test
    public void toArray() {
        intData = new Integer[] {3, -5, 1, 5};
        ImmutableList actualArr1 = new ImmutableArrayList(intData);
        ImmutableList actualArr2 = actualArr1.clear();

        assertArrayEquals(intData, actualArr1.toArray());
        assertArrayEquals(new Integer[0], actualArr2.toArray());
    }
}
