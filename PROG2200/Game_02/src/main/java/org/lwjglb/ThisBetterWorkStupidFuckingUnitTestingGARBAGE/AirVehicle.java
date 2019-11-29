package org.lwjglb.ThisBetterWorkStupidFuckingUnitTestingGARBAGE;

import org.joml.Vector3f;

import java.util.Random;

public class AirVehicle extends Vehicle {


    //todo Make this class use GameItem's coord system instead of storing locally.
    double propSpeed;
    double verticalDirection;
    double minVertDir = -25;
    double maxVertDir = 25;
    Enum tiltDirection;
    double maxSpeed = 320;
    double minSpeed = 70;

    enum pullWheel {
        BACK, FORTH
    }

    public AirVehicle(Vector3f position, double speed, double direction, Enum steeringDirection, Enum tiltDirection, double propSpeed, double health) {
        super(position, speed, direction, steeringDirection, health);
        this.tiltDirection = tiltDirection;
        this.propSpeed = propSpeed;

    }


    public void speedControl() {
        if (this.propSpeed > 50) {
            this.speed = this.speed + (accelerationValue/propSpeed) * 100;
        } else {
            this.speed = this.speed - (accelerationValue/propSpeed) * 33;
        }
        if (this.speed > maxSpeed) {
            this.speed = maxSpeed;
        }
        if (this.speed < minSpeed) {
            this.speed = minSpeed;
        }
    }

    public static AirVehicle makeRandomAirVehicle() {

        Random rand = new Random();

        Vector3f position = new Vector3f(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
        double speed = rand.nextDouble() * 300;
        double direction = rand.nextInt(10);
        Enum steeringDirection = Vehicle.getRandomDirection();
        Enum tiltDirection = getRandomDirection();
        double propSpeed = rand.nextDouble() * 100;
        double health = 100;
        return new AirVehicle(position, speed, direction, steeringDirection, tiltDirection, propSpeed, health);
    }

    public static Enum getRandomDirection(){
        Random random = new Random();
        return pullWheel.values()[random.nextInt(pullWheel.values().length)];
    }

    static void nudge(AirVehicle air){
        Random rand = new Random();
        air.propSpeed = rand.nextDouble() * 100;
        air.steeringDirection = Vehicle.getRandomDirection();
        air.tiltDirection = getRandomDirection();

    }

    public void changeVerticalDirection() {
        if (tiltDirection == pullWheel.FORTH) {
            verticalDirection -= 1;
            if (this.verticalDirection <= minVertDir) {
                verticalDirection = minVertDir;
            }
        }
        if (tiltDirection == pullWheel.BACK) {
            verticalDirection += 1;
            if (this.verticalDirection >= maxVertDir) {
                verticalDirection = maxVertDir;
            }
        }

    }
    public void updateAirPosition() {
        if (this.verticalDirection > 0) {
            this.position.z += (verticalDirection / 5);
        }
        if (this.verticalDirection < 0) {
            this.position.y += (verticalDirection) / 5;
        }
        if (this.position.y <= 0) {
            this.position.y = 0;
        }
    }
}
