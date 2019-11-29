package callbackFINAL;

import java.io.IOException;
import java.io.Writer;

public class MakeCSVCallback implements ProcessInterface {

	@Override
	public void processPoint(Writer writer, int x, int y, int[] iArray1) {
		try {
			writer.write(x + ", " + y);
			for (int element : iArray1) {
				writer.write(", " + element); // x,y,data
			}
			writer.write("\n"); // x,y,data
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
