package Part3;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */

abstract class Shape extends Projectile {
    int sizeX;
    int sizeY;

    Shape(int dx, int dy, String name, double explode_speed, double flubberFactor) {
        super(dx, dy, name, explode_speed, flubberFactor);
    }



    abstract public double area();
}
