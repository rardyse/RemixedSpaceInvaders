package serie5.Project.Model.List;

import serie5.Project.Model.Enemy.Enemy;

import java.util.Arrays;

public class EnemyList {
    private Enemy[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 20;

    public EnemyList(int capacity) {
        elements = new Enemy[DEFAULT_CAPACITY];
    }

    public void add(Enemy enemy) {
        if (size == elements.length) {
            allocateSpace();
        }
        elements[size++] = enemy;
    }

    private void allocateSpace() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void remove(int i) {
        --size;
        Enemy[] result = new Enemy[elements.length];

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