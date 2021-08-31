package elements;

import primitives.*;
/**
 *  SpotLight extendsfrom PointLight
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class SpotLight extends PointLight
{
private Vector direction;


/**
 * constructor
 * 
 * @param intensity
 * @param position
 * @param direction
 */
public SpotLight(Color intensity, Point3D position, Vector direction)
{
	super(intensity, position);
	this.direction = direction;
}
public SpotLight(Color colorIntensity, Point3D position, Vector direction, double kC, double kL, double kQ) 
{
    super(colorIntensity, position, kC, kL, kQ);
    this.direction = direction.normalized();
  
}




}




