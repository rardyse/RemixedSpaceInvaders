package Project;

public class PlayerList {

    private Player[] players;
    private int size;

    public PlayerList(int capacity) {
        players = new Player[capacity];
        size = 0;
    }

    public void add(Player player) {
        if (size < players.length) {
            players[size] = player;
            size++;
        }
    }

    public Player get(int index) {
        if (index >= 0 && index < size) {
            return players[index];
        }
        return null;
    }

    public int size() {
        return size;
    }
}