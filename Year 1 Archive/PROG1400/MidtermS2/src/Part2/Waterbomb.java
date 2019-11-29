package Part2;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */
import java.awt.*;

public class Waterbomb extends Projectile {
    private int shapeSize;
    Waterbomb(int shapeSize, int dx, int dy, String name, double explode_speed) {
        super(dx, dy, name, explode_speed);
        this.shapeSize = shapeSize;
    }
    Color vari = Color.PINK;


    @Override
    void explode() {
        System.out.println("Kerplow!");
        setDy(0.0);
        setDx(0.0);
        vari = Color.GREEN;
        shapeSize = shapeSize * 4;
    }

    @Override
    public void Paint(Graphics2D g2d) {
        g2d.setColor(vari);
        g2d.fillOval((int) x, (int) y, shapeSize, shapeSize);

    }
}