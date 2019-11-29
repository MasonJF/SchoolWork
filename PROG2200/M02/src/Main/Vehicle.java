package Main;

import java.util.Random;

public abstract class Vehicle implements Health, Attack {
    int[] position;
    double health;
    double speed; // Speed of Vehicles.
    double direction; // Direction of travel on virtual plane
    double accelerationValue = 5;
    double maxDirection = 15;
    double minDirection = -15;
    int maxHeight = 500;
    int maxThresholdX = 100;
    int maxThresholdY = 1000;
    int minThresholdY = 0;
    Enum steeringDirection;

    enum steeringWheel {
        LEFT, CENTER, RIGHT
    }

    public Vehicle(int[] position, double speed, double direction, Enum steeringDirection, double health) {
        this.position = position;
        this.speed = speed;
        this.direction = direction;
        this.steeringDirection = steeringDirection;
        this.health = health;
    }

    public static Enum getRandomDirection(){
        Random random = new Random();
        return steeringWheel.values()[random.nextInt(steeringWheel.values().length)];
    }

    public void changeDirection() {
        if(steeringDirection == steeringWheel.LEFT){
            direction -= 1;
            if(this.direction <= minDirection) {
                direction = minDirection;
            }
        }
        if(steeringDirection == steeringWheel.RIGHT) {
            direction += 1;
            if(this.direction >= maxDirection) {
                direction = maxDirection;
            }
        }

        if(this.speed == 0) {
            this.direction = 0;
            this.steeringDirection = steeringWheel.CENTER;
        }

    }

    public void updatePosition() {
        if(this.direction > 0) {
            this.position[0] += (direction / 5);
        }
        if(this.direction < 0) {
            this.position[0] += (direction / 5);
        }
        if(this.speed > 0) {
            this.position[1] += this.speed / 10;
        }
        boundaries();
    }

    public void boundaries() {
        if (this.position[0] < -maxThresholdX) {
            this.position[0] = maxThresholdX;
        }
        if (this.position[0] > maxThresholdX) {
            this.position[0] = -maxThresholdX;
        }
        if (this.position[1] > maxThresholdY) {
            this.position[1] = minThresholdY;
        }
        if (this.position[2] > maxHeight) {
            this.position[2] = maxHeight;
        }
    }

    public void onHit(int i) {
        this.health -= i;
    }

    public void onRepair() {
        this.health = 100;
    }

    @Override
    public Weapon fireWeapon() {
        Random rand = new Random();
        int weapon = rand.nextInt(4);
        switch(weapon) {
            case 0:
                double speedFaster = this.speed + 20;
                int[] bulletPosition = this.position.clone();
                int bulletDamage = 10;
                int bulletSize = 1;
                return new FireBullet(bulletPosition, bulletDamage, bulletSize, speedFaster, direction);
            case 1:
                double speedSlower = this.speed - 30;
                int[] wavePosition = this.position.clone();
                int waveDamage = 5;
                int waveSize = 7;
                return new FireSonicWave(wavePosition, waveDamage, waveSize, speedSlower, direction);
            case 2:
                int mineDamage = 25;
                int mineSize = 10;
                return new RearDefenseMine(position.clone(), mineDamage, mineSize);
            case 3:
                int blastDamage = 5;
                int blastSize = 5;
                return new ChimneyBlast(position.clone(), blastDamage, blastSize);
            default:
                return null;
        }
    }

    public abstract void speedControl();

    public abstract void run();

    public abstract void nudge();

    public abstract void print();
}
