package packageToTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class pocketChange3Test {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void addSomeChange() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(1, 0, 0, 0, 0, 0, 0);
        System.out.println(change);
        assertEquals("2 Pennies 1 Nickles 1 Dimes 1 Quarters 1 Loonies 1 Toonies 1 Fivers ", change.toString());
    }
    @org.junit.Test
    public void addSomeChange1() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(0, 1, 0, 0, 0, 0, 0);
        System.out.println(change);
        assertEquals("1 Pennies 2 Nickles 1 Dimes 1 Quarters 1 Loonies 1 Toonies 1 Fivers ", change.toString());

    }
    @org.junit.Test
    public void addSomeChange2() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(0, 0, 1, 0, 0, 0, 0);
        System.out.println(change);
        assertEquals("1 Pennies 1 Nickles 2 Dimes 1 Quarters 1 Loonies 1 Toonies 1 Fivers ", change.toString());

    }
    @org.junit.Test
    public void addSomeChange4() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(0, 0, 0, 1, 0, 0, 0);
        System.out.println(change);
        assertEquals("1 Pennies 1 Nickles 1 Dimes 2 Quarters 1 Loonies 1 Toonies 1 Fivers ", change.toString());

    }
    @org.junit.Test
    public void addSomeChange5() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(0, 0, 0, 0, 1, 0, 0);
        System.out.println(change);
        assertEquals("1 Pennies 1 Nickles 1 Dimes 1 Quarters 2 Loonies 1 Toonies 1 Fivers ", change.toString());

    }
    @org.junit.Test
    public void addSomeChange6() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(0, 0, 0, 0, 0, 1, 0);
        System.out.println(change);
        assertEquals("1 Pennies 1 Nickles 1 Dimes 1 Quarters 1 Loonies 2 Toonies 1 Fivers ", change.toString());

    }
    @org.junit.Test
    public void addSomeChange7() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(0, 0, 0, 0, 0, 0, 1);
        System.out.println(change);
        assertEquals("1 Pennies 1 Nickles 1 Dimes 1 Quarters 1 Loonies 1 Toonies 2 Fivers ", change.toString());

    }
    @org.junit.Test
    public void addSomeChange8() {
        pocketChange3 change = new pocketChange3(1,1,1,1,1,1,1);
        change.addSomeChange(1, 1, 1, 1, 1, 1, 1);
        System.out.println(change);
        assertEquals("2 Pennies 2 Nickles 2 Dimes 2 Quarters 2 Loonies 2 Toonies 2 Fivers ", change.toString());

    }

    @org.junit.Test
    public void howMuch() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0,0);
        mytest.addSomeChange(2, 2, 2, 2, 2, 2, 2);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        System.out.println(mytest);
        assertEquals(16.82, result);
    }
    @org.junit.Test
    public void howMuch2() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(1, 0, 0, 0, 0, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(0.01, result);
    }
    @org.junit.Test
    public void howMuch3() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 1, 0, 0, 0, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(0.05, result);
    }
    @org.junit.Test
    public void howMuch4() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 1, 0, 0, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(0.10, result);
    }
    @org.junit.Test
    public void howMuch5() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 0, 1, 0, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(0.25, result);
    }
    @org.junit.Test
    public void howMuch6() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 0, 0, 1, 0, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(1.00, result);
    }
    @org.junit.Test
    public void howMuch7() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 0, 0, 0, 1, 0);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(2.00, result);
    }
    @org.junit.Test
    public void howMuch8() {
        pocketChange3 mytest = new pocketChange3(0, 0, 0, 0, 0, 0, 0);
        mytest.addSomeChange(0, 0, 0, 0, 0, 0, 1);
        double result = mytest.howMuch();
        System.out.println("how much = " + result);
        assertEquals(5.00, result);
    }
}