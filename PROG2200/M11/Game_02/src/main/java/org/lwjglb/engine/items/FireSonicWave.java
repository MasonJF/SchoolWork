package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;

public class FireSonicWave extends ProjectileWeapon {

    public FireSonicWave(Vector3f position, double speed, int damage, int size, double direction, Mesh[] mesh) {
        super(position, speed, damage, size, direction, mesh);
    }
}
