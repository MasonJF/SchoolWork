package Part3;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */

import java.awt.*;

public class Square extends Shape {
    private int shapeSize;

    Square(int shapeSize, int dx, int dy, String name, double explode_speed, double flubberFactor) {
        super(dx, dy, name, explode_speed, flubberFactor);
        this.shapeSize = shapeSize;
    }

    @Override
    public double area(){
        return (double) (sizeX * sizeY);
    }

    Color vari = Color.GREEN;

    @Override
    void explode() {
        System.out.println("The square EXPLODED!!");
        setDy(0.0);
        setDx(0.0);
        vari = Color.RED;
        shapeSize = shapeSize * 4;



//            System.exit(0);
    }

    @Override
    public void Paint(Graphics2D g2d) {
        g2d.setColor(vari);
        g2d.fillRect((int) x, (int) y, shapeSize, shapeSize);

    }
}
