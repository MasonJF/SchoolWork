package readPNG;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.imageio.ImageIO;

/**
 * 
 * @author Russ
 * 
 *         Open a png file and dump it's raster data
 *
 */
public class ReadPNGData {

	public static void main(String[] args) {

		String rawFile = "dots";

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("png/" + rawFile + ".png")); //Modified to work on MacOS.
		} catch (IOException e) {
			e.printStackTrace();
		}

		// unpack the image
		Raster raster = img.getRaster();

		DumpDataAsCSV(raster, rawFile + ".csv");
		DumpDataAsFormat(raster, rawFile + ".txt");

		System.out.println("Finished...success!!!  ...files should be in project root directory");
	}

	public static void DumpDataAsCSV(Raster raster, String filename) {

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
			for (int y = 0; y < raster.getHeight(); y++) {
				for (int x = 0; x < raster.getWidth(); x++) {
					int[] iArray2 = null;
					int[] iArray1 = raster.getPixel(x, y, iArray2);

					// Output x,y,data as CSV, ignore 0's
					if ((iArray1 != null) && (iArray1[0] != 0)) {
						writer.write(x + " ," + y); // x,y,data
						for (int element : iArray1) {
							writer.write(" ," + element); // x,y,data
						}
						writer.write("\n"); // x,y,data
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

	public static void DumpDataAsFormat(Raster raster, String filename) {

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
			for (int y = 0; y < raster.getHeight(); y++) {
				for (int x = 0; x < raster.getWidth(); x++) {

					int[] iArray2 = null;
					int[] iArray1 = raster.getPixel(x, y, iArray2);

					// Output formatted data only in x-y position
					Integer data = (Integer) iArray1[0];
					String sdata = String.format(" %06d", data);	
					if (x == 0) {
						writer.write("\n");  // new line for new row of x
					}
					writer.write(" " + sdata);	
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
