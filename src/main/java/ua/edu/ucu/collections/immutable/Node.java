package ua.edu.ucu.collections.immutable;

class Node {
    private Object value;
    private Node prevNode;
    private Node nextNode;

    public Node(Object val) {
        value = val;
        prevNode = null;
        nextNode = null;
    }

    public Node(Object val, Node prevVal, Node nextVal) {
        value = val;
        prevNode = prevVal;
        nextNode = nextVal;
    }

    public void setValue(Object val) {
        this.value = val;
    }

    public void setPrevNode(Node prevN) {
        this.prevNode = prevN;
    }

    public void setNextNode(Node nextN) {
        this.nextNode = nextN;
    }

    public Object getValue() {
        return value;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public Node getNextNode() {
        return nextNode;
    }
}
