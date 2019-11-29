package AbstractShape;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */

public class Circle extends Shape {
    Circle(int sizeX, int sizeY) {
        super(sizeX, sizeY);


    }
    @Override
    public double area(){
        return Math.PI * (sizeX^2);
    }
}