package unittests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import elements.Camera;
import geometries.Intersectable;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


public class CameraIntegrationTest 
{
	  
		@Test
		public void testFindIntsersections() {
			// ============ Sphere& Camera Integration Tests ==============

			// TC01: Sphere and camera ray with 2 interaction point
			Camera camera = new Camera(new Point3D(0, 0, 0), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			Sphere sphere = new Sphere(1, new Point3D(0, 0, -3));
			assertEquals("The count of untegrations is not correct", 2, findInteractionPoints(camera, sphere).size());

			// TC02: Sphere and camera ray with 18 interaction point
			camera = new Camera(new Point3D(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			sphere = new Sphere(2.5, new Point3D(0, 0, -2.5));
			assertEquals("The count of untegrations is not correct", 18, findInteractionPoints(camera, sphere).size());

			// TC03: Sphere and camera ray with 10 interaction point
			camera = new Camera(new Point3D(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			sphere = new Sphere(2, new Point3D(0, 0, -2));
			assertEquals("The count of untegrations is not correct", 10, findInteractionPoints(camera, sphere).size());

			// TC04: Sphere and camera ray with 9 interaction point
			camera = new Camera(new Point3D(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			sphere = new Sphere(4, new Point3D(0, 0, -2));
			assertEquals("The count of untegrations is not correct", 9, findInteractionPoints(camera, sphere).size());

			// TC05: Sphere and camera ray with 0 interaction point
			camera = new Camera(new Point3D(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			sphere = new Sphere(0.5, new Point3D(0, 0, 1));
			assertEquals("The count of untegrations is not correct", null, findInteractionPoints(camera, sphere));

			// ============ Plane & Camera Integration Tests ==============

			// TC01: Plane and camera ray with 9 interaction point

			camera = new Camera(new Point3D(0, 0, 0), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			Plane plane = new Plane(new Point3D(0, 0, -7), new Vector(0, 0, 1));
			assertEquals("The count of untegrations is not correct", 9, findInteractionPoints(camera, plane).size());

			// TC02: Plane and camera ray with 9 interaction point

			camera = new Camera(new Point3D(0, 0, 0), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			plane = new Plane(new Point3D(0, 0, -2), new Vector(0, -1, 3));
			assertEquals("The count of untegrations is not correct", 9, findInteractionPoints(camera, plane).size());

			// TC03: Plane and camera ray with 6 interaction point

			camera = new Camera(new Point3D(0, 0, 0), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			plane = new Plane(new Point3D(0, 0, -2), new Vector(0, -3, 1));
			assertEquals("The count of untegrations is not correct", 6, findInteractionPoints(camera, plane).size());

			// ============ Triangle & Camera Integration Tests ==============

			// TC01: Triangle and camera ray with 1 interaction point

			camera = new Camera(new Point3D(0, 0, 0), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			Triangle triangle = new Triangle(new Point3D(1, -1, -2), new Point3D(-1, -1, -2), new Point3D(0, 1, -2));
			assertEquals("The count of untegrations is not correct", 1, findInteractionPoints(camera, triangle).size());

			// TC02: Triangle and camera ray with 2 interaction point

			camera = new Camera(new Point3D(0, 0, 0), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
					.setViewPlaneSize(3, 3);
			triangle = new Triangle(new Point3D(1, -1, -2), new Point3D(-1, -1, -2), new Point3D(0, 20, -2));
			assertEquals("The count of untegrations is not correct", 2, findInteractionPoints(camera, triangle).size());

		}

		/***
		 * A function that returns a list of rays of interaction between rays from the
		 * camera and geometries
		
		 */

		public List<Point3D> findInteractionPoints(Camera camera, Intersectable geometry) {
			List<Ray> rayList = creat9RaysForViewPlane(camera);
			List<Point3D> interactionPoints = new ArrayList<Point3D>();
			for (Ray ray : rayList) {
				List<Point3D> temp;
				try {
					temp = geometry.findIntersections(ray);
					if (temp != null) {
						interactionPoints.addAll(temp);
					}
				} catch (Exception e) {
					// TODO: handle exception
					fail("dont need exeption here");
				}
			}
			if (interactionPoints.size() == 0) {
				return null;
			}
			return interactionPoints;
		}

		/***
		 * A function that produces 9 rays for view plane in size 3 * 3
	
		 */
		public List<Ray> creat9RaysForViewPlane(Camera camera) {
			List<Ray> raysFromCamera = new ArrayList<Ray>();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					try {
						raysFromCamera.add(camera.constructRayThroughPixel(3, 3, j, i));

					} catch (Exception e) {
						fail();
					}
				}
			}
			return raysFromCamera;
		}

	}


