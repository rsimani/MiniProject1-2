package geometries;
import java.util.List;
import primitives.*;
import static primitives.Util.alignZero;

public class Sphere extends Geometry 
{
	Point3D _center;
	double _radius;
	   public Sphere(double radius, Point3D center) 
	   {
	       this._radius=radius;
	        this._center = new Point3D(center);

	    }
	  
	   public Vector getNormal(Point3D point) {
	        Vector normal = point.subtract(_center);
	        return normal.normalize();
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

	    
@Override
public List<GeoPoint> findGeoIntsersections(Ray ray) 
{
	Point3D p0 = ray.getOriginPoint();
    Vector v = ray.getDirection();
    Vector u;
    try {
    	u = _center.subtract(p0);   // p0 == _center
    } catch (IllegalArgumentException e) {
        return List.of(new GeoPoint(this,ray.getPoint(_radius)));
    }
    double tm = alignZero(v.dotProduct(u));
    double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;
    double thSquared = alignZero(_radius * _radius - dSquared);

    if (thSquared <= 0) return null;

    double th = alignZero(Math.sqrt(thSquared));
    if (th == 0) return null;

    double t1 = alignZero(tm - th);
    double t2 = alignZero(tm + th);
    if (t1 <= 0 && t2 <= 0) return null;
    if (t1 > 0 && t2 > 0) return List.of(new GeoPoint(this, ray.getPoint(t1)), new GeoPoint(this, ray.getPoint(t2)));//P1 , P2
    if (t1 > 0)
        return List.of(new GeoPoint(this,ray.getPoint(t1)));
    else
        return List.of(new GeoPoint(this,ray.getPoint(t2)));
}
}

