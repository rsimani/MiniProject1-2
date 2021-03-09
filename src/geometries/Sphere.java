package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry 
{
	Point3D _center;
	double _radius;
	   public Sphere(double radius, Point3D center) 
	   {
	       this._radius=radius;
	        this._center = new Point3D(center);

	    }
	    public Vector getNormal(Point3D point)
	    {
	        /*Vector normal = point.subtract(_center);*/
	        return null;/*normal.normalize();*/
	    }
	    public Point3D getCenter()
	    {
	        return new Point3D(_center);
	    }
	    public double get_radius()
	    {
	        return _radius;
	    }
	  
	    public String toString()
	    {
	        return ("point: " + _center + ", radius: " + _radius);
	    }
}
