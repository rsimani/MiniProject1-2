package geometries;
import primitives.*;
import java.util.List;
import static primitives.Util.isZero;
public class Tube extends Geometry 
{
	Ray _axisRay;
	double _radius;
    public Tube(Ray ray, double radius)
    {
       this._radius=radius;
        this._axisRay = new Ray(ray);
    }
    public Vector getNormal(Point3D point)
    {
        //The vector from the point of the cylinder to the given point
        Point3D o = _axisRay.getOriginPoint(); // at this point o = p0
        Vector v = _axisRay.getDirection();

        Vector vector1 = point.subtract(o);

        //We need the projection to multiply the _direction unit vector
        double projection = vector1.dotProduct(v);
        if (!isZero(projection)) {
            // projection of P-O on the ray:
            o = o.add(v.scale(projection));
        }

        //This vector is orthogonal to the _direction vector.
        Vector check = point.subtract(o);
        return check.normalize();
    }
    public Ray getAxisRay() 
    {
        return _axisRay;
    }
    public double get_radius() 
    {
        return _radius;
    }

    public String toString()
    {
        return "ray: " + _axisRay +
                ", radius: " + _radius;
    }
   

	@Override
	public List<GeoPoint> findGeoIntsersections(Ray ray) 
	{
		Vector vTube = _axisRay.getDirection();
        Vector vectorV0;
        Vector vXvTube;
        Vector rayDirXvTube;
        try {
            vectorV0 = ray.getOriginPoint().subtract(_axisRay.getOriginPoint());
        } catch (IllegalArgumentException e) {
            vectorV0 = new Vector(0,0,0);
        }
        try {
            rayDirXvTube = vectorV0.crossProduct(vTube);
        } catch (IllegalArgumentException e) {
            rayDirXvTube = new Vector(0,0,0);
        }
        try {
            vXvTube = ray.getDirection().crossProduct(vTube);
        } catch (IllegalArgumentException e) {
            vXvTube = new Vector(0,0,0);
        }

        // Cylinder [Ray(Point A,Vector V), r].
        // Point P on infinite cylinder if ((P - A) x (V))^2 = r^2 * V^2
        // P = O + t * V1
        // expand : ((O - A) x (V) + t * (V1 x V))^2 = r^2 * V^2

        double vTube2 = Util.alignZero(vTube.lengthSquared());
        double a = Util.alignZero(vXvTube.lengthSquared());
        double b = Util.alignZero(2 * vXvTube.dotProduct(rayDirXvTube));
        double c = Util.alignZero(rayDirXvTube.lengthSquared() - (_radius * _radius * vTube2));
        double d = Util.alignZero(b * b - 4 * a * c);
        if (d < 0) return null;
        if (a == 0)
            return null;
        double t1 = Util.alignZero((-b - Math.sqrt(d)) / (2 * a));
        double t2 = Util.alignZero((-b + Math.sqrt(d)) / (2 * a));
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0)
        	return List.of(new GeoPoint(this, ray.getPoint(t1)), new GeoPoint(this, ray.getPoint(t2)));
        if (t1 > 0)
            return List.of(new GeoPoint(this, ray.getPoint(t1)));
        else
            return List.of(new GeoPoint(this, ray.getPoint(t2)));
    }
}


