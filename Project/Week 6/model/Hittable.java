package Serie_6.project.model;

import Serie_6.project.model.shot.Shot;

public interface Hittable {
    void gotHit(Shot shot);

    boolean isDead();
}
