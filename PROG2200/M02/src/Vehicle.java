import java.util.Random;

public abstract class Vehicle implements Health{
    int[] position;
    double health;
    double speed;
    double direction;
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
    public abstract void speedControl();


}
