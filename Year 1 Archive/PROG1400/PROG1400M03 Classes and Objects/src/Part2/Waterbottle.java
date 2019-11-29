package Part2;

public class Waterbottle extends Projectile {

    @Override
    void explode() {
        setExplodeTime(9);
        if (toc == explodeTime) {
            System.out.println("Splash!");
            toc = 0;
            x = 0;
            y = 0;
            explodeTime = 0;
        }
    }
}


