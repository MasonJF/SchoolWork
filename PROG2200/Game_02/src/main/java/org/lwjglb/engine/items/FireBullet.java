package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.lwjglb.engine.graph.Mesh;

import java.sql.*;

public class FireBullet extends ProjectileWeapon {
    private Vector3f position = new Vector3f(0, 0, 0);
    private Vector3f velocity = new Vector3f(2, 2, 2);

    public FireBullet(Vector3f position, double speed, int damage, int size, double direction, Mesh[] mesh) {
        super(position, speed, damage, size, direction, mesh);

    }

    public void updatePosition() {
        this.position = this.position.add(this.velocity);

//         Keep within bounds
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

    /**
     * Title: SqliteDb Description: simple hello world db example of a standalone
     * persistent db application
     *
     * every time it runs it adds four more rows to sample_table it does a query and
     * prints the results to standard out
     *
     * Author: Karl Meissner karl@meissnersd.com
     */

}
