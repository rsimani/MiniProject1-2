package geometries;
import primitives.*;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;
import java.util.List;



public class Polygon implements Geometry 
{
	protected List<Point3D> vertices;
	
	protected Plane plane;

	
	public Polygon(Point3D... vertices)
	{
		if (vertices.length < 3)
			throw new IllegalArgumentException("A polygon can't have less than 3 vertices");
		this.vertices = List.of(vertices);
	
		plane = new Plane(vertices[0], vertices[1], vertices[2]);
		if (vertices.length == 3)
			return; 

		Vector n = plane.getNormal(null);

		// Subtracting any subsequent points will throw an IllegalArgumentException
		// because of Zero Vector if they are in the same point
		Vector edge1 = vertices[vertices.length - 1].subtract(vertices[vertices.length - 2]);
		Vector edge2 = vertices[0].subtract(vertices[vertices.length - 1]);

		boolean positive = edge1.crossProduct(edge2).dotProduct(n) > 0;
		for (int i = 1; i < vertices.length; ++i) {
			// Test that the point is in the same plane as calculated originally
			if (!isZero(vertices[i].subtract(vertices[0]).dotProduct(n)))
				throw new IllegalArgumentException("All vertices of a polygon must lay in the same plane");
			// Test the consequent edges have
			edge1 = edge2;
			edge2 = vertices[i].subtract(vertices[i - 1]);
			if (positive != (edge1.crossProduct(edge2).dotProduct(n) > 0))
				throw new IllegalArgumentException("All vertices must be ordered and the polygon must be convex");
		}
	}

	 public Plane get_Plane()
	    {
	        return plane;
	    }
	 public List<Point3D> get_vertices()
	    {
	        return vertices;
	    }
	public Vector getNormal(Point3D point)
	{
		return plane.getNormal(null);
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

	    /* @return list of the intersection that cut with the polygon */
	   
	    public List<Point3D> findIntsersections(Ray ray) 
	    {
	        List<Point3D> intersections = plane.findIntsersections(ray);
	        if (intersections == null) return null;

	        Point3D p0 = ray.getOriginPoint();
	        Vector v = ray.getDirection();

	        Vector v1  =vertices.get(1).subtract(p0);
	        Vector v2 = vertices.get(0).subtract(p0);
	        double sign = v.dotProduct(v1.crossProduct(v2));
	        if (isZero(sign))
	            return null;

	        boolean positive = sign > 0;

	        for (int i = vertices.size() - 1; i > 0; --i) {
	            v1 = v2;
	            v2 = vertices.get(i).subtract(p0);
	            sign = alignZero(v.dotProduct(v1.crossProduct(v2)));
	            if (isZero(sign)) return null;
	            if (positive != (sign >0)) return null;
	        }

	        return intersections;
	    }
	}

