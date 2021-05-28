package renderer;
import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
import primitives.Ray;
import scene.Scene;

public class Render 
{
	private ImageWriter _imageWriter;
	private Camera _camera;
	private RayTracerBase _rayTracer;
   /**
    this function create the background image by the intersection points
    */
	public  Render setImageWriter(ImageWriter imageWriter)
	{
		this._imageWriter=imageWriter;
		return this;
	}
	public  Render setScene(Scene scene)
	{
		
		return this;
	}
	public  Render setCamera(Camera camera)
	{
		this._camera=camera;
		return this;
	}
	public  Render setRayTracer(RayTracerBase rayTracer)
	{
		this._rayTracer=rayTracer;
		return this;
	}
	
    public void renderImage() 
    {
    	if(_imageWriter==null)
    	{
    		throw new MissingResourceException("The imageWriter empty","ImageWriter","_imageWriter");
    	}
    
    	if(_camera==null)
    	{
    		throw new MissingResourceException("The camera empty","Camera","_camera");
    	}
    	if(_rayTracer==null)
    	{
    		throw new MissingResourceException("The rayTracer empty","RayTracerBase","_rayTracer");
    	}
    	
    	
		for (int i = 0; i < _imageWriter.getNx(); i++)
		{
			for (int j = 0; j < _imageWriter.getNy(); j++)	
			{
				Ray ray = _camera.constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), j, i);
				Color rayColor = _rayTracer.traceRay(ray);
				_imageWriter.writePixel(j, i, rayColor); 
			}
		}
		
	

	}
  
   
    /**
     * print the grid of the image
     * @param interval interval between one square to an other
     * @param the color of the grid
     */
    public void printGrid(int interval, Color color) 
    {
    	{
    		if (_imageWriter == null)
    			throw new MissingResourceException("this function must have values in all the fileds", "ImageWriter", "imageWriter");
    		

    		for (int i = 0; i < _imageWriter.getNx(); i++)
    		{
    			for (int j = 0; j < _imageWriter.getNy(); j++)	
    			{
    				if(i % interval == 0 || j % interval == 0)
    					_imageWriter.writePixel(i, j, color); 
    			}
    		}
    	}

    	}
 

    /**
     * write the image
     */
    public void writeToImage()
    {
    	if(_imageWriter==null)
    	{
    		throw new MissingResourceException("The imageWriter empty","ImageWriter","_imageWriter");
    	}
    	_imageWriter.writeToImage();
    }
}



