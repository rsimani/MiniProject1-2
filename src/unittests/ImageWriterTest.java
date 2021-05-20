package unittests;
import renderer.ImageWriter;
import org.junit.Test;

import primitives.Color;
/**
 * Testing ImageWriter
 * @author Rivka simani
 *
 */

public class ImageWriterTest
{

	@Test
	public void ImageWriterTests() 
	{
		int Nx = 800;
		int Ny = 500;
		ImageWriter image = new ImageWriter("image", Nx, Ny);
		Color color1 = new Color(45, 95, 22);
		Color color2 = new Color(100, 5, 122);
		for (int i = 0; i < Ny; i++) {
			for (int j = 0; j < Nx; j++) {
				if (i % 50 == 0 || j % 50 == 0) {
					image.writePixel(j, i, color2);
				} else {
					image.writePixel(j, i, color1);
				}
			}
		}
		image.writeToImage();
	}

}

