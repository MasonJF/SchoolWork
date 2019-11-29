package org.lwjglb.ThisBetterWorkStupidFuckingUnitTestingGARBAGE;

import org.joml.Vector3f;

import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;

public class ProjectileWeapon extends GameItem{  // The characteristics of a projectile

//    Vector3f position;
    public double speed;
    public int damage;
    public int size;
    double direction;

    public ProjectileWeapon(Vector3f position, double speed, int damage, int size, double direction) {
        super();
        this.position = position;
        this.speed = speed;
        this.damage = damage;
        this.size = size;
        this.direction = direction;
    }


    public Vector3f getPosition() {
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

    public void setPosition(Vector3f position) {
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
