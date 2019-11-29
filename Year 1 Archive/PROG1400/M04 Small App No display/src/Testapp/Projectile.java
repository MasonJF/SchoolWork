package Testapp;

import java.awt.*;

abstract class Projectile extends Thread{
    private int toc;
    double x;
    double y;
    private double dx;
    private double dy;
    private int cnt;
    private String name;

    Projectile(int dx, int dy, String name) {
        this.dx = dx;
        this.dy = dy;
        this.name = name;
    }

    public void run() {
        do {
            this.ticToc();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!(dx <= 0.0) || !(dy <= 0.0));
    }

    private void ticToc() {
        int tick = toc;
        toc = tick + 1;
        projPos();
        if (this.y == 0  && cnt == 0) {
            bounce();
        }else if (this.y == 0 && cnt == 1){
            explode();
        }
    }
    private void bounce(){
        dy = -dy / 2;
        dx = dx - 3;
        cnt += 1;

    }
    private void projPos(){
//        int posX = x;
        double speedMulti = 25;
        x = x + (dx * (speedMulti /100));
        y = y + (dy * (speedMulti /100));
        dy = dy - (1 * (speedMulti /100));
        System.out.println(name + " location is currently: " + x + " " + y);

    }

    void setDx(double dx) {
        this.dx = dx;
    }

    void setDy(double dy) {
        this.dy = dy;
    }

    abstract void explode();

    public abstract void Paint(Graphics2D g2d);
} // Projectile Close

