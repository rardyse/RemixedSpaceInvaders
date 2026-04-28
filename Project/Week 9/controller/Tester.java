package Serie_9.project.controller;

import oop.lib.Animation;
import Serie_9.project.model.Direction;
import Serie_9.project.model.enemy.AlienShip;
import Serie_9.project.model.player.Player;
import Serie_9.project.model.shot.Bomb;
import Serie_9.project.util.Point;
import Serie_9.project.util.Vector;

import java.io.IOException;

public class Tester extends Animation {

    private AlienShip alien = null;
    private Player player = null;
    private Bomb bomb = null;

    public static void main(String[] args) {
        new Tester().launch(true);
    }

    @Override
    public void init() {
        super.init();
        try {
            Point alienPos = new Point(AlienShip.ALIEN_INIT_POS);
            alienPos.translate(new Vector(100, 100));
            alien = new AlienShip(alienPos);
            player = new Player(new Point(400, 200));
            bomb = new Bomb(new Point(200, 200), Direction.DOWN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(alien);
        add(player);
        add(bomb);
    }

    @Override
    protected void step() {
        alien.move(Direction.RIGHT);
        player.move(Direction.LEFT);
        bomb.move();
    }
}