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
	
	public Camera(Point3D p0, Vector vTo, Vector vUp) throws IllegalArgumentException {
		super();
		if (!isZero(vUp.dotProduct(vTo))) // if vTo doesn't orthogonal to vUp
			throw new IllegalArgumentException("vUp doesnt ortogonal to vTo");
		this.vup = vUp.normalized();
		this.vto = vTo.normalized();
		this.vright = (vTo.crossProduct(vUp)).normalize();
		this.p0 = p0;
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


		Point3D Pc = p0.add(vto.scale(distance));

		double Ry = height / nY;
		double Rx = width / nX;
		double yi = (i - (nY - 1) / 2d) * Ry;
		double xj = (j - (nX - 1) / 2d) * Rx;

		Point3D Pij = Pc;

		if (!isZero(xj)) {
			Pij = Pij.add(vright.scale(xj));
		}
		if (!isZero(yi)) {
			Pij = Pij.add(vup.scale(-yi));
		}

		Vector Vij = Pij.subtract(p0);

		return new Ray(p0, Vij);

	}
}

	
	


