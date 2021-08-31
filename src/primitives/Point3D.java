package primitives;
import static primitives.Util.alignZero;;
public class Point3D
{
	  public final static Point3D ZERO = new Point3D(0.0, 0.0, 0.0);

	    final Coordinate x;
	    final Coordinate y;
	    final Coordinate z;
	    public Point3D(Coordinate x, Coordinate y, Coordinate z)
	    {
	        this(x.coord, y.coord, z.coord);
	    }

	    public Point3D(Point3D point3D) {
	        this(point3D.x.coord, point3D.y.coord, point3D.z.coord);
	    }

	    public Point3D(double x, double y, double z)
	    {
	        this.x = new Coordinate(x);
	        this.y = new Coordinate(y);
	        this.z = new Coordinate(z);
	    }
	    /*--------------------------------------------------getters and setters------------------------------------------------------*/

	    public Coordinate getX() {
	        return x;
	    }

	    public Coordinate getY() {
	        return  y;
	    }

	    public Coordinate getZ() {
	        return z;
	    }

	    /**
	     * x getter as the value of a double
	     *
	     * @return x
	     */
	    public double getXDouble() {
	        return alignZero(x.coord);
	    }

	    /**
	     * y getter as the value of a double
	     *
	     * @return y
	     */
	    public double getYDouble() {
	        return alignZero(y.coord);
	    }

	    /**
	     * z getter as the value of a double
	     *
	     * @return z
	     */
	    public double getZDouble() {
	        return alignZero(z.coord);
	    }

	    public Vector subtract(Point3D otherPoint3D) 
	    {
	        return new Vector(
	                this.x.coord - otherPoint3D.x.coord,
	                this.y.coord - otherPoint3D.y.coord,
	                this.z.coord - otherPoint3D.z.coord);
	    }
	
	
    public Point3D add(Vector vector)
    {
        return new Point3D(
                this.x.coord + vector.getHead().x.coord,
                this.y.coord + vector.getHead().y.coord,
                this.z.coord + vector.getHead().z.coord);
    }
    /**
     * produce a new Point3D with the other Point3D values added
     * to current point values
     *
     * @param point3D other point
     * @return new Point3D with added values
     */
    public Point3D add(Point3D point3D) {
        return new Point3D(
                this.x.coord + point3D.x.coord,
                this.y.coord + point3D.y.coord,
                this.z.coord + point3D.z.coord);
    }

    public double distanceSquared(Point3D otherPoint3D)
    {
        return ((otherPoint3D.x.coord - this.x.coord) * (otherPoint3D.x.coord - this.x.coord) +
                (otherPoint3D.y.coord - this.y.coord) * (otherPoint3D.y.coord - this.y.coord) +
                (otherPoint3D.z.coord - this.z.coord) * (otherPoint3D.z.coord - this.z.coord));
    }

    public double distance(Point3D otherPoint3D) 
    {
        return Math.sqrt(distanceSquared(otherPoint3D));
    }
    public String toString()
    {
        return "(" +
                x +
                ", " + y +
                ", " + z +
                ')';
    }
	   public boolean equals(Object obj) 
	   {
		  
			   if (this == obj) return true;
			   if (obj == null) return false;
			   if (!(obj instanceof Point3D)) return false;
			   Point3D other = (Point3D)obj;
			   return x.equals(other.x) && y.equals(other.y) && z.equals(other.z);

		   }
	 


}
