package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;

import java.util.Random;

public class AirVehicle extends Vehicle {
    static Mesh[] cubeMesh;

    static {
        try {
            cubeMesh = StaticMeshesLoader.load("src/main/resources/models/cube.obj", "src/main/resources/models");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo Make this class use GameItem's coord system instead of storing locally.
    double propSpeed;
    double maxSpeed = 320;
    double minSpeed = 70;

    enum pullWheel {
        BACK, FORTH
    }

    public AirVehicle(Vector3f position, double propSpeed, double health) {
        super(position, health, cubeMesh);
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
        double propSpeed = rand.nextDouble() * 100;
        double health = 100;
        return new AirVehicle(position, propSpeed, health);
    }

    public static Enum getRandomDirection(){
        Random random = new Random();
        return pullWheel.values()[random.nextInt(pullWheel.values().length)];
    }

}
