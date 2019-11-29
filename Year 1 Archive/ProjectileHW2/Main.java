package ProjectileHW2;

public class Main {


	public static void main(String[] args) {

		WaterBomb wat = new WaterBomb(1,2);
		WaterBottle wa = new WaterBottle(1,4);
		JuicyOrange or = new JuicyOrange(1,3);

		for(int i = 0; i <7;i++){

			wat.ticTok();
		}

		for(int i = 0; i < 9; i++){

			wa.ticTok();
		}


		for(int i = 0; i < 5; i++){
			or.ticTok();


		}


	}



}
