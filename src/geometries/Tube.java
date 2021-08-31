package geometries;
import primitives.*;
import java.util.List;
import static primitives.Util.*;
/**
 *  class Tube extends Geometry 
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class Tube extends Geometry 
{
	Ray _axisRay;
	double _radius;
	Material _material;
    public Tube(Ray ray, double radius)
    {
       this._radius=radius;
        this._axisRay = new Ray(ray);
    }
    
    /**
     * constructor for a new Tube object
     *
     * @param _radius       the radius of the tube
     * @param _ray          the direction of the tube from the referenced point
     * @param material      the material of the tube
     * @param emissionLight the emission light of the tube
     *                      <p>
     *                      throws Exception in case of negative or zero radius from RadialGeometry constructor
     */
    public Tube(Color emissionLight, Material material, double _radius, Ray _ray) 
    {
     
        this.emission=emissionLight;
        this._radius=_radius;
        this._axisRay = new Ray(_ray);
        this._material=material;

    }
    public Vector getNormal(Point3D point)
    {
        //The vector from the point of the cylinder to the given point
        Point3D o = _axisRay.getOriginPoint(); // at this point o = p0
        Vector v = _axisRay.getDirection();

        Vector vector1 = point.subtract(o);

        //We need the projection to multiply the _direction unit vector
        double projection = vector1.dotProduct(v);
        if (!isZero(projection)) {
            // projection of P-O on the ray:
            o = o.add(v.scale(projection));
        }

        //This vector is orthogonal to the _direction vector.
        Vector check = point.subtract(o);
        return check.normalize();
    }
    public Ray getAxisRay() 
    {
        return _axisRay;
    }
    public double get_radius() 
    {
        return _radius;
    }

    public String toString()
    {
        return "ray: " + _axisRay +
                ", radius: " + _radius;
    }
   

	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) 
	{
		Vector vTube = _axisRay.getDirection();
        Vector vectorV0;
        Vector vXvTube;
        Vector rayDirXvTube;
        try {
            vectorV0 = ray.getOriginPoint().subtract(_axisRay.getOriginPoint());
        } catch (IllegalArgumentException e) {
            vectorV0 = new Vector(0,0,0);
        }
        try {
            rayDirXvTube = vectorV0.crossProduct(vTube);
        } catch (IllegalArgumentException e) {
            rayDirXvTube = new Vector(0,0,0);
        }
        try {
            vXvTube = ray.getDirection().crossProduct(vTube);
        } catch (IllegalArgumentException e) {
            vXvTube = new Vector(0,0,0);
        }

        // Cylinder [Ray(Point A,Vector V), r].
        // Point P on infinite cylinder if ((P - A) x (V))^2 = r^2 * V^2
        // P = O + t * V1
        // expand : ((O - A) x (V) + t * (V1 x V))^2 = r^2 * V^2

        double vTube2 = Util.alignZero(vTube.lengthSquared());
        double a = Util.alignZero(vXvTube.lengthSquared());
        double b = Util.alignZero(2 * vXvTube.dotProduct(rayDirXvTube));
        double c = Util.alignZero(rayDirXvTube.lengthSquared() - (_radius * _radius * vTube2));
        double d = Util.alignZero(b * b - 4 * a * c);
        if (d < 0) return null;
        if (a == 0)
            return null;
        double t1 = Util.alignZero((-b - Math.sqrt(d)) / (2 * a));
        double t2 = Util.alignZero((-b + Math.sqrt(d)) / (2 * a));
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0)
        	return List.of(new GeoPoint(this, ray.getPoint(t1)), new GeoPoint(this, ray.getPoint(t2)));
        if (t1 > 0)
            return List.of(new GeoPoint(this, ray.getPoint(t1)));
        else
            return List.of(new GeoPoint(this, ray.getPoint(t2)));
    }
    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray,double maxDistance) {

        /*
        The procedure is as follows:
        The equation for a tube of radius r oriented along a line pa + vat:
        (q - pa - (va,q - pa)va)2 - r2 = 0
        get intersections using formula : (p - pa + vt - (va,p - pa + vt)va)^2 - r^2 = 0
        reduces to at^2 + bt + c = 0
        with a = (v - (v,va)va)^2
             b = 2 * (v - (v,va)va,∆p - (∆p,va)va)
             c = (∆p - (∆p,va)va)^2 - r^2
        where  ∆p = p - pa
        */

        Vector v = ray.getDirection();
        Vector va = this.getAxisRay().getDirection();

        // if vectors are parallel then there is no intersections possible
        if (v.normalize().equals(va.normalize()))
            return null;

        // use of calculated variables to avoid vector ZERO
        double vva;
        double pva;
        double a;
        double b;
        double c;

        // check every variables to avoid ZERO vector
        if (ray.getOriginPoint().equals(this.getAxisRay().getOriginPoint())){
            vva = v.dotProduct(va);
            if (vva == 0){
                a = v.dotProduct(v);
            }
            else{
                a = (v.subtract(va.scale(vva))).dotProduct(v.subtract(va.scale(vva)));
            }
            b = 0;
            c = - get_radius() * get_radius();
        }
        else{
            Vector deltaP = ray.getOriginPoint().subtract(this.getAxisRay().getOriginPoint());
            vva = v.dotProduct(va);
            pva = deltaP.dotProduct(va);

            if (vva == 0 && pva == 0){
                a = v.dotProduct(v);
                b = 2 * v.dotProduct(deltaP);
                c = deltaP.dotProduct(deltaP) - get_radius() * get_radius();
            }
            else if (vva == 0){
                a = v.dotProduct(v);
                if (deltaP.equals(va.scale(deltaP.dotProduct(va)))){
                    b = 0;
                    c = - get_radius() * get_radius();
                }
                else{
                    b = 2 * v.dotProduct(deltaP.subtract(va.scale(deltaP.dotProduct(va))));
                    c = (deltaP.subtract(va.scale(deltaP.dotProduct(va))).dotProduct(deltaP.subtract(va.scale(deltaP.dotProduct(va))))) - this.get_radius() * this.get_radius();
                }
            }
            else if (pva == 0){
                a = (v.subtract(va.scale(vva))).dotProduct(v.subtract(va.scale(vva)));
                b = 2 * v.subtract(va.scale(vva)).dotProduct(deltaP);
                c = (deltaP.dotProduct(deltaP)) - this.get_radius() * this.get_radius();
            }
            else {
                a = (v.subtract(va.scale(vva))).dotProduct(v.subtract(va.scale(vva)));
                if (deltaP.equals(va.scale(deltaP.dotProduct(va)))){
                    b = 0;
                    c = - get_radius() * get_radius();
                }
                else{
                    b = 2 * v.subtract(va.scale(vva)).dotProduct(deltaP.subtract(va.scale(deltaP.dotProduct(va))));
                    c = (deltaP.subtract(va.scale(deltaP.dotProduct(va))).dotProduct(deltaP.subtract(va.scale(deltaP.dotProduct(va))))) - this.get_radius() * this.get_radius();
                }
            }
        }

        // calculate delta for result of equation
        double delta = b * b - 4 * a * c;

        if (delta <= 0) {
            return null; // no intersections
        }
        else {
            // calculate points taking only those with t > 0
            double t1 = alignZero((- b - Math.sqrt(delta)) / (2 * a));
            double t2 = alignZero((- b + Math.sqrt(delta)) / (2 * a));
            if (t1 > 0 && t2 > 0) {
                Point3D p1 = ray.getPoint(t1);
                Point3D p2 = ray.getPoint(t2);
                return List.of(new GeoPoint(this,p1),new GeoPoint(this, p2));
            }
            else if (t1 > 0) {
                Point3D p1 = ray.getPoint(t1);
                return List.of(new GeoPoint(this,p1));
            }
            else if (t2 > 0) {
                Point3D p2 = ray.getPoint(t2);
                return List.of(new GeoPoint(this,p2));
            }
        }
        return null;
    }

}


