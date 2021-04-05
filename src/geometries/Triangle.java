package geometries;
import java.util.List;
import primitives.*;
import static primitives.Util.isZero;

public class Triangle extends Polygon 
{
	   public Triangle(Point3D p1, Point3D p2, Point3D p3)
	   {
	        super(p1, p2, p3);
	    }
	   public String toString() 
	   {
	        StringBuilder result = new StringBuilder();
	        for (Point3D p : vertices) 
	        {
	            result.append(p.toString());
	        }
	        return result.toString();
	    }

	    /* @return list of the intersection that cut with the triangle */
	    

	    public List<Point3D> findIntsersections(Ray ray)
        {
	        List<Point3D> intersections = plane.findIntsersections(ray);
	        if (intersections == null) return null;

	        Point3D p0 = ray.getOriginPoint();
	        Vector v = ray.getDirection();

	        Vector v1 = vertices.get(0).subtract(p0);
	        Vector v2 = vertices.get(1).subtract(p0);
	        Vector v3 = vertices.get(2).subtract(p0);

	        double s1 = v.dotProduct(v1.crossProduct(v2));
	        if (isZero(s1)) return null;
	        double s2 = v.dotProduct(v2.crossProduct(v3));
	        if (isZero(s2)) return null;
	        double s3 = v.dotProduct(v3.crossProduct(v1));
	        if (isZero(s3)) return null;


	        return ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) ? intersections : null;

	    }
	}

