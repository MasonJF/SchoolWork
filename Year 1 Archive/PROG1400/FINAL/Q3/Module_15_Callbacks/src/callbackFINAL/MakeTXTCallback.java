package callbackFINAL;

import java.io.IOException;
import java.io.Writer;

public class MakeTXTCallback implements ProcessInterface {

	@Override
	public void processPoint(Writer writer, int x, int y, int[] iArray1) {
		try {
			// Output formatted data only in x-y position
			Integer data = (Integer) iArray1[0];
			String sdata = String.format(" %06d", data);
			if (x == 0) {
				writer.write("\n"); // new line for new row of x
			}
			writer.write(" " + sdata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
