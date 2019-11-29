package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;

import java.util.Random;

public class LandVehicle extends Vehicle {

    static Mesh[] cubeMesh;

    static {
        try {
            cubeMesh = StaticMeshesLoader.load("src/main/resources/models/house/house.obj", "src/main/resources/models/house");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    double gasPedal;
    double brakePedal;
    double maxSpeed = 160;

    public LandVehicle(Vector3f position, double speed, double direction, Enum steeringDirection, double gasPedal, double brakePedal, double health) {
        super(position, speed, direction, steeringDirection, health, cubeMesh);
        this.cubeMesh = Vehicle.cubeMesh;
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

    public static LandVehicle makeRandomVehicle() {

        Random rand = new Random();
        Vector3f position = new Vector3f(0, 0, 0);
//        Vector3f position = new Vector3f(rand.nextInt(10), rand.nextInt(10), 0);
        double speed = rand.nextDouble() * 100;
        double direction = rand.nextInt(10);
        double gasPedal = rand.nextDouble() * 100;
        double brakePedal = rand.nextDouble() * 100;
        Enum steeringDirection = Vehicle.getRandomDirection();
        double health = 100;
        return new LandVehicle(position, speed, direction, steeringDirection, gasPedal, brakePedal, health);
    }

    static void nudge(LandVehicle land){
        Random rand = new Random();
        land.gasPedal = rand.nextDouble() * 100;
        land.brakePedal = rand.nextDouble() * 100;
        land.steeringDirection = Vehicle.getRandomDirection();
    }
}
