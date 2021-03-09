package primitives;

public class Vector
{
	Point3D head;
	  public Vector(Vector v)
	  {
	        this(v.head);
	    }
	  public Vector(Point3D p1, Point3D p2)
	  {
	        this(p1.subtract(p2));
	   }
	  public Point3D getHead() 
	  {

        return head;
    }
	public Vector(Coordinate x,Coordinate y,Coordinate z)
	{
		this.head=new Point3D(x.coord,y.coord,z.coord);
		if (head.equals(Point3D.ZERO))
        {
            throw new IllegalArgumentException("Point3D(0.0,0.0,0.0) not valid for vector head");
        }
	}
	 public Vector(double x, double y, double z) 
	 {
	        this.head = new Point3D(x, y, z);
	        if (head.equals(Point3D.ZERO))
	        {
	            throw new IllegalArgumentException("Point3D(0.0,0.0,0.0) not valid for vector head");
	        }
	 }
	 
    public Vector(Point3D p) 
    {
        this.head = new Point3D(p.x.coord, p.y.coord, p.z.coord);
    }
    public Vector add(Vector vector)
    {
        return new Vector(
                this.head.x.coord + vector.head.x.coord,
                this.head.y.coord + vector.head.y.coord,
                this.head.z.coord + vector.head.z.coord);
    }
    public Vector subtract(Vector vector) {
        return new Vector(
        	    this.head.x.coord - vector.head.x.coord,
                this.head.y.coord - vector.head.y.coord,
                this.head.z.coord - vector.head.z.coord);
    }
    public Vector scale(double scalingFactor)
    {
        return new Vector(
                scalingFactor * head.x.coord,
                scalingFactor * head.y.coord,
                scalingFactor * head.z.coord);
    }
    public double dotProduct(Vector v)
    {
        return (this.head.x.coord * v.head.x.coord +
                this.head.y.coord * v.head.y.coord +
                this.head.z.coord * v.head.z.coord);
    }
    public Vector crossProduct(Vector v)
    {
        double w1 = this.head.y.coord * v.head.z.coord - this.head.z.coord * v.head.y.coord;
        double w2 = this.head.z.coord * v.head.x.coord - this.head.x.coord * v.head.z.coord;
        double w3 = this.head.x.coord * v.head.y.coord - this.head.y.coord * v.head.x.coord;

        return new Vector(w1, w2, w3);
    }
    public double lengthSquared()
    {
        double xx = this.head.x.coord * this.head.x.coord;
        double yy = this.head.y.coord * this.head.y.coord;
        double zz = this.head.z.coord * this.head.z.coord;

        return xx + yy + zz;

    }
    public double length()
    {
        return Math.sqrt(lengthSquared());
    }
    public Vector normalize() 
    {

        double x = this.head.x.coord;
        double y = this.head.y.coord;
        double z = this.head.z.coord;

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide by Zero");

        this.head = new Point3D(x / length, y / length, z / length);
        return this;
    }

    public Vector normalized() 
    {
        Vector vector = new Vector(this.head);
        return vector.normalize();
    }
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Vector)) return false;
		Vector other = (Vector)obj;
		return head.equals(other.head);
	}

}
