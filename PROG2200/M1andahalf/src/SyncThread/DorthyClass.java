package SyncThread;

public class DorthyClass {

    static String favCharacter;
    static Enum favColor;

    public DorthyClass(String favCharacter, Enum favColor) {
        DorthyClass.favCharacter = favCharacter;
        DorthyClass.favColor = favColor;
    }


    public synchronized static void setStaticThreadFavorite(String favCharacter, Enum favColor) {
//        mySleep(35);
        DorthyClass.favCharacter = favCharacter;
//        mySleep(54);
        DorthyClass.favColor = favColor;
    }

    public synchronized static String getStaticThreadFavorite() {
        mySleep(20);
        return "Dorths fav is " + DorthyClass.favCharacter +
                " and her fav colour is " + DorthyClass.favColor;
    }

    public static void mySleep(int d) {
        try {
            Thread.sleep(d);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}