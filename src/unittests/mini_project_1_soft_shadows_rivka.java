package unittests;

import static java.lang.Math.random;

import java.util.LinkedList;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import elements.SpotLight;
import geometries.Geometries;
import geometries.Polygon;
import geometries.Sphere;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import renderer.Render;
import scene.Scene;

public class mini_project_1_soft_shadows_rivka 
{
	private Scene.SceneBuilder sceneBuilder = new Scene.SceneBuilder("Test scene");
	private Render render = new Render();
	   public double randomDouble(double x1, double x2) {
	        return x1*(1.0 - random()/Math.nextDown(1.0)) + x2* random()/Math.nextDown(1.0);
	    }
@Test
public void ex_mp1() {
    Camera.CameraBuilder cameraBuilder =
            new Camera.CameraBuilder(
                    new Point3D(30,1000, 50),
                    new Vector(0, -1, 0),
                    new Vector(0, 0, 1))
                    .setViewPlaneSize(200, 200)
                    .setDistance(700);
    Camera camera = cameraBuilder.build();

    Geometries geometries = new Geometries();
    geometries.add(



            //      FLOOR
           new Polygon(
                   new Point3D(100,-40,-14),
                   new Point3D(-100,-40,-14),
                   new Point3D(-100,100,-14),
                   new Point3D(100,100,-14))
                   .setEmission(new Color(java.awt.Color.gray))
                 //   .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30).setkR(1)),
                    .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),

                    /////////           WALLS                 ///////////


                    new Polygon(
                            new Point3D(100,-40,-14),
                            new Point3D(-100,-40,-14),
                            new Point3D(-100,-40,100),
                            new Point3D(100, -40, 100)).
                            setEmission(new Color(35,12,31))
                         //  .setMaterial(new Material()),
                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                            
                            new Polygon(
                                    new Point3D(100,-40,-14),
                                    new Point3D(100,100,-14),
                                    new Point3D(100,100,100),
                                    new Point3D(100, -40, 100)).
                                    setEmission(new Color(17,3,15))
                                //    .setMaterial(new Material()),
                                    .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                    
                                    new Polygon(
                                            new Point3D(-100,-40,-14),
                                            new Point3D(-100,100,-14),
                                            new Point3D(-100,100,100),
                                            new Point3D(-100, -40, 100)).
                                            setEmission(new Color(18,3,15))
                                           // .setMaterial(new Material()),
                                            .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),


      
   
                    new Sphere(
                            new Point3D(25,20,20),
                            3)
                            .setEmission(new Color(java.awt.Color.YELLOW))
                            .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                            new Sphere(
                                    new Point3D(25,20,16),
                                    3)
                                    .setEmission(new Color(23,13,2))
                                    .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                            
                  new Sphere(
                          new Point3D(25,20,12),
                          3)
                          .setEmission(new Color(23,13,2))
                          .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                          new Sphere(
                                  new Point3D(25,20,8),
                                  3)
                                  .setEmission(new Color(23,13,2))
                                  .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                  new Sphere(
                                          new Point3D(25,20,4),
                                          3)
                                          .setEmission(new Color(23,13,2))
                                          .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                          new Sphere(
                                                  new Point3D(25,20,0),
                                                  3)
                                                  .setEmission(new Color(23,13,2))
                                                  .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                                  new Sphere(
                                                          new Point3D(25,20,-4),
                                                          3)
                                                          .setEmission(new Color(23,13,2))
                                                          .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),   new Sphere(
                                                                  new Point3D(25,20,-8),
                                                                  3)
                                                                  .setEmission(new Color(23,13,2))
                                                                  .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)), 
                                                                  new Sphere(
                                                                          new Point3D(25,20,-12),
                                                                          6)
                                                                          .setEmission(new Color(23,13,2))
                                                                          .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                                                          new Sphere(
                                                                                  new Point3D(-25,20,20),
                                                                                  3)
                                                                                  .setEmission(new Color(java.awt.Color.YELLOW))
                                                                                  .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                                                                  new Sphere(
                                                                                          new Point3D(-25,20,16),
                                                                                          3)
                                                                                          .setEmission(new Color(23,13,2))
                                                                                          .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                                                        new Sphere(
                                                                                new Point3D(-25,20,12),
                                                                                3)
                                                                                .setEmission(new Color(23,13,2))
                                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                                                                new Sphere(
                                                                                        new Point3D(-25,20,8),
                                                                                        3)
                                                                                        .setEmission(new Color(23,13,2))
                                                                                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                                                                        new Sphere(
                                                                                                new Point3D(-25,20,4),
                                                                                                3)
                                                                                                .setEmission(new Color(23,13,2))
                                                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                                                                                new Sphere(
                                                                                                        new Point3D(-25,20,0),
                                                                                                        3)
                                                                                                        .setEmission(new Color(23,13,2))
                                                                                                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                                                                                                        new Sphere(
                                                                                                                new Point3D(-25,20,-4),
                                                                                                                3)
                                                                                                                .setEmission(new Color(23,13,2))
                                                                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),   new Sphere(
                                                                                                                        new Point3D(-25,20,-8),
                                                                                                                        3)
                                                                                                                        .setEmission(new Color(23,13,2))
                                                                                                                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)), 
                                                                                                                        new Sphere(
                                                                                                                                new Point3D(-25,20,-12),
                                                                                                                                6)
                                                                                                                                .setEmission(new Color(23,13,2))
                                                                                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30))
                  );
    LinkedList<LightSource> lightSources = new LinkedList<>();




    lightSources.add(
            new SpotLight(
                    new Color(java.awt.Color.white),
                    new Point3D(30, 20, 20),
                    new Vector(-1, -1, -1))
                   .setkL(1E-5).setkQ(1.5E-7));

    lightSources.add(
            new SpotLight(
                    new Color(java.awt.Color.white),
                    new Point3D(-35, 20, 20),
                    new Vector(-1, -1, -1))
                  .setkL(1E-5).setkQ(1.5E-7));

    sceneBuilder.setGeometries(geometries)
            .setLights(lightSources)
            .setAmbientLight(new AmbientLight(new Color(java.awt.Color.white), 0.002));
    Scene scene = sceneBuilder.build();

    ImageWriter imageWriter = new ImageWriter("mp1_rivka_after", 600, 600);
    render.setImageWriter(imageWriter).setCamera(camera).setRayTracer(new RayTracerBasic(scene)).setMinimalScale(1.0/256);

    render.renderImage();
    render.writeToImage();
}

}

