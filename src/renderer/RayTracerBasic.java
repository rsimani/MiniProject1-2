package renderer;
import java.util.List;

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
	
	/**/
	@Override
	

	public Color traceRay(Ray ray) 
	{
		List<GeoPoint> intersections = _scene._geometries.findGeoIntsersections(ray);
		if (intersections == null) return _scene._background;
		GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);
		return calcColor(closestPoint, ray);
		}
	/**
	 * Calculate the color of point
	 * 
	 * @param intersection
	 * @param ray
	 * @return return the color of the point by phong model
	 */

	private Color calcColor(GeoPoint intersection, Ray ray) 
	{
		return _scene._ambientLight.getIntensity()
		.add(intersection._geometry.getEmissionColor())
		// add calculated light contribution from all light sources)
		.add(calcLocalEffects(intersection, ray));
		}

	private Color calcLocalEffects(GeoPoint intersection, Ray ray) {
		Vector v = ray.getDirection();
		Vector n = intersection._geometry.getNormal(intersection._point);
		double nv = Util.alignZero(n.dotProduct(v));
		if (nv == 0)
			return Color.BLACK;
		int nShininess = intersection._geometry.getMaterial().nShininess;
		double kd = intersection._geometry.getMaterial().kD, ks = intersection._geometry.getMaterial().kS;
		Color color = Color.BLACK;
		for (LightSource lightSource : _scene.lights) {
			Vector l = lightSource.getL(intersection._point);
			double nl = Util.alignZero(n.dotProduct(l));
			if (nl * nv > 0) { // sign(nl) == sing(nv)
				if(unshaded(lightSource,l, n, intersection)) {
					Color lightIntensity = lightSource.getIntensity(intersection._point);
					color = color
							.add(lightIntensity.scale(calcDiffusive(kd, nl) + calcSpecular(ks, l, n, nl, v, nShininess)));
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
		double p = nShininess;

		Vector R = l.add(n.scale(-2 * nl)); // nl must not be zero!
		double minusVR = -Util.alignZero(R.dotProduct(v));
		if (minusVR <= 0) {
			return 0; // view from direction opposite to r vector
		}
		return (ks * Math.pow(minusVR, p));
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
		if (nl < 0)
			nl = -nl;
		return (nl * kd);
	}
	
	/**
	 * A function that checks for shading between a dot and the light source that is signed
	 * @param l
	 * @param n
	 * @param gp
	 * @return If there is no shading between a point and the light source that is signed
	 */
	private boolean unshaded(LightSource light,Vector l, Vector n, GeoPoint gp) {
		Vector lightDirection = l.scale(-1); // from point to light source
		Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : - DELTA);
		Point3D point = gp._point.add(delta);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = _scene._geometries.findGeoIntsersections(lightRay);
		if (intersections == null) return true;
		double lightDistance = light.getDistance(gp._point);
		for (GeoPoint geoPoint : intersections) {
		if (Util.alignZero(geoPoint._point.distance(gp._point)-lightDistance ) <= 0)
		return false;
		}
		return true;
	}
	
}

