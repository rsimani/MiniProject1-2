package elements;

import primitives.*;
/**
 *  interface LightSource
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public interface LightSource 
{
	/**
	 * A function that return the intensity at a point
	 * 
	 * @param p- Point3D value
	 * @return the intensity color in this point
	 */
public Color getIntensity(Point3D p);
/**
 * A function that return the vector L of the lighting direction at a point
 * 
 * @param p- Point3D value
 * @return the lighting direction on a point
 */
public Vector getL(Point3D p);
/**
 * 
 * @param point
 * @return
 */
double getDistance(Point3D point);
}


