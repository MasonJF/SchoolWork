package JumbledThread;

public class Character extends Thread {

    private Color color;
    private String person;

    public Character(Color color, String person) {
        this.color = color;
        this.person = person;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(54);
                DorthyClass.favCharacter = this.person;
                Thread.sleep(63);
                DorthyClass.favColor = this.color;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
