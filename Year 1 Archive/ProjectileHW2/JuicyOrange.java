package ProjectileHW2;

import java.util.Random;

public class JuicyOrange extends Projectile{

	static Random ran = new Random();

	public JuicyOrange(int dx, int dy) {

		super(dx, dy, ran.nextInt(5)+1);

	}


	@Override
	public void explode() {

		System.out.println("Sticky orange juice everywhere!");

	}
}
