package model;

import model.shot.Shot;

public interface Hittable {
    void gotHit(Shot shot);

    boolean isDead();
}
