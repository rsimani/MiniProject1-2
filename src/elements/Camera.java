package elements;
import primitives.*;
import static primitives.Util.isZero;

/**
 * A class that describes a camera
 * @author Rivka
 */

public class Camera
{
	
	private Point3D p0;
   
    private Vector vup;
    private Vector vto;
    private Vector vright;
    private double width;
    private double height;
    private double distance;
	/**
     * Returns the Point3D value of P0
     * @return Point3D value
     */
	public Point3D getP0() 
	{
		return new Point3D(p0);
	}
	/**
     * Returns the Vector value of getVup
     * @return Vector value
     */
	public Vector getVup() 
	{
		return new Vector(vup);
	}
	/**
     * Returns the Vector value of getVto
     * @return Vector value
     */
	public Vector getVto() 
	{
		return new Vector(vto);
	}
	
	/**
     * Returns the Vector value of getVright
     * @return Vector value
     */
	public Vector getVright()
	{
		return new Vector(vright);
	}
	/**
     * Returns the value of width
     * @return double value
     */
	public double getWidth()
	{
		return width;
	}
	/**
     * Returns the value of height
     * @return double value
     */
	public double getHeight()
	{
		return height;
	}
	/**
     * Returns the value of distance
     * @return double value
     */
	public double getDistance()
	{
		return distance;
	}
	/**
     * a constructor for the camera element
     * @param p0= the position point of the camera
     * @param Vto= vector of the camera axises
     * @param Vup= vector of the camera axises
     */
	public Camera(Point3D p0 ,Vector vto ,Vector vup) 
	{
		if(vto.dotProduct(vup)!=0)
			throw new IllegalArgumentException("The vectors are not orthogonals!");
		this.p0=new Point3D(p0);
		
		this.vto=vto.normalized();
		this.vup=vup.normalized();
		vright=(this.vto.crossProduct(this.vup)).normalized();
	}
	/**
     * set the value of width and height
     * @return camera value
     */
	public Camera setViewPlaneSize(double width, double height)
	{
		this.width=width;
		this.height=height;
		return this;
	}
	/**
     * set the value of distance
     * @return camera value
     */
	public Camera setDistance(double distance)
	{
		if (isZero(distance)) 
		{
            throw new IllegalArgumentException("distance cannot be 0");
        }
		this.distance=distance;
		return this;
	}
	/**
     * this function create a ray thrown from the camera through a center of a pixel
     * @param nX= number of pixels on x
     * @param nY= number of pixels on y
     * @param j= point of where the pixel start on y
     * @param i= point of where the pixel start on x
     * @return ray thrown from the camera through a center of a pixel
     */
	public Ray constructRayThroughPixel (int nX, int nY, int j, int i)
	{
		//Pc= P0+ d∙Vto
        Point3D pc = p0.add(vto.scale(distance));
        double ry = height / (double)nY;
        double rx = width / (double)nX;
        double xj = ((j - nX / 2d) * rx) + (rx / 2d);
        double yi = ((i - nY / 2d) * ry) + (ry / 2d);
        Point3D pij = pc;
        if (!isZero(xj)) 
        {
            pij = pij.add(vright.scale(xj));
        }
        if (!isZero(yi)) {
            pij = pij.add(vup.scale(-yi));
        }
        Vector vij = pij.subtract(p0);
        Ray ray = new Ray(new Point3D(p0),new Vector(vij));
        return ray;
        }
}

	
	


