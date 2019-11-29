package Part2;

import java.util.concurrent.ThreadLocalRandom;

abstract class Projectile {
    int toc;
    int x;
    int y;
    private int dx = 3;
    private int dy = -2;
    int explodeTime;
    static int randomNum = ThreadLocalRandom.current().nextInt(1,  20 + 1);

    void ticToc() {
        int tick = toc;
        toc = tick + 1;
        projPos();
        if (toc >= explodeTime) {
            explode();
        }
    }

    private void projPos(){
        int posX = x;
        int posY = y;
        x = posX + dx;
        y = posY + dy;
        System.out.println("Projectile location is currently: " + x + " " + y);

    }
    abstract void explode();

    void setExplodeTime(int explodeTime) {
        this.explodeTime = explodeTime;
    }

} // Projectile Close

