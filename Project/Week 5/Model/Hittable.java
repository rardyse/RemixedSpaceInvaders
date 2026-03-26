package serie5.Project.Model.Shots;

//Permet au joueur et à l'ennemi de tirer

public interface Hittable {
    void isHit(Shot shot);
    boolean isDead();
}
