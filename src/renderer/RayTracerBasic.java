package renderer;
import java.util.List;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;
import elements.LightSource;
import geometries.Intersectable.GeoPoint;
import primitives.*;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase
{
	
	public RayTracerBasic(Scene scene)
	{
		super(scene);
	}
	/**
	 * Size of moving the rays for shading rays
	 */
	private static final double DELTA = 0.1;
	private static final int MAX_CALC_COLOR_LEVEL = 10;
	private static final double MIN_CALC_COLOR_K = 0.001;
	private static final double INITIAL_K = 1.0;
	
	/**/
	@Override
	

	public Color traceRay(Ray ray) 
	{
		{

			GeoPoint closestPoint = findClosestIntersection(ray);
			return closestPoint == null ? _scene._background : calcColor(closestPoint, ray);
	}

		}
	/**
	 * Calculate the color of point
	 * 
	 * @param intersection
	 * @param ray
	 * @return return the color of the point by phong model
	 */

	private Color calcColor(GeoPoint geopoint, Ray ray) 
	{
		return calcColor(geopoint, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(_scene._ambientLight.getIntensity());
	}

	/**
	 * Function for calculating a point color - recursive function	
	 * @param point Point3D value
	 * @return Color
	 * @throws IllegalArgumentException 
	 * */
	private Color calcColor(GeoPoint intersection, Ray ray, int level, double k) throws IllegalArgumentException 
	{
		/*𝑰𝑷 = 𝒌𝑨 ∙ 𝑰𝑨 + 𝑰𝑬 + (𝒌𝑫 ∙ |𝒍 ∙ 𝒏| + 𝒌𝑺 ∙ (−𝒗 ∙ 𝒓)^ 𝒏𝒔𝒉)) ∙ 𝑰L*/
		//Color KaIa = myscene.ambientLight.getIntensity();
		Color Ie = intersection._geometry.getEmissionColor(); 

		Color color = Ie.add(calcLocalEffects(intersection, ray,k));
		return 1 == level ? color : color.add(calcGlobalEffects(intersection, ray, level, k , intersection._geometry.getNormal(intersection._point)));

	}

	/**
	 * A function that calculate the globals effects of the color
	 * @param intersection GeoPoint value
	 * @param ray Ray value
	 * @param level int value
	 * @param k double value
	 * @param n Vector value
	 * @return Color
	 * */
	private Color calcGlobalEffects(GeoPoint intersection, Ray ray, int level, double k , Vector n)
	{
		if (level == 1 || k < MIN_CALC_COLOR_K)
		{
			return Color.BLACK;
		}
		Color color = Color.BLACK;
		Material material = intersection._geometry.getMaterial();
		double kr = material.kR;
		double kkr = k * kr;
		if (kkr > MIN_CALC_COLOR_K) 
		{
			Ray reflectedRay = constructReflectedRay(n, intersection._point, ray);
			GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
			if (reflectedPoint != null)
				color = color.add(calcColor(reflectedPoint, reflectedRay, level - 1, kkr).scale(kr));
			else
				color = color.add(_scene._background.scale(kr));
		}
		double kt = material.kT;
		double kkt = k * kt;
		if (kkt > MIN_CALC_COLOR_K) 
		{
			Ray refractedRay = constructRefractedRay(n, intersection._point, ray);
			GeoPoint refractedPoint = findClosestIntersection(refractedRay);
			if (refractedPoint != null)
				color = color.add(calcColor(refractedPoint, refractedRay, level - 1, kkt).scale(kt));
			else
				color = color.add(_scene._background.scale(kt));
		}
		return color;
	}
	/**
	 * help function that calculate the local color
	 * @param intersection GeoPoint value
	 * @param ray Ray value
	 * */
	private Color calcLocalEffects(GeoPoint intersection, Ray ray, double k) 
	{
		Vector v = ray.getDirection().normalize();
		Vector n = intersection._geometry.getNormal(intersection._point);
		double nv = alignZero(n.dotProduct(v));
		if (nv == 0) 
			return Color.BLACK;
		
		Material material = intersection._geometry.getMaterial();
		int nShininess = material.nShininess;
		double kd = material.kD;
		double ks = material.kS;
		Color color = Color.BLACK; 
		for (LightSource lightSource : _scene.lights) 
		{
			Vector l = lightSource.getL(intersection._point);
			double nl = alignZero(n.dotProduct(l));
			if (nl * nv > 0) 
			{ 
				double ktr = transparency(lightSource, l, n, intersection);
				if (ktr * k > MIN_CALC_COLOR_K) 
				{
				// sign(nl) == sing(nv)
//				if (unshaded(l,n, intersection,lightSource)) 
//				{
					Color lightIntensity = lightSource.getIntensity(intersection._point).scale(ktr);;
					color = color.add(lightIntensity.scale((calcDiffusive(kd, nl)+calcSpecular(ks, l, n, nl, v, nShininess))));
				}
			}
		}
		return color;
	}

	/**
	 * Calculate Specular component of light reflection.
	 *
	 * @param ks         specular component coef
	 * @param l          direction from light to point
	 * @param n          normal to surface at the point
	 * @param nl         dot-product n*l
	 * @param v          direction from point of view to point
	 * @param nShininess shininess level
	 * @param ip         light intensity at the point
	 * @return specular component light effect at the point
	 * @author Dan Zilberstein
	 *         <p>
	 *         Finally, the Phong model has a provision for a highlight, or
	 *         specular, component, which reflects light in a shiny way. This is
	 *         defined by [rs,gs,bs](-V.R)^p, where R is the mirror reflection
	 *         direction vector we discussed in class (and also used for ray
	 *         tracing), and where p is a specular power. The higher the value of p,
	 *         the shinier the surface.
	 */
	private double calcSpecular(double ks, Vector l, Vector n, double nl, Vector v, int nShininess) {
		{
			//𝒓 = 𝒍 − 𝟐 ∙( 𝒍 ∙ 𝒏) ∙n 
			Vector r = l.subtract(n.scale(alignZero(2*nl))).normalize();
			double RV = alignZero(r.dotProduct(v));
			double minusRV = RV*(-1);
			if (minusRV <= 0)
				return 0;
			return alignZero(Math.pow(minusRV, nShininess))*ks;
		}


	}

	/**
	 * Calculate Diffusive component of light reflection.
	 *
	 * @param kd diffusive component coef
	 * @param nl dot-product n*l
	 * @param ip light intensity at the point
	 * @return diffusive component of light reflection
	 * @author Dan Zilberstein
	 *         <p>
	 *         The diffuse component is that dot product n•L that we discussed in
	 *         class. It approximates light, originally from light source L,
	 *         reflecting from a surface which is diffuse, or non-glossy. One
	 *         example of a non-glossy surface is paper. In general, you'll also
	 *         want this to have a non-gray color value, so this term would in
	 *         general be a color defined as: [rd,gd,bd](n•L)
	 */
	private double calcDiffusive(double kd, double nl) {
		return alignZero(Math.abs(nl)*kd);
	}
	
	/**
	 * A function that checks for shading between a dot and the light source that is signed
	 * @param l
	 * @param n
	 * @param gp
	 * @return If there is no shading between a point and the light source that is signed
	 */

	private boolean unshaded(Vector l, Vector n, GeoPoint geopoint , LightSource light)
	{
		Vector lightDirection = l.scale(-1); // from point to light source
//		Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);// where we need to move the point
//		Point3D point = geopoint.point.add(delta);// moving the point
		Ray lightRay = new Ray(geopoint._point, lightDirection, n); // refactored ray head move
		List<GeoPoint> intersections = _scene._geometries.findGeoIntsersections(lightRay);
		if (intersections == null) 
			return true;
		double lightDistance = light.getDistance(geopoint._point);
		for (GeoPoint gp : intersections) 
		{
			if (alignZero(gp._point.distance(geopoint._point) - lightDistance) <= 0 && gp._geometry.getMaterial().kT == 0)
				return false;
		}
		return true;
	}
	
/**
 * A function that allows partial shading
 * 
 * @param light LightSource value
 * @param l Vector value
 * @param n Vector value
 * @param geoPoint GeoPoint value
 * */

	private double transparency(LightSource light, Vector l, Vector n, GeoPoint geopoint) 
	{
	Vector lightDirection = l.scale(-1); // from point to light source
	Ray lightRay = new Ray(geopoint._point, lightDirection, n);
	double lightDistance = light.getDistance(geopoint._point); 
	var intersections = _scene._geometries.findGeoIntsersections(lightRay);
	if (intersections == null) return 1.0;
	double ktr = 1.0;
	for (GeoPoint gp : intersections) {
	
		if (alignZero(gp._point.distance(geopoint._point) - lightDistance) <= 0)
	{
	ktr *= gp._geometry.getMaterial().kT;
	if (ktr < MIN_CALC_COLOR_K) return 0.0;
	}
	}
	return ktr;
	}


/**
 * A function that find the most closet point to the ray
 * @param ray Ray value
 * @return the closet point
 * */
private GeoPoint findClosestIntersection(Ray ray)
{
	List<GeoPoint> intersections = _scene._geometries.findGeoIntsersections(ray);
	if(intersections == null)
		return  null;
	return ray.getClosestGeoPoint(intersections);
}
/**
 * A function that calculates the refracted rays.
 * @param normal Vector value
 * @param point Point3D value
 * @param ray Ray value
 * @return ray for refracted
 * */
private Ray constructRefractedRay(Vector normal, Point3D point, Ray ray) //שקיפות
{
	Vector v = ray.getDirection();
//	Vector delta = normal.scale(normal.dotProduct(v) > 0 ? DELTA : -DELTA);
//	Point3D pointDelta = point.add(delta);
	return new Ray(point, v ,normal);
}

/**
 * A function that calculates the reflected rays.
 * @param normal Vector value
 * @param point Point3D value
 * @param ray Ray value
 * @return ray for reflected
 * */
private Ray constructReflectedRay(Vector normal, Point3D point, Ray ray) //השתקפות
{
	// 𝒓 = 𝒗 − 𝟐 ∙ (𝒗 ∙ 𝒏) ∙ n
	Vector v = ray.getDirection();
	double nv = alignZero(normal.dotProduct(v));
	if (isZero(nv))
		return null;
	Vector r = v.subtract(normal.scale(nv*2));
//	Vector delta = normal.scale(normal.dotProduct(r) > 0 ? DELTA : - DELTA);
//	Point3D p = point.add(delta);

	return new Ray(point, r, normal);
}


}
