package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;

public class ProjectileWeapon extends GameItem{  // The characteristics of a projectile
    public static Mesh[] getObjmesh() {
        return objmesh;
    }

    static Mesh[] objmesh;

    static {
        try {
            objmesh = StaticMeshesLoader.load("src/main/resources/models/russ/russ9.obj", "src/main/resources/models/russ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    Vector3f position;
    public double speed;
    public int damage;
    public int size;
    double direction;

    public ProjectileWeapon(Vector3f position, double speed, int damage, int size, double direction, Mesh[] mesh) {
        super(mesh);
        this.position = position;
        this.speed = speed;
        this.damage = damage;
        this.size = size;
        this.direction = direction;
    }

    public void updatePosition() {
        this.position = this.position.add(this.velocity);

        // Keep within bounds
        if (Math.abs(this.position.x) > Math.abs(max.x)) {
            this.velocity.x = -this.velocity.x;
        }

        if (Math.abs(this.position.y) > Math.abs(max.y)) {
            this.velocity.y = -this.velocity.y;
        }

        if (Math.abs(this.position.z) > Math.abs(max.z)) {
            this.velocity.z = -this.velocity.z;
        }
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
