package org.lwjglb.ThisBetterWorkStupidFuckingUnitTestingGARBAGE;

import org.joml.Vector3f;
import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;

import java.util.Random;

public class Motorcycle extends Vehicle {




    public Motorcycle(Vector3f position, double speed, double direction, Enum steeringDirection, double health) {
        super(position, speed, direction, steeringDirection, health);
    }

    public static Motorcycle makeRandomMoto() {

        Random rand = new Random();
        Vector3f position = new Vector3f(0, 0, 0);
//        Vector3f position = new Vector3f(rand.nextInt(10), rand.nextInt(10), 0);
        double speed = rand.nextDouble() * 100;
        double direction = rand.nextInt(10);
        Enum steeringDirection = Vehicle.getRandomDirection();
        double health = 100;
        return new Motorcycle(position, speed, direction, steeringDirection, health);
    }


    @Override
    public void speedControl() {

    }

}
