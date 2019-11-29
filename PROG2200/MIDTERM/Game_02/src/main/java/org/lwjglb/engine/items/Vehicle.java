package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;
//import org.lwjglb.ThisBetterWorkStupidFuckingUnitTestingGARBAGE.GameItem;
import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;
import java.util.ArrayList;
import java.util.Random;

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
    ArrayList<ProjectileWeapon> projectileWeapons = new ArrayList<>();
    double speed; // Speed of Vehicles.
    double direction; // Direction of travel on virtual plane
    double accelerationValue = 5;
    double maxDirection = 15;
    double minDirection = -15;
    int maxHeight = 500;
    int maxThresholdX = 100;
    int maxThresholdY = 1000;
    int minThresholdY = 0;
    Enum steeringDirection;
    boolean isExploded = false;

    enum steeringWheel {
        LEFT, CENTER, RIGHT
    }

    public Vehicle(Vector3f position, double speed, double direction, Enum steeringDirection, double health, Mesh[] mesh) {
        super(mesh);
        this.position = position;
        this.speed = speed;
        this.direction = direction;
        this.steeringDirection = steeringDirection;
        this.health = health;
    }

    public static Enum getRandomDirection(){
        Random random = new Random();
        return steeringWheel.values()[random.nextInt(steeringWheel.values().length)];
    }

    public void changeDirection() {
        if(steeringDirection == steeringWheel.LEFT){
            direction -= 1;
            if(this.direction <= minDirection) {
                direction = minDirection;
            }
        }
        if(steeringDirection == steeringWheel.RIGHT) {
            direction += 1;
            if(this.direction >= maxDirection) {
                direction = maxDirection;
            }
        }

        if(this.speed == 0) {
            this.direction = 0;
            this.steeringDirection = steeringWheel.CENTER;
        }

    }

    public void updatePosition() {
        this.position = this.position.add(this.velocity);

        // Keep within bounds
//        if (Math.abs(this.position.x) > Math.abs(max.x)) {
//            this.velocity.x = -this.velocity.x;
//        }
//
//        if (Math.abs(this.position.y) > Math.abs(max.y)) {
//            this.velocity.y = -this.velocity.y;
//        }
//
//        if (Math.abs(this.position.z) > Math.abs(max.z)) {
//            this.velocity.z = -this.velocity.z;
//        }
//        if(this.direction > 0) {
//            this.position.x += (direction / 100);
//        }
//        if(this.direction < 0) {
//            this.position.x += (direction / 100);
//        }
//        if(this.speed > 0) {
//            this.position.y += this.speed / 100;
//        }
////        boundaries();
    }

    public void boundaries() {
        if (this.position.x < -maxThresholdX) {
            this.position.x = maxThresholdX;
        }
        if (this.position.x > maxThresholdX) {
            this.position.x = -maxThresholdX;
        }
        if (this.position.y > maxThresholdY) {
            this.position.y = minThresholdY;
        }
        if (this.position.z > maxHeight) {
            this.position.z = maxHeight;
        }
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

    public abstract void speedControl();

}
