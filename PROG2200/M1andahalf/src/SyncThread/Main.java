package SyncThread;

public class Main {

    public enum Color {
        SILVER,
        YELLOW,
        BROWN
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Character TINMAN = new Character(Color.SILVER, "TinMan");
            Character SCARECROW = new Character(Color.BROWN, "ScareCrow");
            Character COWARDLY_LION = new Character(Color.YELLOW, "Cowardly Lion");

            TINMAN.start();
            SCARECROW.start();
            COWARDLY_LION.start();

        }

        for (int i = 0; i < 1000; i++) {
//            System.out.println(DorthyClass.getStaticThreadFavorite());
            try {
                Thread.sleep(20);
                System.out.println(DorthyClass.getStaticThreadFavorite());
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
