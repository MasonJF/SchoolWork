package Testapp;

import java.awt.*;

class Gun extends Projectile {
    Gun(int dx, int dy, String name) {
        super(dx, dy, name);
    }
    Color vari = Color.GREEN;

    @Override
    void explode() {
        System.out.println("Kerplow!");
            setDy(0.0);
            setDx(0.0);
//            System.exit(0);
    }

    @Override
    public void Paint(Graphics2D g2d) {
        g2d.setColor(vari);
        int shapeSize = 20;
        g2d.fillOval((int) x, (int) y, shapeSize, shapeSize);

    }
}