package geometries;
import static primitives.Util.*;
import java.util.*;
import primitives.*;
import primitives.Vector;
/**
 *  class Cylinder
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class Cylinder extends Tube
{
private double _height;
private double radius;
public Cylinder(double radius, Ray ray, double height)
{
    super( ray,alignZero(radius));
    this._height = alignZero(height);
    this.radius = alignZero(radius);
}

/**
 * @param emissionLight
 * @param material
 * @param radius
 * @param p1
 * @param p2
 */

public Cylinder(Color emissionLight, Material material, double radius, Point3D p1, Point3D p2) {
    super(emissionLight, material, radius, new Ray(p1, p2.subtract(p1)));
    this._height = p1.distance(p2);
}
public double get_height()
{
	 return alignZero(_height);
}
/**
 * getter for radius
 *
 * @return radius of cylinder
 */
public double getRadius() {
    return alignZero(radius);
}   
/**
 * getter for cylinder normal
*
* @param point3D init point
*
* @return normal of cylinder
*/
@Override
public Vector getNormal(Point3D point) 
{
    Point3D o = _axisRay.getOriginPoint();
    Vector v = _axisRay.getDirection();

 // if the given point equals the ray's head it produce a ZERO vector, so we return the normal (dir)
    if (point.equals(o))
    {
        return v.normalized();
    }
    Vector vector1  = point.subtract(o);
   
    double d = alignZero(
            -1d*(
                    v.getHead().getXDouble()*o.getXDouble() +
                    v.getHead().getYDouble()*o.getYDouble() +
                    v.getHead().getZDouble()*o.getZDouble()));

    //we need the projection to multiply the direction until unit vector
    double projection = alignZero(vector1.dotProduct(v));

    // Check that the point is not outside the cylinder
    if(!(projection <= 0) && (projection <= _height)){
        //projection of p0 on the ray:
        o = o.add(v.scale(projection));
    }

    // sliding vector of the point given
    double DGiven = alignZero(
            -1d*(
                    v.getHead().getXDouble()*point.getXDouble() +
                    v.getHead().getYDouble()*point.getYDouble() +
                    v.getHead().getZDouble()*point.getZDouble()));

    if (DGiven == d || DGiven == d - _height){
        return v.normalized();
    }

    //this vector is orthogonal to the dir vector
    Vector check = point.subtract(o);
    return check.normalize();

    }   /**
 * A method that receives a ray and checks the points of GeoIntersection of the ray with the cylinder
*
* @param ray the ray received
*
* @return null / list that includes all the GeoIntersection points (contains the geometry (shape) and the point in 3D)
*/
@Override
public List<GeoPoint> findGeoIntersections(Ray ray) {

   // The procedure is as follows:
   // P1 and P2 in the cylinder, the center of the bottom and upper bases
   Point3D p1 = _axisRay.getOriginPoint();
   Point3D p2 = _axisRay.getPoint(_height);
   Vector Va = _axisRay.getDirection();

   List<GeoPoint> list = super.findGeoIntersections(ray);

   // the intersections with the cylinder
   List<GeoPoint> result = new LinkedList<>();

   // Step 1 - checking if the intersections with the tube are points on the cylinder
   if (list != null) {
       for (GeoPoint p : list) {
           if (Va.dotProduct(p.point3D.subtract(p1)) > 0 && Va.dotProduct(p.point3D.subtract(p2)) < 0)
               result.add(0, p);
       }
   }

   // Step 2 - checking the intersections with the bases

   // cannot be more than 2 intersections
   if(result.size() < 2) {
       //creating 2 planes for the 2 bases
       Plane bottomBase = new Plane(p1, Va);
       Plane upperBase = new Plane(p2, Va);
       GeoPoint p;

       // ======================================================
       // intersection with the bases:

       // intersections with the bottom bases
       list = bottomBase.findGeoIntersections(ray);

       if (list != null) {
           p = list.get(0);
           // checking if the intersection is on the cylinder base
           if (p.point3D.distanceSquared(p1) < radius * radius)
               result.add(p);
       }

       // intersections with the upper bases
       list = upperBase.findGeoIntersections(ray);

       if (list != null) {
           p = list.get(0);
           //checking if the intersection is on the cylinder base
           if (p.point3D.distanceSquared(p2) < radius * radius)
               result.add(p);
       }
   }
   // return null if there are no intersections.
   return result.size() == 0 ? null : result;
}


@Override
public String toString() {
   return "Cylinder{" +
           "height=" + _height +
           ", axisRay=" + _axisRay +
           ", radius=" + radius +
           '}';
}
}