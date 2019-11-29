package Part2;


public class Juiceyorange extends Projectile {
    @Override
    void explode() {
        setExplodeTime(randomNum);
        if (toc == explodeTime) {
            System.out.println("Sticky Orange Juice Everywhere!");
            toc = 0;
            x = 0;
            y = 0;
            explodeTime = 0;
        }
    }
}
