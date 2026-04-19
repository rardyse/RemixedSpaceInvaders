package Serie_7.project.model;

import Serie_7.project.model.shot.Shot;

public interface Hittable {
    void gotHit(Shot shot);

    boolean isDead();
}
