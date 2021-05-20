package elements;
import primitives.*;
/**
 * abstract class
 * 
 * @author Rivka Simani-Bohbot
 *
 */
abstract class Light
{
	private Color intensity;
	/**
	 * Constructor
	 * 
	 * @param intensity
	 */
	protected Light(Color intensity) 
	{
		super();
		this.intensity = intensity;
	}

	/**
	 * getter to intensity
	 * 
	 * @return intensity Color
	 */
	public Color getIntensity() 
	{
		return intensity;
	}

}

