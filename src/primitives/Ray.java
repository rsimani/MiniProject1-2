package primitives;
import static primitives.Util.isZero;
public class Ray 
{
	private final Point3D p0;
   
    private final Vector dir;
	

public Ray(Point3D point, Vector direction)
{
	p0 = new Point3D(point);
	dir = direction.normalized();
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
  return dir;
}
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
public Point3D getPoint(double length) 
{
     return isZero(length ) ?p0 : p0.add(dir.scale(length));
}
}
