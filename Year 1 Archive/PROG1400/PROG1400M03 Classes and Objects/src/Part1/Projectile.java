package Part1;

class Projectile {
    static int toc;
    static int x;
    static int y;
    static int dx = 3;
    static int dy = -2;
    static int explodeTime = 15;

    static int ticToc() {
        int tick = toc;
        toc = tick + 1;
        projPos();
        if (toc >= explodeTime) {
            explode();
        }
        return toc;
    }

    static int projPos(){
        int posX = x;
        int posY = y;
        x = posX + dx;
        y = posY + dy;
        System.out.println("Projectile location is currently: " + x + " " + y);
        return x + y;

    }
    static void explode() {
        System.out.println("exploded!!");
        dx = 0;
        dy = 0;
        x = 0;
        y = 0;
    }



} // Projectile Close

