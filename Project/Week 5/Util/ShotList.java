package serie5.Project.Model.List;

import java.util.Arrays;
import serie5.Project.Model.Shots.Shot;

public class ShotList {

    private Shot[] shots;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 20;
    private Shot[] elements ;

    public ShotList() {
        elements = new Shot[DEFAULT_CAPACITY];
    }

    public void add(Shot Shot) {
        if (size == elements.length) {
            allocateSpace();
        }
        elements[size++] = Shot;
    }

    private void allocateSpace() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public Shot get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return elements[i];
    }

    public void remove(int i) {
        --size;
        Shot[] result = new Shot[elements.length];

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