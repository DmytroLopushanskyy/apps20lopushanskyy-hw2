package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stackList;

    public Stack(Object[] objects) {
        Object[] swappedArray = new Object[objects.length];
        for (int i = objects.length - 1; i >= 0; i--) {
            swappedArray[objects.length - i - 1] = objects[i];
        }
        stackList = new ImmutableLinkedList(swappedArray);
    }

    Object peek() {
        // Returns the object at the beginning of the Queue without removing it
        return stackList.getFirst();
    }

    Object pop() {
        // Removes and returns the object at the beginning of the Queue.
        Object firstElement = stackList.getFirst();
        try {
            stackList = stackList.removeFirst();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return firstElement;
    }

    void push(Object e) {
        // Adds an object to the end of the Queue.
        stackList = stackList.addFirst(e);
    }
}
