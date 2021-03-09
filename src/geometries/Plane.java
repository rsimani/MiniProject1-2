package geometries;
import primitives.Point3D;
import primitives.Vector;


public class Plane implements Geometry 
{

    Point3D _p; 
    Vector _normal;
    public Vector getNormal(Point3D p)
    {
        return null;/*_normal*/
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

}
