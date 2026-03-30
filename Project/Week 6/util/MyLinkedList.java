package Serie_6.project.util;

// le but est d'enlever toutes les List déjà existantes (EnemyList, PlayerList, SpriteList, ShotList)
// ça les regroupe toutes ici

import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class MyLinkedList<T> extends AbstractSequentialList<T> {

    // head and tail (la base de la liste)
    final Node<T> head;
    final Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.previous = head;
        size = 0;
    }

    // maintenant on override les méthodes depuis AbstractSequentialList

    // add(T e)
    @Override
    public boolean add(T element) {
        Node<T> bob = new Node<>(element);
        bob.next = tail;
        bob.previous = tail.previous;
        tail.previous.next = bob;
        tail.previous = bob;
        size++;
        return true;
    }

    // remove(Object o)
    @Override
    public boolean remove(Object o) {
        Node<T> current = head.next;
        while (current != tail) {
            if (current.content.equals(o)) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // get(int index)
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<T> current = head.next;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.content;
    }

    // size()
    @Override
    public int size() {
        return size;
    }

    // listIterator(int index)
    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }
}