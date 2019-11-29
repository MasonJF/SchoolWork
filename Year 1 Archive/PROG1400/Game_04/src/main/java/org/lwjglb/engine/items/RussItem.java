package org.lwjglb.engine.items;

import org.lwjglb.engine.graph.Mesh;

public class RussItem extends GameItem implements DirectionLeftRight, DirectionUpDown {

    public RussItem(Mesh[] houseMesh) {
        super(houseMesh);
    }

    @Override
    public void turnRussLeft() {

    }

    @Override
    public void turnRussRight() {

    }

    /**
     * Sample from Russ
     */
    @Override
    public void turnRussUp() {
        this.setVelocity(this.velocity.x, this.velocity.y + DirectionUpDown.RUSS_LITTLE_UP, this.velocity.z);
    }

    @Override
    public void turnRussDown() {

    }
}
