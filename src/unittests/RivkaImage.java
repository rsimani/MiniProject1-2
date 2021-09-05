package unittests;
import renderer.*;
import scene.*;
import static java.lang.Math.random;
import java.util.LinkedList;
import org.junit.Test;
import elements.*;
import geometries.*;
import primitives.*;


public class RivkaImage {



    private Scene.SceneBuilder sceneBuilder = new Scene.SceneBuilder("Test scene");
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
    public void rivka_picture() {
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

  
                /////////           FLOOR                 ///////////
             //   new Polygon(
              //        new Point3D(70,-40,-14),
                //       new Point3D(-70,-40,-14),
                  //    new Point3D(-70,100,-14),
                   //   new Point3D(70,100,-14))
                   //  .setEmissionColor((new Color(brown)))
                   //  .setMaterial(new Material().setkD(1).setnShininess(50))
            //    ,
                      //*******************************page_right*******************************/

                      
                      
                        
                       
                         
                         new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -185),
                                        new Point3D(-40, 85, -185)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -191),
                                        new Point3D(-40, 85, -191)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -197),
                                        new Point3D(-40, 85, -197)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -203),
                                        new Point3D(-40, 85, -203)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -209),
                                        new Point3D(-40, 85, -209)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -215),
                                        new Point3D(-40, 85, -215)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -221),
                                        new Point3D(-40, 85, -221)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -227),
                                        new Point3D(-40, 85, -227)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -233),
                                        new Point3D(-40, 85, -233)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),

                                        2.5,
                                        new Point3D(-250, 85, -239),
                                        new Point3D(-40, 85, -239)),
                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-250, 85, -245),
                                        new Point3D(-40, 85, -245)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-40, 85, -185),
                                        new Point3D(-40, 250, -185)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                       
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        2.5,
                                        new Point3D(-40, 85, -185),
                                        new Point3D(-40, 85, -250)),

                            
                                //*******************************page_left*******************************/

                                new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -185),
                                               new Point3D(40, 85, -185)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -191),
                                               new Point3D(40, 85, -191)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -197),
                                               new Point3D(40, 85, -197)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -203),
                                               new Point3D(40, 85, -203)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -209),
                                               new Point3D(40, 85, -209)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -215),
                                               new Point3D(40, 85, -215)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -221),
                                               new Point3D(40, 85, -221)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -227),
                                               new Point3D(40, 85, -227)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -233),
                                               new Point3D(40, 85, -233)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),

                                               2.5,
                                               new Point3D(250, 85, -239),
                                               new Point3D(40, 85, -239)),
                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(250, 85, -245),
                                               new Point3D(40, 85, -245)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(40, 85, -185),
                                               new Point3D(40, 250, -185)),

                                       new Cylinder(
                                               new Color(40, 40, 40),
                                              
                                               new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                               2.5,
                                               new Point3D(40, 85, -185),
                                               new Point3D(40, 85, -250)),

                                       
           

                /////////           FLOOR - MIRROR                 ///////////
  
                new Polygon(
                	     new Point3D(50,-40,0),
                                new Point3D(-50,-40,0),
                               new Point3D(-50,100,0),
                               new Point3D(50,100,0)).
                      setEmission(new Color(0, 190, 190))
                       .setMaterial(new Material().setkS(0.8).setkR(0.5)),
                       /////////        POOL           ///////////
                       new Polygon(
                      	     new Point3D(50,100,-14),
                                      new Point3D(-50,100,-14),
                                     new Point3D(-50,100,0),
                                     new Point3D(50,100,0)).
                            setEmission(new Color(java.awt.Color.BLACK
                            		))
                             .setMaterial(new Material().setkS(0.8).setkR(0.5).setkD(1)),
   
                /////////           CEILING                 /////////
                new Polygon(
                        new Point3D(70,-40,50),
                        new Point3D(-70,-40,50),
                        new Point3D(-70,100,50),
                        new Point3D(70,100,50))
                  .setEmission(new Color(3,0,0))
                     .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50))
                
                ,

                /////////           WALLS                 ///////////
                new Polygon(
                        new Point3D(70,-40,-14),
                        new Point3D(70,100,-14),
                        new Point3D(70,100,50),
                        new Point3D(70,-40,50))
                        .setEmission(new Color(3,0,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50))
                ,
                new Polygon(
                        new Point3D(-70,-40,-14),
                        new Point3D(-70,100,-14),
                        new Point3D(-70,100,50),
                        new Point3D(-70,-40,50))
                        .setEmission(new Color(3,0,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50))
                ,
                new Polygon(
                        new Point3D(70,-40,-14),
                        new Point3D(-70,-40,-14),
                        new Point3D(-70,-40,50),
                        new Point3D(70, -40, 50)).
                        setEmission(new Color(3,0,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),

                /////////           MIRROR                 ///////////
                        
                        new Polygon(
                                new Point3D(40,-39,-14),
                                new Point3D(-40,-39,-14),
                                new Point3D(-40,-39,50),
                                new Point3D(40, -39, 50)).
                                setEmission(new Color(20, 20, 20))
                                .setMaterial(new Material().setkR(0.8).setkS(0.5)));
        		  

        // create 10 spheres random with transparency
        		      
        for(int i = 0; i < 20; i++) {
            double randomRadius = randomDouble(1, 2);
            geometries.add(
                    new Sphere(new Point3D(randomDouble(-50, 50), randomDouble(-39, 99), randomRadius -14), randomRadius)
                    .setEmission(new Color(randomDouble(0, 255), randomDouble(0, 255), randomDouble(0, 255)))
                    .setMaterial(new Material().setkD(random()).setkS(random()).setkT(random()).setnShininess((int)randomDouble(0,100))));
        }

        // create 10 spheres random with reflection
        
        for(int i = 0; i < 20; i++) {
            double randomRadius = randomDouble(2, 3);
            geometries.add(
                    new Sphere(new Point3D(randomDouble(-50, 50), randomDouble(-39, 99), randomRadius -2), randomRadius)
                            .setEmission(new Color(randomDouble(0, 255), randomDouble(0, 255), randomDouble(0, 255)))
                            .setMaterial(new Material().setkD(random()).setkS(random()).setkR(random()).setnShininess((int)randomDouble(0,100))));
        }

        LinkedList<LightSource> lightSources = new LinkedList<>();

    
       lightSources.add(
                new PointLight(
                		new Color(java.awt.Color.WHITE),
                	       new Point3D(0, 60, 50)));

     lightSources.add(
                new DirectionalLight(
                 
                        new Color(java.awt.Color.RED),
                        new Vector(-40, -60, 20)));

        lightSources.add(
                new DirectionalLight(
                 
                		 new Color(java.awt.Color.GREEN),
                        new Vector(0.8, -1, 0.5)));

        sceneBuilder.setGeometries(geometries)
                .setLights(lightSources)
                .setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.02));
        Scene scene = sceneBuilder.build();

        ImageWriter imageWriter = new ImageWriter("rivka_picture", 600, 600);
        render.setImageWriter(imageWriter).setSuperS(true).setMultithreading(3).setDebugPrint().setAdaptiveSS(false)//
                .setCamera(camera).setRayTracer(new RayTracerBasic(scene));

        render.renderImage();
        render.writeToImage();
    }
}
