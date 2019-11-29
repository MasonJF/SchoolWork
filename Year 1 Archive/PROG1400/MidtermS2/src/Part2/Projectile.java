package Part2;
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

    Projectile(int dx, int dy, String name, double explode_speed) {
        this.dx = dx;
        this.dy = dy;
        this.name = name;
        this.explode_speed = explode_speed;
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
        bounce();
        if (dx  > explode_speed) {
            explode();
        }
        if (dy  > explode_speed) {
            explode();
        }
    }

    private void bounce(){
        if (this.y < 0) {
            dy = -dy * 1.1;
        }
        if (this.x > 600) {
            dx = -dx * 1.1;
        }
        if (this.x < 0) {
            dx = -dx * 1.1;
            System.out.println(dx);
        }
        if (this.y > 700) {
            dy = -dy * 1.1;
        }
//        if ( dx > 600) {
//            dx =-dx;

//        dx = -x;

    }
    private void projPos(){
//        int posX = x;
        double speedMulti = 25;
        x = x + (dx * (speedMulti /100));
        y = y + (dy * (speedMulti /100));
//        dy = dy - (speedMulti /100);
//        System.out.println(name + " location is currently: " + x + " " + y);
        System.out.println(dx);
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

