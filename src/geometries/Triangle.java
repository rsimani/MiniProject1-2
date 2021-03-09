package geometries;
import primitives.Point3D;

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
}
