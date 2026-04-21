package Serie_8.project.util;

import java.util.ListIterator;

public class Iterator<T> implements ListIterator<T> {

    private Node<T> current;

    public Iterator(Node<T> startNode) {
        current = startNode;
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
    public boolean hasNext() {
        return current.next.content != null;
    }

    @Override
    public boolean hasPrevious() {
        return current.previous.content != null;
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T next() {
        current = current.next;
        return current.content;
    }

    // change le noeud courant au précédent et retourne son contenu
    @Override
    public T previous() {
        current = current.previous;
        return current.content;
    }

    @Override
    public int previousIndex() {
        return nextIndex() - 2;
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
}