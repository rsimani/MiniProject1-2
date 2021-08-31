package geometries;
import java.util.*;
import primitives.*;
import primitives.Vector;

import static primitives.Util.*;
/**
 *  class Sphere extends Geometry 
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class Sphere extends Geometry 
{
	private Point3D _center;
	private double _radius;
    /*--------------------------------------------------constructors------------------------------------------------------*/

    public Sphere(Color emissionLight, Material material, double radius, Point3D center) {
      
        this.emission=emissionLight;	

        this._radius=radius;
        this._center = new Point3D(center);
    }  


	   public Sphere(Point3D center, double radius) 
	   {
	       this._radius=radius;
	        this._center = new Point3D(center);

	    }
	   /**
	     * Sphere constructor receiving a Color,Material,Point3D and radius
	     * @param color,Material, radius,center point
	     */
	    public Sphere(Color color, double _radius, Point3D _center) 
	    {
	   
	       
	        this.emission=color;	
	        this._radius=_radius;
	        this._center = _center;
	    }
	    /**
	     * Sphere constructor receiving a Color,Material,Point3D and radius
	     * @param color,Material, radius,center point
	     */
	    /*
	    public Sphere(Color color,Material m, double _radius, Point3D _center) {
	        super(color, m, _radius);
	        this._center = _center;
	    }
	    */

	  
	   public Vector getNormal(Point3D point)
	   {
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

	    

	    /**
	     * A method that receives a ray and checks the points of GeoIntersection of the ray with the sphere
	     *
	     * @param ray the ray received
	     *
	     * @return null / list that includes all the GeoIntersection points (contains the geometry (shape) and the point in 3D)
	     */
	    @Override
	    public List<GeoPoint> findGeoIntersections(Ray ray,double maxDistance) {
	        // In case the Ray exits the center of the ball then surely there is only one intersecting point
	        // within a radius of the beginning of the Ray
	        if (getCenter().equals(ray.getOriginPoint())) {
	            return List.of(new GeoPoint(this,ray.getPoint(get_radius())));
	        }

	        // The procedure is as follows:
	        // We will find the projection of the vector (that connects the head of the ray and the center of the sphere) on the ray,
	        // then we will build the vertical between the center of the sphere and the continuation of the ray.
	        // Then, calculate with the help of Pythagoras:
	        // the length that exists between the point where the vertical meets the ray
	        // and the point where the ray meets the sphere.
	        // Now we will know to add this distance to reach the second point of intersection,
	        // or alternatively subtract this distance to reach the first point of intersection

	        // Vector from the top of the ray to the center of the sphere
	        Vector u = getCenter().subtract(ray.getOriginPoint());

	        // ray's vector
	        Vector v = ray.getDirection();

	        // the projection of the vector (that connects the head of the ray and the center of the sphere) on the ray
	        double tm = alignZero(u.dotProduct(v));

	        // The length of the vertical between the center of the sphere and the continuation of the ray
	        double d = alignZero(Math.sqrt(u.lengthSquared() - tm*tm));

	        // The ray passes out of the sphere
	        if (alignZero(d - get_radius())>=0) {
	            return null;
	        }

	        // calculate with the help of Pythagoras:
	        // the length that exists between the point where the vertical meets the ray
	        // and the point where the ray meets the sphere.
	        double th = alignZero(Math.sqrt(get_radius()*get_radius() - d*d));

	        // The ray is tangent to the sphere
	        if (isZero(th)) {
	            return null;
	        }

	        // add th to reach the second point of intersection
	        double t1 = alignZero(tm + th);

	        // subtract th to reach the first point of intersection
	        double t2 = alignZero(tm - th);

	        if(alignZero(t1)<0 && alignZero(t2)<0){
	            return null;
	        }
	        if (t1 > 0 && t2 > 0) {
	            // Two points of intersection
	            if (alignZero(maxDistance - t1) > 0 && alignZero(maxDistance - t2) > 0) {
	                Point3D P1 = ray.getOriginPoint().add(v.scale(t2));
	                Point3D P2 = ray.getOriginPoint().add(v.scale(t1));
	                return List.of(new GeoPoint(this, P1), new GeoPoint(this, P2));
	            }
	        }

	        // one point of intersection
	        if (t1 >0 && alignZero(maxDistance-t1)> 0 ) {
	            return List.of(new GeoPoint(this,ray.getPoint(t1)));
	        }

	        // one point of intersection
	        if (t2 >0 && alignZero(maxDistance-t2) > 0) {
	            return List.of(new GeoPoint(this,ray.getPoint(t2)));
	        }

	        return null;
	    }
}
