package org.lwjglb.engine.items;

import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;

import javax.jdo.annotations.PersistenceCapable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GameItem extends Thread {
    public synchronized int getIdentity() {
//        System.out.println("Id="+identity);
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    private int identity;

    public synchronized static void setIncIndentity(int incIndentity) {
        GameItem.incIndentity = incIndentity;
    }

    private static int incIndentity = 0;
    private static final long serialVersionUID = 1L;
    private final double threshold = 1.1;
    private boolean selected;
    private String thisIs;


    @Id
    @GeneratedValue
    private long id;

    private Mesh[] meshes;

    public String getThisIs() {
        return thisIs;
    }

    public void setThisIs(String thisIs) {
        this.thisIs = thisIs;
    }

    Vector3f position;
    public Vector3f velocity;

    /**
     * Russ <RS> added max to keep moving items inside the frustum.
     */
    public Vector3f max = new Vector3f(15,15,15);

    private float scale;

    private  Quaternionf rotation;
    private  Quaternionf rotationVel;

    private int textPos;
    
    private boolean disableFrustumCulling;

    private boolean insideFrustum;
    public GameItem() {

        selected = false;
        position = new Vector3f(0, 0, 0);
        velocity = new Vector3f(0, 0, 0);
        scale = 1;
        rotation = new Quaternionf();
        rotationVel = new Quaternionf();
        textPos = 0;
        insideFrustum = true;
        disableFrustumCulling = false;
        this.identity = incIndentity;
        incIdentity();
        this.start();
    }

    public GameItem(Mesh mesh) {
        this();
        this.meshes = new Mesh[]{mesh};
    }

    public synchronized void incIdentity() {
        incIndentity += 1;
    }

    public GameItem(Mesh[] meshes) {
        this();
        this.meshes = meshes;
    }
    public Vector3f getPosition() {
        return position;
    }

    public int getTextPos() {
        return textPos;
    }

    public boolean isSelected() {
        return selected;
    }

    public final void setPosition(float x, float y, float z) {
        this.position.x = x;
        this.position.y = y;
        this.position.z = z;
    }

    public final void setVelocity(float x, float y, float z) {
        this.velocity.x = x;
        this.velocity.y = y;
        this.velocity.z = z;
    }

    public float getScale() {
        return scale;
    }

    public final void setScale(float scale) {
        this.scale = scale;
    }

    public Quaternionf getRotation() {
        return rotation;
    }

    public final void setRotation(Quaternionf q) {
        this.rotation.set(q);
    }

    public final void setRotationVel(Quaternionf q) {
        this.rotationVel.set(q);
    }

    public Mesh getMesh() {
        return meshes[0];
    }

    public Mesh[] getMeshes() {
        return meshes;
    }

    public void setMeshes(Mesh[] meshes) {
        this.meshes = meshes;
    }

    public void setMesh(Mesh mesh) {
        this.meshes = new Mesh[]{mesh};
    }

    public void cleanup() {
        int numMeshes = this.meshes != null ? this.meshes.length : 0;
        for (int i = 0; i < numMeshes; i++) {
            this.meshes[i].cleanUp();
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setTextPos(int textPos) {
        this.textPos = textPos;
    }

    public boolean isInsideFrustum() {
        return insideFrustum;
    }

    public void setInsideFrustum(boolean insideFrustum) {
        this.insideFrustum = insideFrustum;
    }
    
    public boolean isDisableFrustumCulling() {
        return disableFrustumCulling;
    }

    public void setDisableFrustumCulling(boolean disableFrustumCulling) {
        this.disableFrustumCulling = disableFrustumCulling;
    }

    /**
     * Russ <RS> added a thread to GameItems to allow items to move on their own.
     */
    public void run() {
//        System.out.println("Running Shape...");
        while (true) {
            this.move();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public void updatePosition() {
//
//    }


    /**
     * Russ adde this method to nudge the items slightly.
     */
    private void move() {

        // Rotate (spin)
//        this.rotation = this.rotation.add(this.rotationVel);

        // Translate (move sideways)
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

    @Override
    public String toString() {
        return String.format("(%f, %f, %f)", this.position.x, this.position.y, this.position.z);
    }

    public boolean doesItCollide(GameItem that) {

        // Don't collide with itself
        if (this!=that) {

            Vector3f pos1 = this.position;
            Vector3f pos2 = that.position;

            if (pos1.distance(pos2) < threshold) {
                System.err.print(" this.velocity=" + this.velocity.toString());
                this.velocity.negate();
                //that.velocity.negate();
//                System.err.println("  ###  this.velocity=" + this.velocity.toString());
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
