package org.lwjglb.ThisBetterWorkStupidFuckingUnitTestingGARBAGE;

import org.joml.Random;
import org.joml.Vector3f;

public class SamMissle extends ProjectileWeapon {
    Random rand = new Random(100);
    float random = 0 + rand.nextFloat() * (100);
//    private Vector3f position = new Vector3f(0, 0,0);
    private Vector3f velocity = new Vector3f(0, 2, 0);
    //todo

    public SamMissle(Vector3f position, double speed, int damage, int size, double direction) {
        super(position, speed, damage, size, direction);
    }
//
//    public void updatePosition() {
//        this.position = this.position.add(this.velocity);
//
////         Keep within bounds
//
//        if (Math.abs(this.position.y) > Math.abs(max.y)) {
//            this.velocity.y = -this.velocity.y;
//        }
//
//        if (this.position.y <= -14) {
//            this.velocity.y = 0;
//            explode();
//        }
//    }

    public void explode() {
        damage = 0;
        this.setPosition(-100, -100, -100); //remove from screen. Hacky way of doing this but whatever.
    }

    public static SamMissle makeRandomSam() {
        java.util.Random rand = new java.util.Random();
        Vector3f position = new Vector3f(0, 0, 0);
//        Vector3f position = new Vector3f(rand.nextInt(10), rand.nextInt(10), 0);
        double direction = rand.nextInt(10);
        return new SamMissle(position, 100, 100, 1, direction);
    }



}
