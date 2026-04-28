package Serie_9.project.model;

import Serie_9.project.model.shot.Shot;

public interface Hittable {
    void gotHit(Shot shot);

    boolean isDead();
}
