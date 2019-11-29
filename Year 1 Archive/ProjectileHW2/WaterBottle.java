package ProjectileHW2;

public class WaterBottle extends Projectile{


	public WaterBottle(int dx, int dy) {
		super(dx, dy, 9);

	}

	@Override
	public void explode() {
		System.out.println("Splash!");
	}
}
