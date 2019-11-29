package org.lwjglb.engine.items;

import org.joml.Vector3f;

public class StationaryWeapon {
    Vector3f position;
    int damage;
    int size;

    public StationaryWeapon(Vector3f position, int damage, int size) {
        this.position = position;
        this.damage = damage;
        this.size = size;
    }
}
