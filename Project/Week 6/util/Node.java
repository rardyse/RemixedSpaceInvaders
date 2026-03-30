package Serie_6.project.util;

class Node<T> {
    Node<T> previous;
    Node<T> next;
    T content;

    Node(T content) {
        this.content = content;
    }
}