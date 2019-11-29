package org.lwjglb.engine.items;

import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.game.GameGUI;
import static org.lwjglb.engine.Scene.lastAdded;


public class GameItem extends Thread implements GuiControls {
    static boolean isCar;
    private boolean selected;

    private Mesh[] meshes;

    private Vector3f position;
    private Vector3f velocity;
    /**
     * Russ <RS> added max to keep moving items inside the frustum.
     */
    private Vector3f max = new Vector3f(15, 15, 15);

    private float scale;
    static boolean subjectToGravity;
    private Quaternionf rotation;
    private Quaternionf rotationVel;

    private int textPos;

    private boolean disableFrustumCulling;

    private boolean insideFrustum;

    private Vector3f littleFaster = new Vector3f(1.0f, 1.0f, 1.0f);
    private boolean isStationary = false;


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
        this.start();
    }

    public GameItem(Mesh mesh) {
        this();
        this.meshes = new Mesh[]{mesh};
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
        if ((x == 0) && (y==0) && (z == 0)) {
            this.isStationary = true;  // zero velocity, this item is stationary
        }
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
        System.out.println("Running Shape...");
        while (!isStationary) {
            this.move();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Russ adde this method to nudge the items slightly.
     */
    private void move() {

        // Rotate (spin)
        this.rotation = this.rotation.add(this.rotationVel);

        // Translate (move sideways)
        this.position = this.position.add(this.velocity);

        // Keep within bounds
        if (Math.abs(this.position.x) > Math.abs(max.x)) {
            this.velocity.x = -(this.velocity.x);
        }

        if (Math.abs(this.position.y) > Math.abs(max.y)) {
            this.velocity.y = -this.velocity.y;
            if (this.position.y > 0) {
                this.position.y = max.y;
            }else{
                this.position.y = -max.y;
            }
        }

        if (Math.abs(this.position.z) > Math.abs(max.z)) {
            this.velocity.z = -(this.velocity.z);
        }

        if (GameGUI.isRight == 1) {
            moveRight();
        }
        if (GameGUI.isLeft == 1) {
            moveLeft();
        }
        if (GameGUI.isUp == 1) {
            moveUp();
        }
        if (GameGUI.isDown == 1) {
            moveDown();
        }

    }


    public boolean DoesItCollide(GameItem that) {

        // Don't collide with itself
        if (this!=that) {

            Vector3f pos1 = this.position;
            Vector3f pos2 = that.position;

            double threshold = 1.0;
            if (pos1.distance(pos2) < threshold) {
                System.err.print(" this.velocity=" + this.velocity.toString());
                this.velocity.negate();
                System.err.println("  ###  this.velocity=" + this.velocity.toString());
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void bounceFaster() {
        this.velocity = this.velocity.mul(littleFaster);
    }

    public void doesNotMove() {
        this.isStationary = true;
    }

    @Override
    public void moveLeft() {
        lastAdded.velocity.z = lastAdded.velocity.z - 0.007f;
        lastAdded.velocity.x = lastAdded.velocity.x - 0.007f;
        GameGUI.isLeft = 0;
    }

    @Override
    public void moveRight() {
        lastAdded.velocity.x = lastAdded.velocity.x + 0.007f;
        lastAdded.velocity.z = lastAdded.velocity.z + 0.007f;
        GameGUI.isRight = 0;
    }

    @Override
    public void moveUp() {
        if(!isCar) {
            lastAdded.velocity.y = lastAdded.velocity.y + 0.007f;
            GameGUI.isUp = 0;
        }
    }

    @Override
    public void moveDown() {

        if(!isCar) {
            lastAdded.velocity.y = lastAdded.velocity.y - 0.007f;
            GameGUI.isDown = 0;
        }
    }
}
