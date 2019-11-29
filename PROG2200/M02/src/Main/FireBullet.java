package Main;

public class FireBullet extends Weapon {
    double speed;
    double direction;

    public FireBullet(int[] position, int damage, int size, double speed, double direction) {
        super(position, damage, size);
        this.speed = speed;
        this.direction = direction;
    }


    @Override
    public void update() {
        position[1] += 3;
    }
}
