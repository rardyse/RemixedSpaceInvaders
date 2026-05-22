package project.model;

import project.model.shot.Shot;

public interface Hittable {
    void gotHit(Shot shot);

    boolean isDead();
}
