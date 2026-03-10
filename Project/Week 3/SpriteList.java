package Project;

import java.util.Arrays;

public class SpriteList {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Sprite[] elements;

    public SpriteList() {
        elements = new Sprite[DEFAULT_CAPACITY];
    }

    public void add(Sprite sprite) {
        if (size == elements.length) {
            allocateSpace();
        }
        elements[size++] = sprite;
    }

    private void allocateSpace() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public Sprite get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return elements[i];
    }

    public void remove(int i) {
        --size;
        Sprite[] result = new Sprite[elements.length];

        System.arraycopy(elements, 0, result, 0, i);
        System.arraycopy(elements, i + 1, result, i, size - i);
        elements = result;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
