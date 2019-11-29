package callbackFINAL;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScanPNG {

	public static void main(String[] args) {
		Scanner scanner = new Scanner();
//		ProcessInterface makeCSVcallBack = new MakeCSVCallback();
//		ProcessInterface makeTXTcallBack = new MakeTXTCallback();
		ProcessInterface makeFinalCallBack = new MakeFinalCallBack();

		// Prepare the raster PNG
		String rawFile = "dots";
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("png/" + rawFile + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// unpack the image
		Raster raster = img.getRaster();

		// Set up callback, scan and build CSV
		scanner.register(makeFinalCallBack);
		scanner.doScan(raster, rawFile + ".csv");
		
		System.out.println("Finished...success!!!  ...files should be in project root directory");

	}
}
