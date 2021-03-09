package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


import static primitives.Util.isZero;
public class Tube implements Geometry 
{
	Ray _axisRay;
	double _radius;
    public Tube(double radius, Ray ray)
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
        if (!isZero(projection))
        {
            // projection of P-O on the ray:
            o = o.add(v.scale(projection));
        }

        //This vector is orthogonal to the _direction vector.
       /* Vector check = point.subtract(o);*/
       /* return check.normalize();*/
        return null;
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
}
