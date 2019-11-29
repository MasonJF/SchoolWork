package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;

import java.util.Random;
import java.sql.*;

import static org.lwjglb.engine.items.ProjectileWeapon.getObjmesh;


public abstract class Vehicle extends GameItem implements Health, Attack {
    static Mesh[] cubeMesh;

    static {
        try {
            cubeMesh = StaticMeshesLoader.load("src/main/resources/models/house/house.obj", "src/main/resources/models/house");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    int[] position;

    public double health;
    double speed; // Speed of Vehicles.
    double direction; // Direction of travel on virtual plane
    double accelerationValue = 5;
    boolean isExploded = false;


    public Vehicle(Vector3f position, double health, Mesh[] mesh) {
        super(mesh);
        this.position = position;
        this.health = health;
    }



    public void onHit(int i) {
        this.health -= i;
    }

    public void onRepair() {
        this.health = 100;
    }

    @Override
    public ProjectileWeapon fireWeapon() {
        Random rand = new Random();
        int weapon = rand.nextInt(1);
        Vector3f position = new Vector3f(this.position.x, this.position.y, this.position.z);
        Vector3f velocity = new Vector3f(2, 2, 2);
        switch(weapon) {
            case 0:
//                double speedFaster = this.speed + 20;
//                int bulletDamage = 10;
//                int bulletSize = 1;
//                return new FireBullet(position, speedFaster, bulletDamage, bulletSize, direction, getObjmesh());
                double speedFaster = 1;
                return new SamMissle(position, speedFaster, 100, 1, direction, getObjmesh());
            case 1:
                double speedSlower = this.speed - 30;
                int waveDamage = 5;
                int waveSize = 5;
                return new FireSonicWave(position, speedSlower, waveDamage, waveSize, direction, getObjmesh());
            case 2:
                speedFaster = 100;
//                return new SamMissle(this.getPosition(), speedFaster, 100, 3, direction, getObjmesh());
            default:
                return null;
        }
    }

    @Override
    public StationaryWeapon blast() {
        Random rand = new Random();
        int weapon = rand.nextInt(2);
        switch(weapon) {
            case 1:
                int mineDamage = 25;
                int mineSize = 10;
                return new RearDefenseMine(position, mineDamage, mineSize);
            case 2:
                int blastDamage = 5;
                int waveSize = 5;
                return new ChimneyBlast(position, blastDamage, waveSize);
            default:
                return null;
        }
    }

    public boolean isExploded() {
        return this.isExploded = true;
    }


}
