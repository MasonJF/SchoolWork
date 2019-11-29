package callbackFINAL;

import java.io.IOException;
import java.io.Writer;

public class MakeFinalCallBack implements ProcessInterface  {


    @Override
    public void processPoint(Writer writer, int x, int y, int[] iArray1) {
        try {
            for (int element : iArray1) {
                if(element != 255) {
                    writer.write(x + ";" + y + ";" + element + "\n"); //Prints RED BLUE GREEN value for each position
                }// x, y, data  ignores whitespace
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
