package smallApp;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int dx;
        int dy;
        Projectile bigGun = new Gun(0, 0, "BigPoppa");
        Projectile littleGun = new Gun(0,0, "LittlePoppa");
            Scanner in = new Scanner(System.in);
            System.out.print("Set Launch Angle: ");
            dx = in.nextInt();
            bigGun.setDx(dx);
            littleGun.setDx(dx);
            System.out.print("Set power level: ");
            dy = in.nextInt();
            bigGun.setDy(dy);
            littleGun.setDy(dy);


            bigGun.start();
//            littleGun.start();
        }
    }

