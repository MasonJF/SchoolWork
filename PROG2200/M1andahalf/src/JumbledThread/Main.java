package JumbledThread;

public class Main {

    public static void main(String[] args) {
        Character TINMAN = new Character(Color.SILVER, "TinMan");
        Character SCARECROW = new Character(Color.BROWN, "ScareCrow");
        Character COWARDLY_LION = new Character(Color.YELLOW, "Cowardly Lion");

        TINMAN.start();
        SCARECROW.start();
        COWARDLY_LION.start();

        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(DorthyClass.favCharacter + " is Dorth's fav, and " + DorthyClass.favColor + " is her fav colour");
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
