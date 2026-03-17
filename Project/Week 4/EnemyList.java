package Project;

public class EnemyList {

    private Enemy[] enemies;
    private int size;

    public EnemyList(int capacity) {
        enemies = new Enemy[capacity];
        size = 0;
    }

    public void add(Enemy enemy) {
        if (size < enemies.length) {
            enemies[size] = enemy;
            size++;
        }
    }

    public Enemy get(int index) {
        if (index >= 0 && index < size) {
            return enemies[index];
        }
        return null;
    }

    public int size() {
        return size;
    }
}