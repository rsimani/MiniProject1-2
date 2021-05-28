package unittests;

import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

/**
 * Testing basic shadows
 * 
 * @author Dan
 */
public class ShadowTests {
	private Scene scene = new Scene("Test scene");
	private Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
			.setViewPlaneSize(200, 200).setDistance(1000);

	/**
	 * Produce a picture of a sphere and triangle with point light and shade
	 */
	@Test
	public void sphereTriangleInitial() {
		scene._geometries.add( //
				new Sphere(60, new Point3D(0, 0, -200)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)), //
				new Triangle(new Point3D(-70, -40, 0), new Point3D(-40, -70, 0), new Point3D(-68, -68, -4)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)) //
		);
		scene.lights.add( //
				new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200), new Vector(1, 1, -3)) //
						.setkL(1E-5).setkQ(1.5E-7));

		Render render = new Render(). //
				setImageWriter(new ImageWriter("shadowSphereTriangleInitial", 400, 400)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a two triangles lighted by a spot light with a Sphere
	 * producing a shading
	 */

	@Test
	public void trianglesSphere() 
	
	{
		scene.set_ambientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

		scene._geometries.add( //
				new Triangle(new Point3D(-150, -150, -115), new Point3D(150, -150, -135), new Point3D(75, 75, -150)) //
						.setMaterial(new Material().setkS(0.8).setnShininess(60)), //
				new Triangle(new Point3D(-150, -150, -115), new Point3D(-70, 70, -140), new Point3D(75, 75, -150)) //
						.setMaterial(new Material().setkS(0.8).setnShininess(60)), //
				new Sphere(30, new Point3D(0, 0, -115)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)) //
		);
		scene.lights.add( //
				new SpotLight(new Color(700, 400, 400), new Point3D(40, 40, 115), new Vector(-1, -1, -4)) //
						.setkL(4E-4).setkQ(2E-5));

		Render render = new Render() //
				.setImageWriter(new ImageWriter("shadowTrianglesSphere", 600, 600)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}




	@Test
	public void sphereTriangleInitial02() {
		scene._geometries.add( //
				new Sphere(60, new Point3D(0, 0, -200)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)), //
				new Triangle(new Point3D(-65, -35, 5), new Point3D(-35, -65, 5), new Point3D(-63, -63, 1)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)) //
		);

		scene.lights.add( //
				new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200), new Vector(1, 1, -3)) //
						.setkL(1E-5).setkQ(1.5E-7));

		Render render = new Render(). //
				setImageWriter(new ImageWriter("shadowSphereTriangleInitial02", 400, 400)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();

	}

	@Test
	public void sphereTriangleInitial03() {
		scene._geometries.add( //
				new Sphere(60, new Point3D(0, 0, -200)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)), //
				new Triangle(new Point3D(-60, -30, 10), new Point3D(-30, -60, 10), new Point3D(-58, -58, 6)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)) //
		);
		scene.lights.add( //
				new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200), new Vector(1, 1, -3)) //
						.setkL(1E-5).setkQ(1.5E-7));

		Render render = new Render(). //
				setImageWriter(new ImageWriter("shadowSphereTriangleInitial03", 400, 400)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}
	
	@Test
	public void sphereTriangleInitial04() {
		scene._geometries.add( //
				new Sphere(60, new Point3D(0, 0, -200)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)), //
				new Triangle(new Point3D(-70, -40, 0), new Point3D(-40, -70, 0), new Point3D(-68, -68, -4)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)) //
		);
		scene.lights.add( //
				new SpotLight(new Color(400, 240, 0), new Point3D(-95, -90, 195), new Vector(1, 1, -3)) //
				.setkL(1E-5).setkQ(1.5E-7));

		Render render = new Render(). //
				setImageWriter(new ImageWriter("shadowSphereTriangleInitial04", 400, 400)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();

	}

	@Test
	public void sphereTriangleInitial05() {
		scene._geometries.add( //
				new Sphere(60, new Point3D(0, 0, -200)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)), //
				new Triangle(new Point3D(-70, -40, 0), new Point3D(-40, -70, 0), new Point3D(-68, -68, -4)) //
						.setEmissionColor(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)) //
		);
		scene.lights.add( //
				new SpotLight(new Color(400, 240, 0), new Point3D(-120, -120, 120), new Vector(1, 1, -3)) //
				.setkL(1E-5).setkQ(1.5E-7));

		Render render = new Render(). //
				setImageWriter(new ImageWriter("shadowSphereTriangleInitial05", 400, 400)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();

	}

}
