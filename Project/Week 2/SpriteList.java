//4.2

package Project;

import java.util.Arrays;

public class SpriteList {

    private Sprite[] storage;
    private int size;


    //constructor
    public SpriteList() {
        storage = new Sprite[30]; //we chose 30 but it can be any other number
        size = 0;
    }

    public void remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(); //we used codingtechroom to know how to remove an index
        }
        java.lang.System.arraycopy(storage, i+1, storage, i, size-i-1); //we used stackoverflow to know how to call an arraycopy() correctly
        size--;
    }

    public int getSize() {
        return size;
    }

    public Sprite get(int i) {
        return storage[i];
    }

    public void allocateSpace() {
        storage = Arrays.copyOf(storage, storage.length * 2);
    }

    public void add(Sprite sprite) {
        if (size == storage.length) {
            allocateSpace();
        }
        storage[size] = sprite;
        size++;
    }
}