package Part3;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */
import java.awt.*;

public class Triangle extends Shape {
    private int shapeSize;

    Triangle(int shapeSize, int dx, int dy, String name, double explode_speed, double flubberFactor) {
        super(dx, dy, name, explode_speed, flubberFactor);
        this.shapeSize = shapeSize;
    }
    Color vari = Color.GREEN;

    @Override
    void explode() {
        System.out.println("This was a real meanie!! Hi Russ!");
        setDy(0);
        setDx(0);
        vari = Color.RED;
        shapeSize = shapeSize * 4;


    }

    @Override
    public void Paint(Graphics2D g2d) {
        g2d.setColor(vari);
        int x[]={(int) getX(), shapeSize + (int) getX(), (shapeSize)/2 + (int)getX()};
        int y[]={(int) getY(), (int) getY(), shapeSize + (int)getY()};
        g2d.fillPolygon(x, y, 3);
    }
    @Override
    public double area() {
        return (double) ((sizeX * sizeY) / 2);
    }

}