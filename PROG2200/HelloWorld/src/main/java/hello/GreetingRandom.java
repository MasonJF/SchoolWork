package hello;

import java.util.Random;

public class GreetingRandom extends Greeting {
    private int random;


    public GreetingRandom(long id, String content) {
        super(id, content);
        this.random = getRandomNumber();
    }

    public int getRandomNumber()  {
        Random rand = new Random();
        return rand.nextInt();
    }

    public int getRandom() {
        return random;
    }
}
