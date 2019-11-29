package org.lwjglb.Database;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ObjDbConverter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private long id;

    private float x;
    private float y;
    private float z;
    private String veh_type;

    public synchronized int getIdentity() {
        return identity;
    }

    private int identity;

    public ObjDbConverter(float x, float y, float z, String veh_type, int identity) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.veh_type = veh_type;
        this.identity = identity;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public String getVeh_type() {
        return veh_type;
    }

    public void setVeh_type(String veh_type) {
        this.veh_type = veh_type;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f, %f, %s, %d)", this.x, this.y, this.z, this.veh_type, this.identity);
    }
}
