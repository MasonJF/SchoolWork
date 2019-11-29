package callbackFINAL;

import java.awt.image.Raster;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Scanner  {
	ProcessInterface callback;

	public void register(ProcessInterface callback) {
		this.callback = callback;
		// later on I can call the callback
	}

	public void doScan(Raster raster, String filename) {

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
			for (int y = 0; y < raster.getHeight(); y++) {
				for (int x = 0; x < raster.getWidth(); x++) {
					int[] iArray2 = null;
					int[] iArray1 = raster.getPixel(x, y, iArray2);

					// Output x,y,data as CSV, ignore 0's
					if ((iArray1 != null) && (iArray1[0] != 0) ) {					
						callback.processPoint(writer, x, y, iArray1);  // call the callback
					}
				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
