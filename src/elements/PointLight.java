package elements;

import primitives.*;
/**
 * class PointLight extends Light implements LightSource
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class PointLight extends Light implements LightSource
{
	private Point3D position;
	private double kC=1;
	private double kL=0;
    private double kQ=0;
    protected double _radius = 0d;
	/**
	 * Constructor
	 * 
	 * @param intensity
	 * @param position
	 */
	public PointLight(Color intensity, Point3D position) 
	{
		super(intensity);
		this.position = position;
	}

	/**
	 * Setter to kC
	 * 
	 * @param kC
	 * @return this-object
	 */
	public PointLight setkC(double kC) 
	{
		this.kC = kC;
		return this;
	}
	/**
	 * Setter to kL
	 * 
	 * @param kL
	 * @return this-object
	 */
	public PointLight setkL(double kL) 
	{
		this.kL = kL;
		return this;
	}
	/**
	 * Setter to kQ
	 * 
	 * @param kQ
	 * @return this-object
	 */
	public PointLight setkQ(double kQ) 
	{
		this.kQ = kQ;
		return this;
	}
	
	@Override
	public Color getIntensity(Point3D p) 
	{
		double dXd = p.distanceSquared(position);
		double d = p.distance(position);
		Color intensity = getIntensity().scale(1 / (kC + kL * d + kQ * dXd));
		return intensity;
	}

	@Override
	public Vector getL(Point3D p)
	{
		if (p.equals(position))
		{
			return null;
		}
		return p.subtract(position).normalized();
	}
	
	/**
	 * @param point
	 * @return The distance between the points
	 */
	public double getDistance(Point3D point) 
	{
		return this.position.distance(point);
	}
	/**
	 * constructor to the point light source
	 * @param color _intensity value, _position value,_kC value , _kL value, _kQ value
	 */
		public PointLight(Color color,Point3D p,double kc,double kl,double kq) {
			super(color);
			position=p;
			kC=kc;
			kL=kl;
			kQ=kq;
			}
		
		public PointLight(Color color, Point3D p, double kc, double kl, double kq, double radius) {
	        this(color, p, kc, kl, kq);
	        this._radius = radius;
	    }
	

}




