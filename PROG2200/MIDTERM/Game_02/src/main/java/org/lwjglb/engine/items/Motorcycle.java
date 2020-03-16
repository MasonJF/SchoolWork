package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;

import java.util.Random;

public class Motorcycle extends Vehicle {

    static Mesh[] bikeMesh;

    static {
        try {
            bikeMesh = StaticMeshesLoader.load("src/main/resources/models/house/house.obj", "src/main/resources/models/house");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Motorcycle(Vector3f position, double speed, double direction, Enum steeringDirection, double health, Mesh[] mesh) {
        super(position, speed, direction, steeringDirection, health, mesh);
    }

    public static Motorcycle makeRandomMoto() {

        Random rand = new Random();
        Vector3f position = new Vector3f(0, 0, 0);
//        Vector3f position = new Vector3f(rand.nextInt(10), rand.nextInt(10), 0);
        double speed = rand.nextDouble() * 100;
        double direction = rand.nextInt(10);
        Enum steeringDirection = Vehicle.getRandomDirection();
        double health = 100;
        return new Motorcycle(position, speed, direction, steeringDirection, health, bikeMesh);
    }


    @Override
    public void speedControl() {

    }

}