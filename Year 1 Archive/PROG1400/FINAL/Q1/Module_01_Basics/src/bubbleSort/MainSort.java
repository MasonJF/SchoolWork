package bubbleSort;

/**
 *
 * @author Russ
 */
public class MainSort {

    public static void main (String[] args) {
        Bubble_Sort b1 = new Bubble_Sort("chickenbutt");
        b1.sort_1();
        b1.printAll();
    
        Bubble_Sort b2 = new Bubble_Sort("chickenbutt");
        b2.sort_2();
        b2.printAll();

        Bubble_Sort b3 = new Bubble_Sort("abcdefga");
        b3.sort_1();
        b3.printAll();

        Bubble_Sort b4 = new Bubble_Sort("abcdefga");
        b4.sort_2();
        b4.printAll();
    }
}
