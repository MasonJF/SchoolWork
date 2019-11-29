package AbstractShape;
/**
 * @Author Mason Fraser
 * @Version 0.3
 * @Date Feb 12 2019
 */
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Square s1 = new Square(rand.nextInt(20), rand.nextInt(20) );
        Square s2 = new Square(rand.nextInt(20), rand.nextInt(20) );
        System.out.println("The area of Square 1 = " +  s1.area());
        System.out.println("The area of Square 2 = " + s2.area());
        Circle c1 = new Circle(rand.nextInt(20), rand.nextInt(20) );
        Circle c2 = new Circle(rand.nextInt(20), rand.nextInt(20) );
        System.out.println("The area of Circle 1 = " + c1.area());
        System.out.println("The area of Circle 2 = " + c2.area());
        Triangle t1 = new Triangle(rand.nextInt(20), rand.nextInt(20) );
        Triangle t2 = new Triangle(rand.nextInt(20), rand.nextInt(20) );
        System.out.println("The area of Triangle 1 = " + t1.area());
        System.out.println("The area of Triangle 2 = " + t2.area());
    }
}
