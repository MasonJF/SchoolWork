package SyncThread;

public class Character extends Thread {

    private String person;
    private Enum color;

    public Character(Enum color, String person) {
        this.color = color;
        this.person = person;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(36);
                DorthyClass.setStaticThreadFavorite(this.person, this.color);
                Thread.sleep(74);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
