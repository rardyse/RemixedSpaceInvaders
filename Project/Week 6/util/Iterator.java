package Serie_6.project.util;

import java.util.ListIterator;

public class Iterator<T> implements ListIterator<T> {

    // l'énoncé demande de créer une classe Iterator implémentant l'interface ListIterator
    // mais on ne sait pas quel devrait être le contenu exact

    // nous avons fait des recherhes sur google et on a trouvé qu'il était possible de générer
    // des méthodes standard de Java issues de ListIterator
    // on a mis un "throw new UnsupportedOperationException" vu que ça n'a pas d'importance pour le moment
    // sachant que dans le code de MyLinkedList on a :
    // "public ListIterator<T> listIterator(int index)      throw new UnsupportedOperationException();"

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T next() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasPrevious() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T previous() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(T e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(T e) {
        throw new UnsupportedOperationException();
    }
}