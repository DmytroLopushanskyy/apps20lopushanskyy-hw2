package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queueList;

    public Queue(Object[] objects) {
        queueList = new ImmutableLinkedList(objects);
    }

    Object peek() {
        // Returns the object at the beginning of the Queue without removing it
        return queueList.getFirst();
    }

    Object dequeue() {
        // Removes and returns the object at the beginning of the Queue.
        Object firstElement = queueList.getFirst();
        try {
            queueList = queueList.removeFirst();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return firstElement;
    }

    void enqueue(Object e) {
        // Adds an object to the end of the Queue.
        this.queueList = queueList.addLast(e);
    }
}
