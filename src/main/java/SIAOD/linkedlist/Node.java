package SIAOD.linkedlist;

class Node<T> {

    T value;
    Node nextNode;

    Node() {
        this.value = null;
        this.nextNode = null;
    }

    Node(T value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    Node(T value) {
        this.value = value;
        this.nextNode = null;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    Node getNextNode() {
        return nextNode;
    }

    void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }


    boolean hasNext() {
        return nextNode != null;
    }
}
