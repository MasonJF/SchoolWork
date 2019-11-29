import java.io.BufferedReader;
import java.io.InputStreamReader;

public class M01Java {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE - 12);
        System.out.println(Long.MAX_VALUE - Integer.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + 100);
        for (char i = 0; i <= 255; i++)
            System.out.print(i);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        // I didn't like the way the 1 for loop printed, so I made multiple 4 loops for pretty printing
        for (int x = -3; x <= 15; x++)
            System.out.println(x);
        for (int x = -3; x <= 15; x++)
            System.out.println(x * 5);
        for (int x = -3; x <= 15; x++)
            System.out.println(x / 5);
        for (int x = -3; x <= 15; x++)
            try {
                System.out.println(x / 5 + 5 / (x - 4));
            } catch (Exception e) {
                System.out.println("Cannot divide by zero");
            }
        for (int x = -3; x <= 15; x++)
            System.out.println(x % 5);
        for (int x = -3; x <= 15; x++)
            System.out.println(x & 5);
        int x = -3;
        try {
            do {
                System.out.println(x);
                System.out.println(x * 5);
                System.out.println(x / 5);
                System.out.println(x / 5 + 5 / (x - 4));
                System.out.println(x % 5);
                System.out.println(x & 5);
                x++;
            }
            while (x <= 15);

        }
        catch (Exception e) {
            System.out.println("If you try to divide by zero, you'll have to give me 101%");
        }

        try {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String readString = in.readLine();
        String poopassignment[] = readString.split(" ");
        for(int k = 0; k < poopassignment.length; k++) {
            System.out.println(poopassignment[k]);
        }


            }
        catch (Exception e) {
        }





    }

}

