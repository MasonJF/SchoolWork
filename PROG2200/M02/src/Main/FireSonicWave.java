package Main;

public class FireSonicWave extends Weapon {
    double speed;
    double direction;

    public FireSonicWave(int[] position, int damage, int size, double speed, double direction) {
        super(position, damage, size);
        this.direction = direction;
        this.speed = speed;
    }


    @Override
    public void update() {
        position[1] += 1;
    }
}
