package Part3;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */

import java.awt.*;

abstract class Projectile extends Thread{
    private int toc;
    double x;
    double y;
    private double dx;
    private double dy;
    private double explode_speed;
    private int cnt;
    private String name;
    private double flubberFactor;

    Projectile(int dx, int dy, String name, double explode_speed, double flubberFactor) {
        this.dx = dx;
        this.dy = dy;
        this.name = name;
        this.explode_speed = explode_speed;
        this.flubberFactor = flubberFactor;
    }

    public void run() {
        do {
            this.ticToc();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    private void ticToc() {

        int tick = toc;
        toc = tick + 1;
        projPos();
        if (dx  > explode_speed || dy > explode_speed || dx  <  -explode_speed || dy < -explode_speed ) {
            explode();
        }
    }

    private void projPos(){
        if (this.y < 0) {
            dy = -dy * flubberFactor;
        }
        if (this.x > 550) {
            dx = -dx * flubberFactor;
        }
        if (this.x < 0) {
            dx = -dx * flubberFactor;
        }
        if (this.y > 650) {
            dy = -dy * flubberFactor;
        }

        double speedMulti = 25;
        x = x + (dx * (speedMulti /100));
        y = y + (dy * (speedMulti /100));
    }

    void setDx(double dx) {
        this.dx = dx;
    }

    void setDy(double dy) {
        this.dy = dy;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    abstract void explode();

    public abstract void Paint(Graphics2D g2d);
} // Projectile Close

