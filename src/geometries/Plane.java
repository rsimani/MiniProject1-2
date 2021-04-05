package geometries;
import primitives.*;
import primitives.Vector;
import java.util.List;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane implements Geometry 
{

    Point3D _p; 
    Vector _normal;
    public Vector getNormal(Point3D p)
    {
        return _normal;
    }
    public Point3D get_p()
    {
        return _p;
    }
    public Vector get_normal()
    {
        return _normal;
    }
    public Plane(Point3D p1, Point3D p2, Point3D p3)
    {
        super();
        _p =p1;
        Vector U = new Vector(p1, p2);
        Vector V = new Vector(p1, p3);

        Vector N = U.crossProduct(V);

        _normal=N.normalize();
      
    }
 
    public Plane(Point3D point, Vector _normal) 
    {
        super();
        _p = point;
        this._normal = new Vector(_normal);
    }
    public String toString()
    {
        return "Point3D = " + _p +
                " , Normal = " + _normal ;
                
    }
    /* @return list of the intersection that cut with the plane */
	public List<Point3D> findIntsersections(Ray ray) 
	{
		Vector p0Q;
        try {
            p0Q = _p.subtract(ray.getOriginPoint());
        } catch (IllegalArgumentException e) {
            return null; // ray starts from point Q - no intersections
        }

        double nv = _normal.dotProduct(ray.getDirection());
     // if ray is parallel to the plane - no intersections
        if (isZero(nv)) 
            return null;

        double t = alignZero(_normal.dotProduct(p0Q) / nv);

        return t <= 0 ? null : List.of(ray.getPoint(t));
	}

}



