package AbstractShape;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */

public class Triangle extends Shape {
    Triangle(int sizeX, int sizeY) {
        super(sizeX, sizeY);


    }

    @Override
    public double area() {
        return (double) ((sizeX * sizeY) / 2);
    }

}