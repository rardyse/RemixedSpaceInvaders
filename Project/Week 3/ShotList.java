package Project;

public class ShotList {

    private Shot[] shots;
    private int size;

    public ShotList(int capacity) {
        shots = new Shot[capacity];
        size = 0;
    }

    public void add(Shot shot) {
        if (size < shots.length) {
            shots[size] = shot;
            size++;
        }
    }

    public Shot get(int index) {
        if (index >= 0 && index < size) {
            return shots[index];
        }
        return null;
    }

    public int size() {
        return size;
    }
}