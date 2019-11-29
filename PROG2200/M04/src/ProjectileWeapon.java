public class ProjectileWeapon {  // The characteristics of a projectile

    int[] position;
    double speed;
    int damage;
    int size;
    double direction;

    public ProjectileWeapon(int[] position, double speed, int damage, int size, double direction) {
        this.position = position;
        this.speed = speed;
        this.damage = damage;
        this.size = size;
        this.direction = direction;
    }

    public int[] getPosition() {
        return position;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getSize() {
        return size;
    }

    public double getDirection() {
        return direction;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
}
