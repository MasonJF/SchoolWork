package Part2;


public class Main {

    public static void main(String[] args) {
        int random = Projectile.randomNum;
        Waterbomb water1 = new Waterbomb();
        Waterbottle water2 = new Waterbottle();
        Juiceyorange jo1 = new Juiceyorange();
        for(int i = 0; i < 7; i++) {
            water1.ticToc();
        }
        for(int i = 0; i < 9; i++) {
            water2.ticToc();
        }
        for(int i = 0; i < random; i++) {
            jo1.ticToc();
        }
    }
}

