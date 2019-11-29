package Main;

import java.util.Random;

public class LandVehicle extends Vehicle {

    double gasPedal;
    double brakePedal;
    double maxSpeed = 160;

    public LandVehicle(int[] position, double speed, double direction, Enum steeringDirection, double gasPedal, double brakePedal, double health) {
        super(position, speed, direction, steeringDirection, health);
        this.gasPedal = gasPedal;
        this.brakePedal = brakePedal;
    }



    public boolean isFuelApplied(){
        if(this.gasPedal > this.brakePedal) {
            this.brakePedal = 0;
            return true;
        }else{
            this.gasPedal = 0;
            return false;
        }
    }

    public void speedControl() {
        if (this.isFuelApplied()) {
            this.speed = this.speed + (accelerationValue / gasPedal) * 100;
        } else {
            this.speed = this.speed - (accelerationValue / brakePedal) * 200;
        }
        if (this.speed < 1) {
            this.speed = 0;
        }
        if (this.speed > maxSpeed) {
            this.speed = maxSpeed;
            }
        }

    @Override
    public void run() {
        speedControl();
        changeDirection();
        updatePosition();
    }

    static LandVehicle makeRandomVehicle() {

        Random rand = new Random();

        int[] position = new int[] {rand.nextInt(10), rand.nextInt(10), 0};
        double speed = rand.nextDouble() * 100;
        double direction = rand.nextInt(10);
        double gasPedal = rand.nextDouble() * 100;
        double brakePedal = rand.nextDouble() * 100;
        Enum steeringDirection = Vehicle.getRandomDirection();
        double health = 100;
        return new LandVehicle(position, speed, direction, steeringDirection, gasPedal, brakePedal, health);
    }

    public void nudge(){
        Random rand = new Random();
        gasPedal = rand.nextDouble() * 100;
        brakePedal = rand.nextDouble() * 100;
        steeringDirection = Vehicle.getRandomDirection();
    }

    @Override
    public void print() {
        System.out.println(speed + " KM " + position[0] + "=x" + " " + position[1] + "=y " + " Fuel Percent=" + gasPedal +
                " brake percent=" + brakePedal + " Direction=" + direction + " Steering value=" + steeringDirection);
    }

}
