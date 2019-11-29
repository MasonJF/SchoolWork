package ProjectileHW2;

public class WaterBomb extends Projectile{

	public WaterBomb(int dx, int dy) {
		super(dx, dy, 7);
	}


	@Override
	public void explode() {
		System.out.println("Water explosion!");
	}
}
