package primitives;
import static primitives.Util.isZero;
import static primitives.Util.alignZero;
import geometries.Intersectable.GeoPoint;
import java.util.List;
public class Ray 
{
   Point3D p0;
   Vector dir;
	

	/**
	 * A constant for the size of moving first rays for shading rays
	 * */
	private static final double DELTA = 0.1;
	
public Ray(Point3D point, Vector direction)
{

	this.p0=point;
	this.dir=direction;
	dir.normalize();
}
public Ray(Point3D head, Vector lightDirection, Vector n) 
{
	if(alignZero(lightDirection.dotProduct(n)) < 0)
		 p0= head.add(n.scale(-DELTA));
	else if(alignZero(lightDirection.dotProduct(n)) > 0)
		 p0= head.add(n.scale(DELTA));
	else if(isZero(lightDirection.dotProduct(n)))
		 p0=head;
	dir=lightDirection;
	dir.normalize();		
}

public Ray(Ray other)
{
    this.p0 = new Point3D(other.p0);
    this.dir = new Vector(other.dir);

}
public Point3D getOriginPoint() 
{
//  return new Point3D(_point);
  return p0;
}
public Vector getDirection()
{
//  return new Vector(_direction);
  return dir.normalize();
}


public Point3D getPoint(double t) throws IllegalArgumentException
{
	return p0.add(dir.scale(t));
}
/*this function get list of points and return the most*/
public Point3D findClosestPoint(List<Point3D> points) 
{

    Point3D result = null;
    double minD = Double.MAX_VALUE;
    for (Point3D p : points) 
    {
        double distance = p0.distance(p);
        if (distance < minD) {
            minD = distance;
            result = p;
        }
    }
    return result;
}

/**
 * chek which point is the closest to the camera
 * @param points list of all the points
 * @return the closest cutting point with p0
 */

public GeoPoint findClosestGeoPoint(List<GeoPoint> points) 
{
	if (!points.isEmpty())
	{
		GeoPoint closest = points.get(0);
		double d = this.p0.distance(points.get(0)._point);
		double temp;
		for (int i = 1; i < points.size(); i++) 
		{
			temp = this.p0.distance(points.get(i)._point);
			if (temp < d)
			{
				d = temp;
				closest = points.get(i);
			}
		}
		return closest;
	} else
		return null;
}

public GeoPoint getClosestGeoPoint(List<GeoPoint> intersections)
{
	
	if(intersections == null)
		return null;
	GeoPoint closet = intersections.get(0);
	for (GeoPoint geoPoint : intersections) 
	{
		if(geoPoint._point.distance(p0) < closet._point.distance(p0))
			closet= geoPoint;
		
	}
	return closet;
}

/***********************************************************/

public boolean equals(Object obj)
{
	if (this == obj) return true;
	if (obj == null) return false;
	if (!(obj instanceof Ray)) return false;
	Ray other = (Ray)obj;
	return p0.equals(other.p0)&&dir.equals(other.dir);

}
public String toString() 
{
    return "point: " + p0 + ", direction: " + dir;
}



}
