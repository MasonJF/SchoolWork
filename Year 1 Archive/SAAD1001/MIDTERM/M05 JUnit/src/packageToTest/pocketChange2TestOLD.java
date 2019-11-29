package packageToTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class pocketChange2TestOLD {

    @Test
    void addSomeChange() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(0, 0, 3, 0, 0, 0, 0);
        System.out.println(change);
    }

    @Test
    void howMuch() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0,0);
        mytest.addSomeChange(2, 2, 2, 2, 2, 2, 2);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        System.out.println(mytest);
        assertEquals(16.82, result);
    }
    @Test
    void howMuch2() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(1, 0, 0, 0, 0, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(0.01, result);
    }
    @Test
    void howMuch3() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 1, 0, 0, 0, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(0.05, result);
    }
    @Test
    void howMuch4() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 1, 0, 0, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(0.10, result);
    }
    @Test
    void howMuch5() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 0, 1, 0, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(0.25, result);
    }
    @Test
    void howMuch6() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 0, 0, 1, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(1.00, result);
    }
    @Test
    void howMuch7() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 0, 0, 0, 1, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(2.00, result);
    }
    @Test
    void howMuch8() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 0, 0, 0, 0, 1);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(5.00, result);
    }
}