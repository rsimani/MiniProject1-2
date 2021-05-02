package unittests;
import renderer.ImageWriter;
import java.awt.*;
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
    public void ImageWiterWriteToImageTest()
    {
        ImageWriter imageWriter = new ImageWriter("ImageWriterTest", 800, 500);
  /*      , 1600, 1000*/
       
        int Nx = imageWriter.getNx();
        int Ny = imageWriter.getNy();
        for (int i = 0; i < Ny; i++) {
            for (int j = 0; j < Nx; j++) {
                if (i % 50 == 0 || j % 50 == 0)
                {
                    imageWriter.writePixel(j, i,java.awt.Color.BLUE);
                
                }
                else
                {
                    imageWriter.writePixel(j, i, java.awt.Color.GRAY);
                }
            }
        }
        imageWriter.writeToImage();
    }

}
