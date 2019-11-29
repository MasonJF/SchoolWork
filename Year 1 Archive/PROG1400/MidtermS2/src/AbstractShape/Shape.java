package AbstractShape;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */

abstract class Shape extends Thread {
    int sizeX;
    int sizeY;

//    Random rand = new Random();

    Shape(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void run() {
        this.area();
    }

    abstract public double area();
}
