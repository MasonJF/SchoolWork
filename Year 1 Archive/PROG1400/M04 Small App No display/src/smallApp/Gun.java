package smallApp;

class Gun extends Projectile {
//    Projectile bigGun = new Projectile(0, 0) {
////        @Override
////        void explode() {
////            System.out.println("Kerplow!");
////            setDy(0);
////            setDx(0);
////            System.exit(0);
////        }
////    };

    Gun(int dx, int dy, String name) {
        super(dx, dy, name);
    }

    @Override
    void explode() {
        System.out.println("Kerplow!");
            setDy(0);
            setDx(0);
            System.exit(0);
    }
}