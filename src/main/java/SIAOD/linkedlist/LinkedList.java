package SIAOD.linkedlist;

import java.util.StringJoiner;

public class LinkedList<T> {

    private Node<T> firstNode;
    private int size;

    LinkedList() {
        this.firstNode = new Node<>();
        size = 0;
    }

    public void add(T value) {
        Node node = firstNode;
        while(node.hasNext()) {
            node = node.getNextNode();
        }
        node.setValue(value);
        node.setNextNode(new Node());
        size++;
    }

    public T get(int index) {
        if (size <= index || index < 0) throw new IndexOutOfBoundsException(String.format("Index %s out of range", index));

        int i = 0;
        Node node = firstNode;
        do {
            if (i == index) {
                return (T) node.getValue();
            } else {
                node = node.getNextNode();
                i++;
            }
        } while(node.hasNext());
        return null;
    }

    public void remove(int index) {
        if (size <= index || index < 0) throw new IndexOutOfBoundsException(String.format("Index %s out of range", index));

        // remove the first node
        if (index == 0) {
            this.firstNode = firstNode.getNextNode();
            size--;
            return;
        }

        Node previousNode = firstNode;
        Node node = previousNode.getNextNode();
        int i = 1;

        do {
            if (i == index) {
                previousNode.setNextNode(node.getNextNode());
                size--;
                return;
            } else {
                previousNode = node;
                node = node.getNextNode();
                i++;
            }
        } while(node.hasNext());
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        Node node = firstNode;
        while(node.hasNext()) {
            joiner.add(node.getValue().toString());
            node = node.getNextNode();
        }
        return joiner.toString();
    }

    Iterator getIterator() {
        return new Iterator();
    }


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        LinkedList.Iterator iterator = list.getIterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    class Iterator implements java.util.Iterator<T> {

        Node node;

        Iterator() {
            this.node = firstNode;
        }

        @Override
        public boolean hasNext() {
            return node.hasNext();
        }

        @Override
        public T next() {
            T value = (T) node.getValue();
            node = node.getNextNode();
            return value;
        }
    }
}
