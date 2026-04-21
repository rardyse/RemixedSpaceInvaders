package Serie_8.project.model;

import Serie_8.project.model.shot.Shot;
import Serie_8.project.util.MyLinkedList;

public interface Attacker {
    MyLinkedList<Shot> attack();
}
