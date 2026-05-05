package model;

import model.shot.Shot;
import util.MyLinkedList;

public interface Attacker {
    MyLinkedList<Shot> attack();
}
