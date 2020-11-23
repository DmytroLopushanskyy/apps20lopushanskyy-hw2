package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

class Node {
    public Object value;
    public Node prevNode;
    public Node nextNode;

    public Node(Object val, Node prevVal, Node nextVal) {
        value = val;
        prevNode = prevVal;
        nextNode = nextVal;
    }

    public Node(Object val) {
        value = val;
        prevNode = null;
        nextNode = null;
    }
}

public class ImmutableLinkedList implements ImmutableList {
    private Node first;
    private Node last;
    private int linkedListSize;

    public ImmutableLinkedList(Object[] objects) {
        linkedListSize = objects.length;

        if (objects.length == 0) {
            first = null;
            return;
        }

        first = new Node(objects[0]);

        Node current = first;
        int count = 0;
        for (Object obj: objects) {
            if (count == 0) {
                count++;
                continue;
            }
            Node newNode = new Node(obj, current, null);
            current.nextNode = newNode;
            current = newNode;
            count++;
        }

        last = current;
    }

    public ImmutableLinkedList(Node firstNode, Node lastNode, int size) {
        if (firstNode == null) {
            this.first = null;
            this.last = null;
            this.linkedListSize = 0;
            return;
        }
        this.first = new Node(firstNode.value);
        Node oldCurrent = firstNode;
        Node newCurrent = this.first;
        while (oldCurrent.nextNode != null) {
            newCurrent.nextNode = new Node(oldCurrent.nextNode.value);
            newCurrent.nextNode.prevNode = newCurrent;
            newCurrent = newCurrent.nextNode;
            oldCurrent = oldCurrent.nextNode;
        }
        this.last = newCurrent;
        this.linkedListSize = size;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(linkedListSize, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(linkedListSize, c);
    }

    private boolean addElementsAtPositionIfNeeded(int counter, int index, Node current, Object[] e) {
        if (counter == index) {
            Node newNode = new Node(e[0], current, null);  // Create new Node
            Node continueNode;
            if (current.nextNode != null) {
                // Node to link to after addition is finished
                continueNode = new Node(current.nextNode.value, null, current.nextNode.nextNode);
            } else {
                continueNode = null;
            }
            current.nextNode = newNode;  // Set new element as next
            current = newNode;
            int innerCount = 0;
            for (Object obj: e) {
                if (innerCount == 0) {
                    innerCount++;
                    continue;
                }
                current.nextNode = new Node(obj, current, null);
                current = current.nextNode;
                innerCount++;
            }
            if (continueNode != null) {
                current.nextNode = continueNode;
                continueNode.prevNode = current;
            }
            return true;
        }
        return false;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > linkedListSize) {
            throw new IndexOutOfBoundsException();
        }

        if (first == null) {
            return new ImmutableLinkedList(c);
        }

        ImmutableLinkedList newList = new ImmutableLinkedList(first, last, linkedListSize + c.length);

        Node current = newList.first;

        for (int counter = 0; counter < linkedListSize; counter++) {
            if (addElementsAtPositionIfNeeded(counter, index - 1, current, c)) {
                break;
            }
            if (counter != linkedListSize - 1) {
                current = current.nextNode;
            }
        }
        if (addElementsAtPositionIfNeeded(linkedListSize, index, current, c)) {
            newList.last = current.nextNode;
        }
        System.out.println("lala " + Arrays.toString(newList.toArray()));
        return newList;
    }

    @Override
    public Object get(int index) {
        if (index >= linkedListSize || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        Node current = first;
        int counter = 0;
        while (current.nextNode != null) {
            if (counter == index) {
                break;
            }
            current = current.nextNode;
            counter++;
        }
        return current.value;
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= linkedListSize || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        ImmutableLinkedList newList = new ImmutableLinkedList(first, last, linkedListSize - 1);

        if (index == 0) {  // Corner case. Remove first
            newList.first = newList.first.nextNode;
            return newList;
        } else if (index == linkedListSize - 1) {  // Corner case. Remove last
            newList.last = newList.last.prevNode;
            newList.last.nextNode = null;
            return newList;
        }

        int counter = 0;
        Node current = newList.first;

        while (current != null) {
            if (counter == index) {
                current.prevNode.nextNode = current.nextNode;
                current.nextNode.prevNode = current.prevNode;
                break;
            }
            current = current.nextNode;
            counter++;
        }
        return newList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= linkedListSize) {
            throw new IndexOutOfBoundsException();
        }

        ImmutableLinkedList newList = new ImmutableLinkedList(first, last, linkedListSize);

        Node current = newList.first;
        int counter = 0;
        while (current.nextNode != null) {
            if (counter == index) {
                current.value = e;
                break;
            }
            current = current.nextNode;
            counter++;
        }
        return newList;
    }

    @Override
    public int indexOf(Object e) {
        Node current = first;
        int counter = 0;
        while (current.nextNode != null) {
            if (current.value.equals(e)) {
                return counter;
            }
            current = current.nextNode;
            counter++;
        }
        return -1;
    }

    @Override
    public int size() {
        return linkedListSize;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList(new Object[0]);
    }

    @Override
    public boolean isEmpty() {
        return linkedListSize == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] objArray = new Object[linkedListSize];
        Node current = first;

        System.out.println(linkedListSize);
        for (int counter = 0; counter < linkedListSize; counter++) {
            objArray[counter] = current.value;
            current = current.nextNode;
        }
        return objArray;
    }

    public ImmutableLinkedList addFirst(Object e) {
        ImmutableLinkedList newList = new ImmutableLinkedList(first, last, linkedListSize + 1);

        Node newNode = new Node(e, null, newList.first);
        if (newList.first != null) {
            newList.first.prevNode = newNode;
            newList.first = newNode;
        }else {
            newList.first = newList.last = newNode;
        }

        return newList;
    }

    public ImmutableLinkedList addLast(Object e) {
        ImmutableLinkedList newList = new ImmutableLinkedList(first, last, linkedListSize + 1);

        Node newNode = new Node(e, newList.last, null);
        if (newList.last != null) {
            newList.last.nextNode = newNode;
            newList.last = newNode;
        } else {
            newList.first = newList.last = newNode;
        }

        return newList;
    }

    public Object getFirst() {
        if (first == null) {
            return null;
        }
        return first.value;
    }

    public Object getLast() {
        if (last == null) {
            return null;
        }
        return last.value;
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(linkedListSize - 1);
    }
}
