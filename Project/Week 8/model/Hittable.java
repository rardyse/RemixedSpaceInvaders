package Serie_8.project.model;

import Serie_8.project.model.shot.Shot;

public interface Hittable {
    void gotHit(Shot shot);

    boolean isDead();
}
