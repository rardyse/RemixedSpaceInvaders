package Serie_9.project.model;

import Serie_9.project.model.shot.Shot;
import Serie_9.project.util.MyLinkedList;

public interface Attacker {
    MyLinkedList<Shot> attack();
}
