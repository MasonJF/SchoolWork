package Part2;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */
import java.awt.*;

class Orange extends Projectile {
    private int shapeSize = 20;

    Orange(int shapeSize, int dx, int dy, String name, double explode_speed) {
        super(dx, dy, name, explode_speed);
        this.shapeSize = shapeSize;
    }
    Color vari = Color.GREEN;


    @Override
    void explode() {
        System.out.println("Oh no Orange Juice!!");
            setDy(0.0);
            setDx(0.0);
            vari = Color.RED;
            shapeSize = shapeSize * 4;


    }

    @Override
    public void Paint(Graphics2D g2d) {
        g2d.setColor(vari);
        g2d.fillOval((int) x, (int) y, shapeSize, shapeSize);

    }
}