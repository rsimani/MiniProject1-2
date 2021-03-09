package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;;
public class Cylinder extends Tube
{
double _height;
public Cylinder(double radius, Ray ray, double height)
{
    super(radius, ray);
    this._height = height;
}
public double get_height()
{
    return _height;
}
public Vector getNormal(Point3D point) 
{
    Point3D o = _axisRay.getOriginPoint();
    Vector v = _axisRay.getDirection();

    // projection of P-O on the ray:
    double t = 0;
    try {
        t = alignZero(point.subtract(o).dotProduct(v));
    } catch (IllegalArgumentException e) { // P = O
        return v;
    }

    // if the point is at a base
    if (t == 0 || isZero(_height - t)) // if it's close to 0, we'll get ZERO vector exception
        return v;

    return null;/*point.subtract(o.add(v.scale(t))).normalize();*/
}
public String toString()
{
    return "height = " + _height +
            " , _axisRay = " + _axisRay +
            " , _radius = " + _radius;
}
}
