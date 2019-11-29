package org.lwjglb.engine.items;

import org.lwjglb.engine.graph.Mesh;

public class Airplane extends GameItem {
//    public static boolean subjectToGravity;

    public Airplane(Mesh[] hiRussMeshCar) {
        super(hiRussMeshCar);
        subjectToGravity = false;
        isCar = false;
    }
}
