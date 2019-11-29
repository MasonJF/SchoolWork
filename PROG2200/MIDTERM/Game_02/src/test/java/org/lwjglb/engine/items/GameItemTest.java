package org.lwjglb.engine.items;

import org.joml.Vector3f;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameItemTest {

    @Test
    public void doesItCollide() {
        LandVehicle veh1 = new LandVehicle(new Vector3f(0,0,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        LandVehicle veh2 = new LandVehicle(new Vector3f(0,0,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        assertTrue(veh1.doesItCollide(veh2));
    }
    @Test
    public void doesItCollide2() {
        LandVehicle veh1 = new LandVehicle(new Vector3f(10,0,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        LandVehicle veh2 = new LandVehicle(new Vector3f(0,10,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        assertFalse(veh1.doesItCollide(veh2));
    }
    @Test
    public void doesItCollide3() {
        LandVehicle veh1 = new LandVehicle(new Vector3f(0,0,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        LandVehicle veh2 = new LandVehicle(new Vector3f(0,0,10), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        assertFalse(veh1.doesItCollide(veh2));
    }
    @Test
    public void doesItCollide4() {
        LandVehicle veh1 = new LandVehicle(new Vector3f(10,10,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        LandVehicle veh2 = new LandVehicle(new Vector3f(0,10,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        assertFalse(veh1.doesItCollide(veh2));
    }
    @Test
    public void doesItCollide5() {
        LandVehicle veh1 = new LandVehicle(new Vector3f(10,0,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        LandVehicle veh2 = new LandVehicle(new Vector3f(11,0,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        assertTrue(veh1.doesItCollide(veh2));
    }
    @Test
    public void doesItCollide6() {
        LandVehicle veh1 = new LandVehicle(new Vector3f(10,10,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        LandVehicle veh2 = new LandVehicle(new Vector3f(11,12,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        assertFalse(veh1.doesItCollide(veh2));
    }

    @Test
    public void doesItCollide7() {
        LandVehicle veh1 = new LandVehicle(new Vector3f(10,0,10), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        LandVehicle veh2 = new LandVehicle(new Vector3f(11,0,0), 10, 10, LandVehicle.getRandomDirection(), 10, 10, 100);
        assertFalse(veh1.doesItCollide(veh2));
    }
}