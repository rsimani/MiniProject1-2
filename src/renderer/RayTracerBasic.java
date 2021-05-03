package renderer;

import java.util.List;

import primitives.*;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase
{
	public RayTracerBasic(Scene scene)
	{
		super(scene);
	}
	@Override
	public Color traceRay(Ray ray) 
	{
		List<Point3D> intersections = _scene._geometries.findIntsersections(ray);
		if (intersections == null) return _scene._background;
		Point3D closestPoint = ray.findClosestPoint(intersections);
		return calcColor(closestPoint);
	}
	private Color calcColor(Point3D point)
	{
		return _scene._ambientLight.get_intensity();
		}

}
