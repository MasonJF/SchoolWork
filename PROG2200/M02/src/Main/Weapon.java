package Main;

public abstract class Weapon {

    int[] position;
    int damage;
    int size;

    public Weapon(int[] position, int damage, int size) {
        this.position = position;
        this.damage = damage;
        this.size = size;

    }

    public abstract void update();
}
