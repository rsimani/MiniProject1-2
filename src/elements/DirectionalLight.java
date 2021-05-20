package elements;

import primitives.*;
/**
 * class DirectionalLight extends from Light and implements LightSource
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class DirectionalLight extends Light implements LightSource
{
	private Vector direction;
	/**
	 * Constructor
	 * 
	 * @param intensity
	 * @param vector
	 */
	public DirectionalLight(Color intensity, Vector vector) 
	{
		super(intensity);
		this.direction = vector.normalized();
	}
	@Override
	public Color getIntensity(Point3D p)
	{
		return super.getIntensity();
	}

	@Override
	public Vector getL(Point3D p)
	{
		return direction;
	}
	
	/**
	 * @param point
	 * @return The distance between the points
	 */
	public double getDistance(Point3D point) {
		return Double.POSITIVE_INFINITY;
	}

}

