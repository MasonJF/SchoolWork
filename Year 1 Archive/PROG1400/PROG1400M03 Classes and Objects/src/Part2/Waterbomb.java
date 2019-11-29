package Part2;

class Waterbomb extends Projectile {

    @Override
    void explode() {
        setExplodeTime(7);
        if (toc == explodeTime) {
            System.out.println("Water Explosion!");
            toc = 0;
            x = 0;
            y = 0;
            explodeTime = 0;
        }
    }
}
