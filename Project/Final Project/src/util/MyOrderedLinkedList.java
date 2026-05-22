package project.util;

import project.util.MyLinkedList;

public class MyOrderedLinkedList<T extends Comparable<T>> extends MyLinkedList<T> {

    public T getMax() {
        T max = get(0);
        for (int i = 1; i < size(); i++) {
            if (get(i).compareTo(max) > 0) {
                max = get(i);
            }
        }
        return max;
    }


    public T getMin() {
        T min = get(0);
        for (int i = 1; i < size(); i++) {
            if (get(i).compareTo(min) < 0) {
                min = get(i);
            }
        }
        return min;
    }
}
