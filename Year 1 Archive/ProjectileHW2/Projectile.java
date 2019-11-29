package ProjectileHW2;

public abstract class Projectile {

	private int x;
	private int y;
	private int dx;
	private int dy;

	private int explodeTime;
	private int timeCount;


	public Projectile() {

		this(1,1,15);


	}

	public Projectile(int dx, int dy, int explodeTime) {


		this.dx = dx;
		this.dy = dy;
		this.explodeTime = explodeTime;


	}


	public void ticTok() {


		this.timeCount += 1;



		this.x = this.x + this.dx;
		this.y = this.y + this.dy;


		if(this.timeCount == this.explodeTime){

			System.out.println("The projectile is at: "+ this.x+" "+this.y+" Timer is at "+this.timeCount);
			this.explode();
			this.dx = 0;
			this.dy = 0;
		}

		else{
			System.out.println("The projectile is at: "+ this.x+" "+this.y+" Timer is at "+this.timeCount);
		}


	}


	public abstract void explode();




}
