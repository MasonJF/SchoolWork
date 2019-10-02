import java.util.*;

public class Main {

    public enum shapeObject {
        CIRCLE, SQUARE, TRIANGLE
    }
    public enum shapeColour {
        RED, GREEN, BLUE, YELLOW, PURPLE
    }
    private static shapeObject getRandomObject() {
        Random random = new Random();
        return shapeObject.values()[random.nextInt(shapeObject.values().length)];
    }
    private static shapeColour getRandomColor() {
        Random random = new Random();
        return shapeColour.values()[random.nextInt(shapeColour.values().length)];
    }

    public static void main(String[] args) {
        //Part 1: Sorted Set
        String[] names = {"Dick", "Richard", "Ricky", "Jeffery", "Peter", "Johnson", "Willy", "Wang", "Abraham", "James"};
        SortedSet<String> sortingSet = new TreeSet<String>();
        for (String name:names)
            sortingSet.add(name);
        System.out.println("This SortedSet function loops through a string Array and sorts them alphabetically: \n" + sortingSet);



//        Part 2: HashMap
        Map<String, String> carInfo = new HashMap<String, String>();
        carInfo.put("Model", "Volkswagen Passat");
        carInfo.put("Year", "2013");
        carInfo.put("Colour", "Silver");
        carInfo.put("Price", "$13995");
        System.out.println("\nModel: " + carInfo.get("Model") + "\nYear: " + carInfo.get("Year")
                + "\nColour: " + carInfo.get("Colour") + "\nPrice: " + carInfo.get("Price"));

        //Part 3. Random population HashMap w/ Enums
        Random rand = new Random();
        Map<String, String> hashObject = new HashMap<String, String>();
        hashObject.put("Shape", getRandomObject().toString());
        hashObject.put("Size", Integer.toString(rand.nextInt(10)));
        hashObject.put("Colour", getRandomColor().toString());
        hashObject.put("Position", Integer.toString(rand.nextInt(10)));
        System.out.println("\nShape: " + hashObject.get("Shape") + "\nSize: " + hashObject.get("Size")
                + "\nColour: " + hashObject.get("Colour") + "\nPosition: " + hashObject.get("Position"));

    }
}
