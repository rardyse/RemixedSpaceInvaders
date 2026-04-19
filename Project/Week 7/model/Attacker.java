package Serie_7.project.model;

import Serie_7.project.model.shot.Shot;
import Serie_7.project.util.MyLinkedList;

public interface Attacker {
    MyLinkedList<Shot> attack();
}
