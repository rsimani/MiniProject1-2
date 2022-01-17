package unittests;
import renderer.*;
import scene.*;
import static java.lang.Math.random;

import java.util.LinkedList;

import org.junit.Test;
import elements.*;
import geometries.*;
import primitives.*;


public class ex_7_image_rivka {



    private Scene.SceneBuilder sceneBuilder = new Scene.SceneBuilder("Test scene");
	private Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
			.setViewPlaneSize(200, 200).setDistance(600);

    private Render render = new Render();
    /**
     * create random double in the range [x1, x2]
     *
     * @param x1 range's start
     * @param x2 range's end
     *
     * @return random double in the range [x1, x2]
     */
    public double randomDouble(double x1, double x2) {
        return x1*(1.0 - random()/Math.nextDown(1.0)) + x2* random()/Math.nextDown(1.0);
    }



    @Test
    public void ex_7_image() {
        Camera.CameraBuilder cameraBuilder =
                new Camera.CameraBuilder(
                        new Point3D(0, 500, 20),
                        new Vector(0, -1, 0),
                        new Vector(0, 0, 1))
                        .setViewPlaneSize(200, 200)
                        .setDistance(600);
        Camera camera = cameraBuilder.build();

   
        Geometries geometries = new Geometries();
  geometries.add(

		     new Cylinder(
                     new Color(java.awt.Color.YELLOW),
                    
                     new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                     2.5,
                     new Point3D(40, 85, -185),
                     new Point3D(40, 85, -250)),
		     new Cylinder(
                     new Color(java.awt.Color.PINK),
                    
                     new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                     2.5,
                     new Point3D(40, 85, -185),
                     new Point3D(10, 455, -250)),
		 	
             new Triangle(new Point3D(-200, 300, 300), new Point3D(100, 200, 200), new Point3D(60, -60, 150)),
                                
 			new Sphere(new Point3D(0, -40, 20), 30) //
			.setEmission(new Color(java.awt.Color.MAGENTA)) //
			.setMaterial(new Material().setkD(0.5).setkS(0.5).setkR(0.2).setnShininess(30)), //
/*
		    new Polygon(
                    new Point3D(0,-40,10),
                    new Point3D(-20,-40,25),
                    new Point3D(20,-40,25)). 
                 setEmission(new Color(java.awt.Color.PINK))
                 .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                    new Polygon(
                       
                            new Point3D(-20,-40,25),
                        
                            new Point3D(-12,-40,35),
                            
                            new Point3D(0, -40,25)).
                            setEmission(new Color(java.awt.Color.PINK))
                            .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)), 
                            new Polygon(
                                 
                        
                                    new Point3D(20,-40,25),
                        
                                    new Point3D(12,-40,35),
                                    new Point3D(0, -40,25)).
                                    setEmission(new Color(java.awt.Color.PINK))
                                    .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
*/
                /////////           FLOOR - MIRROR                 ///////////
  
                new Polygon(
                	     new Point3D(50,-40,0),
                                new Point3D(-50,-40,0),
                               new Point3D(-50,100,0),
                               new Point3D(50,100,0)).
                      setEmission(new Color(0, 190, 190))
                       //.setMaterial(new Material().dsetkS(0.8).setkR(0.5)));
  .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30).setkR(1)));
              
        // create 10 spheres random with transparency
        		      
        for(int i = 0; i < 10; i++) {
            double randomRadius = randomDouble(4, 5);
            geometries.add(
                    new Sphere(new Point3D(randomDouble(-50, 50), randomDouble(-39, 99), randomRadius -2), randomRadius)
                    .setEmission(new Color(randomDouble(0, 255), randomDouble(0, 255), randomDouble(0, 255)))
                    .setMaterial(new Material().setkD(random()).setkS(random()).setkT(random()).setnShininess((int)randomDouble(0,100))));
        }

        // create 10 spheres random with reflection
        
        for(int i = 0; i < 10; i++) {
            double randomRadius = randomDouble(4, 5);
            geometries.add(
                    new Sphere(new Point3D(randomDouble(-50, 50), randomDouble(-39, 99), randomRadius -2), randomRadius)
                            .setEmission(new Color(randomDouble(0, 255), randomDouble(0, 255), randomDouble(0, 255)))
                            .setMaterial(new Material().setkD(random()).setkS(random()).setkR(random()).setnShininess((int)randomDouble(0,100))));
        }
        LinkedList<LightSource> lightSources = new LinkedList<>();

        
        lightSources.add(
                 new SpotLight(
                 		new Color(new Color(400, 240, 0)),
                 	       new Point3D(0, 60, 50), new Vector(0,0, 1)) //
                 			.setkL(1E-5).setkQ(1.5E-7));
        /*   lightSources.add(
        new SpotLight(
         		new Color(new Color(400, 240, 0)),
         	       new Point3D(0, 60, 50), new Vector(1,0, 1)) //
         			.setkL(1E-5).setkQ(1.5E-7));
        lightSources.add(
                new SpotLight(
                 		new Color(new Color(400, 240, 0)),
                 	       new Point3D(0, 60, 50), new Vector(0,1
                 	    		   , 1)) //
                 			.setkL(1E-5).setkQ(1.5E-7));
        	
*/
        sceneBuilder.setGeometries(geometries)
        .setLights(lightSources)
                .setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.02));
        Scene scene = sceneBuilder.build();

        ImageWriter imageWriter = new ImageWriter("ex_7_image_rivka", 400, 400);
        render.setImageWriter(imageWriter).setSuperS(true).setMultithreading(3).setDebugPrint().setAdaptiveSS(false)//
                .setCamera(camera).setRayTracer(new RayTracerBasic(scene));

        render.renderImage();
        render.writeToImage();
    }
}


