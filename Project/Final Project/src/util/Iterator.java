package project.util;

import java.util.ListIterator;

public class Iterator<T> implements ListIterator<T> {

    private Node<T> current;

    public Iterator(Node<T> startNode) {
        current = startNode.previous; //démarre avant le startNode
    }

    @Override
    public boolean hasNext() {
        return current.next.content != null; //null = tail
    }

    @Override
    public T next() {
        current = current.next;
        return current.content;
    }

    @Override
    public boolean hasPrevious() {
        return current.previous.content != null; // null = head
    }

    @Override
    public T previous() {
        current = current.previous;
        return current.content;
    }

    @Override
    public void add(T e) {
        Node<T> bob = new Node<>(e);
        bob.previous = current;
        bob.next = current.next;
        current.next.previous = bob;
        current.next = bob;
        current = bob;
    }

    @Override
    public void remove() {
        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    @Override
    public void set(T e) {
        current.content = e;
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() {
        return nextIndex() - 2;
    }
}