package unittests;
import renderer.*;
import scene.*;
import static java.lang.Math.random;
import java.util.LinkedList;
import java.util.List;
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

        //int legRadius = 3;
      /*  List<Geometry> firstLeg = new Rectangle
                (new Point3D(20,40,0),
                        new Point3D(19,40,0),
                        new Point3D(19,39,0),
                        new Point3D(20,39,0)).getCube(-14);
        List<Geometry> secondLeg = new Rectangle
                (new Point3D(20,10,0),
                        new Point3D(19,10,0),
                        new Point3D(19,9,0),
                        new Point3D(20,9,0)).getCube(-14);
        List<Geometry> thirdLeg = new Rectangle
                (new Point3D(-20,10,0),
                        new Point3D(-20,9,0),
                        new Point3D(-19,9,0),
                        new Point3D(-19,10,0)).getCube(-14);
        List<Geometry> fourthLeg = new Rectangle
                (new Point3D(-20,40,0),
                        new Point3D(-20,39,0),
                        new Point3D(-19,39,0),
                        new Point3D(-19,40,0)).getCube(-14);

        List<Geometry> cover1 = new Rectangle
                (new Point3D(8.5,20,0),
                        new Point3D(4,20,0),
                        new Point3D(4,15,0),
                        new Point3D(8.5,15,0)).getCube(0.28);
*/
        List<Geometry> pages = new LinkedList<>();
        for(int i = 0; i < 10; i++){
                    pages.addAll( new Rectangle
                        (new Point3D(8,20, 0.3+i*0.1),
                        new Point3D(4,20,0.3 + i*0.1),
                        new Point3D(4,15,0.3 + i*0.1),
                        new Point3D(8,15,0.3 + i*0.1)).moveByJ(2).getCube(0.08));
        }
/*
        List<Geometry> cover2 = new Rectangle
                (new Point3D(8.5,20,1.4),
                        new Point3D(4,20,1.4),
                        new Point3D(4,15,1.4),
                        new Point3D(8.5,15,1.4)).moveByJ(2).getCube(0.18);

        List<Geometry> cover3 = new Rectangle
                (new Point3D(4,20,0),
                        new Point3D(3.5,20,0),
                        new Point3D(3.5,15,0),
                        new Point3D(4,15,0)).getCube(1.3);
*/
  
    /*    List<Geometry> lamp = new Rectangle
        		(new Point3D(70,-40, -14),
                        new Point3D(70,-41,-14),
                        new Point3D(69,-40,-14),
                        new Point3D(69,-41,-14)).getCube(50);

        List<Geometry> lamp2 = new Rectangle
                (new Point3D(-70,-40,-14),
                        new Point3D(-70,-41,-14),
                        new Point3D(-69,-40,-14),
                        new Point3D(-69,-41,-14)).getCube(50);
        List<Geometry> lamp3 = new Rectangle
                (new Point3D(-70,100,-14),
                        new Point3D(-70,101,-14),
                        new Point3D(-69,101,-14),
                        new Point3D(-69,100,-14)).getCube(50);
        List<Geometry> lamp4 = new Rectangle
                (new Point3D(70, 100,-14),
                        new Point3D(70, 101,-14),
                        new Point3D(69, 101,-14),
                        new Point3D(69, 100,-14)).getCube(50);
/*
        List<Geometry> board = new Rectangle
                (new Point3D(20,40,0),
                        new Point3D(20,9,0),
                        new Point3D(-20,9,0),
                        new Point3D(-20,40,0)).getCube(1);

        Color brown = new Color(23,13,2);
    */
        Geometries geometries = new Geometries();
  //  geometries.add(

        		//****************************window*****************************//

/*
        		                new Cylinder(
        		                        new Color(120, 120, 120),
        		                       new Material().setkD(0.5).setkS(0.33).setnShininess(35).setkT(0),
        		                 //       new Material(0.5, 0.33, 35, 0, 0),
        		                        2,
        		                        new Point3D(-250, 60, -50),
        		                        new Point3D(-250, 170, -50)),

        		                new Cylinder(
        		                        new Color(120, 120, 120),
        		                        new Material().setkD(0.5).setkS(0.33).setnShininess(35).setkT(0),
        		                      //  new Material(0.5, 0.33, 35, 0, 0),
        		                        2,
        		                        new Point3D(-250, 60, -180),
        		                        new Point3D(-250, 170, -180)),

        		                new Cylinder(
        		                        new Color(120, 120, 120),
        		                        new Material().setkD(0.5).setkS(0.33).setnShininess(35).setkT(0),
        		                      //  new Material(0.5, 0.33, 35, 0, 0),
        		                        2,
        		                        new Point3D(-250, 60, -50),
        		                        new Point3D(-250, 60, -180)),

        		                new Cylinder(
        		                        new Color(120, 120, 120),
        		                        new Material().setkD(0.5).setkS(0.33).setnShininess(35).setkT(0),
        		                       // new Material(0.5, 0.33, 35, 0, 0),
        		                        2,
        		                        new Point3D(-250, 170, -50),
        		                        new Point3D(-250, 170, -180)
        		        ));

        		//************************window shutter*****************************/

        		/*        for (int i = 0; i < 13; i++) 
        		        {
        		        
        		                    new Triangle(
        		                            new Color(100, 100, 100),
        		                            new Material().setkD(0.2).setkS(0.15).setnShininess(80).setkT(0),
        		                          //  new Material(0.2, 0.15, 80, 0, 0),
        		                            new Point3D(-250, 162 - 8 * i, -50),
        		                            new Point3D(-250, 162 - 8 * i, -180),
        		                            new Point3D(-250, 166 - 8 * i, -180));
        		        }
        		        for (int i = 0; i < 13; i++) 
        		        {

        		                    new Triangle(
        		                            new Color(100, 100, 100),
        		                            new Material().setkD(0.2).setkS(0.15).setnShininess(80).setkT(0),
        		                          //  new Material(0.2, 0.15, 80, 0, 0),
        		                            new Point3D(-250, 166 - 8 * i, -180),
        		                            new Point3D(-250, 166 - 8 * i, -50),
        		                            new Point3D(-250, 162 - 8 * i, -50)
        		            );
        		        }
                //################        TABLE            #####################

               //  .setMaterial(new Material().setKd(0.5).setKs(0.5).setNShininess(100)));
/*
              firstLeg.get(0)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                firstLeg.get(1)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                firstLeg.get(2)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),

                firstLeg.get(3)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                firstLeg.get(4)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                firstLeg.get(5)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),

                secondLeg.get(0)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                secondLeg.get(1)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                secondLeg.get(2)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                secondLeg.get(3)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                secondLeg.get(4)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                secondLeg.get(5)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),

                thirdLeg.get(0)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                thirdLeg.get(1)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                thirdLeg.get(2)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                thirdLeg.get(3)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                thirdLeg.get(4)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                thirdLeg.get(5)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),

                fourthLeg.get(0)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                fourthLeg.get(1)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                fourthLeg.get(2)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                fourthLeg.get(3)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                fourthLeg.get(4)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),
                fourthLeg.get(5)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnShininess(100).setkT(0.3)),

                board.get(0)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                board.get(1)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                board.get(2)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                board.get(3)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                board.get(4)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),
                board.get(5)
                        .setEmissionColor(brown)
                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(30)),

                cover1.get(0)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover1.get(1)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover1.get(2)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover1.get(3)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover1.get(4)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover1.get(5)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),

                cover2.get(0)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover2.get(1)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover2.get(2)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover2.get(3)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover2.get(4)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover2.get(5)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),

                cover3.get(0)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover3.get(1)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover3.get(2)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover3.get(3)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover3.get(4)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                cover3.get(5)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
*/
       /*         lamp.get(0)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp.get(1)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp.get(2)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp.get(3)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp.get(4)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp.get(5)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),

                lamp2.get(0)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp2.get(1)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp2.get(2)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp2.get(3)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp2.get(4)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp2.get(5)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                        lamp2.get(0)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp3.get(1)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp3.get(2)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp3.get(3)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp3.get(4)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp3.get(5)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                        lamp2.get(0)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp4.get(1)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp4.get(2)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp4.get(3)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp4.get(4)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),
                lamp4.get(5)
                        .setEmissionColor(new Color(220,150,0))
                        .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)),*/
        		
               ////         new Cylinder(new Color(java.awt.Color.WHITE),new Material().setkT(0.6).setkD(0.1).setkS(0.1).setnShininess(100),4,(new Point3D(39.5,60,27)),new Point3D(39.5,60,13)),
         //       new Sphere(new Point3D(39.5,60,20),7)
                    //    .setEmissionColor(new Color(0,190,190))
                     //   .setMaterial(new Material().setkT(0.6).setkD(0.1).setkS(0.1).setnShininess(100)),
                     //   new Cylinder(new Color(java.awt.Color.WHITE),new Material().setkT(0.6).setkD(0.1).setkS(0.1).setnShininess(100),4,(new Point3D(-39.5,60,27)),new Point3D(-39.5,60,13)),
               // new Sphere(new Point3D(-39.5,60,20),7)
                      //  .setEmissionColor(new Color(0,190,190))
                       // .setMaterial(new Material().setkT(0.6).setkD(0.1).setkS(0.1).setnShininess(100)),
        		        geometries.add(
                new Sphere(new Point3D(0,-40,50),3)
                        .setEmission(new Color(255,0,0))
                        .setMaterial(new Material().setkT(0.6).setkD(0.1).setkS(0.1).setnShininess(100)),

             //   new Sphere(new Point3D(-39.5,60,20),3)
                      //  .setEmissionColor(new Color(255,0,0))
                  //      .setMaterial(new Material().setkT(0.6).setkD(0.1).setkS(0.1).setnShininess(100)),


                /////////           FLOOR                 ///////////
             //   new Polygon(
              //        new Point3D(70,-40,-14),
                //       new Point3D(-70,-40,-14),
                  //    new Point3D(-70,100,-14),
                   //   new Point3D(70,100,-14))
                   //  .setEmissionColor((new Color(brown)))
                   //  .setMaterial(new Material().setkD(1).setnShininess(50))
            //    ,
                      //*******************************shelf*******************************//

                      
                      
                        
                       /*  
                         
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

                                new Sphere(
                                        new Color(40, 40, 40),
                                       // new Material(0.3, 0.20, 85, 0.40, 0),
                                        new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                        4,
                                        new Point3D(-40, 85, -185)),

                //*************************objects on the shelf**********************/

                 /*               new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        25,
                                        new Point3D(-220, 87.5, -220),
                                        new Point3D(-220, 140, -220)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        18,
                                        new Point3D(-160, 87.5, -210),
                                        new Point3D(-160, 130, -210)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        13,
                                        new Point3D(-110, 87.5, -203),
                                        new Point3D(-110, 120, -203)),

                                new Cylinder(
                                        new Color(40, 40, 40),
                                     //   new Material(0.4, 0.2, 35, 0, 0),
                                        new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                        10,
                                        new Point3D(-80, 87.5, -200),
                                        new Point3D(-80, 108, -200)),
                        
                        


                      //*********************************STAR******************************/
/*

                                  new Sphere(
                                              new Color(40, 40, 40),
                                          new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                            //  new Material(0.3, 0.20, 85, 0.40, 0),
                                              8,
                                              new Point3D(125, 8, -50)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                              1.5,
                                              new Point3D(125, 8, -50),
                                              new Point3D(150, 6, -40)),

                                      new Sphere(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                              6,
                                              new Point3D(150, 6, -40)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                              1.5,
                                              new Point3D(150, 6, -40),
                                              new Point3D(110, 7, -25)),

                                      new Sphere(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                              7,
                                              new Point3D(110, 7, -25)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                              1.5,
                                              new Point3D(110, 7, -25),
                                              new Point3D(190, 10, -25)),

                                      new Sphere(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                              10,
                                              new Point3D(190, 10, -25)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                              1.5,
                                              new Point3D(190, 10, -25),
                                              new Point3D(150, 46, -40)),

                                      new Sphere(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                              9,
                                              new Point3D(150, 46, -40)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                              1.5,
                                              new Point3D(150, 46, -40),
                                              new Point3D(125, 9, -5)),

                                      new Sphere(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                              9,
                                              new Point3D(125, 9, -5)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                              1.5,
                                              new Point3D(150, 46, -40),
                                              new Point3D(172, 8, -84)),

                                      new Sphere(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                              8,
                                              new Point3D(172, 8, -84)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                              1.5,
                                              new Point3D(172, 8, -84),
                                              new Point3D(125, 8, -50)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.3).setkS(0.2).setnShininess(85).setkR(0.4),
                                              1.5,
                                              new Point3D(150, 46, -40),
                                              new Point3D(125, 8, -50)),

                                      new Cylinder(
                                              new Color(40, 40, 40),
                                              new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                             // new Material(0.4, 0.2, 35, 0, 0),
                                              1.5,
                                              new Point3D(172, 8, -84),
                                              new Point3D(150, 6, -40)),
*/

                /////////           FLOOR - MIRROR                 ///////////
                new Polygon(
                	     new Point3D(50,-40,0),
                                new Point3D(-50,-40,0),
                               new Point3D(-50,100,0),
                               new Point3D(50,100,0)).
                      setEmission(new Color(0, 190, 190))
                       .setMaterial(new Material().setkS(0.8).setkR(0.5)),
                       new Polygon(
                      	     new Point3D(50,100,-14),
                                      new Point3D(-50,100,-14),
                                     new Point3D(-50,100,0),
                                     new Point3D(50,100,0)).
                            setEmission(new Color(java.awt.Color.BLUE))
                             .setMaterial(new Material().setkS(0.8).setkR(0.5).setkD(1))
        ,
    /*    new Polygon(
       	     new Point3D(-50,100,15),
                       new Point3D(50,100,15),
                      new Point3D(-50,100,-14),
                      new Point3D(50,100,-14)).
             setEmissionColor(new Color(java.awt.Color.BLUE))
              .setMaterial(new Material().setkS(0.8).setnShininess(180).setkR(0.1))
,
*/

                /////////           CEILING                 //////
                new Polygon(
                        new Point3D(70,-40,50),
                        new Point3D(-70,-40,50),
                        new Point3D(-70,100,50),
                        new Point3D(70,100,50))
             //  . setEmissionColor(new Color(20, 20, 20))
             //   .setMaterial(new Material().setkR(0.8).setkS(0.5))
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
                                new Point3D(-40,-39,30),
                                new Point3D(40, -39, 30)).
                                setEmission(new Color(20, 20, 20))
                                .setMaterial(new Material().setkR(0.8).setkS(0.5)));
        		     /*   new Cylinder(
                                new Color(40, 40, 40),
                                new Material().setkD(0.4).setkS(0.2).setnShininess(35).setkR(0),
                                1.5,
                                new Point3D(110, 7, -25),
                                new Point3D(190, 10, -25));

        		        
        		        /*     new Polygon(
                		 new Point3D(-41,-39,-14),
                         new Point3D(-45,-39,-14),
                         new Point3D(-41,-39,33),
                         new Point3D(-45, -39, 33)).setEmissionColor(new Color(java.awt.Color.PINK));
        /*    new Polygon(
           		 new Point3D(-41,-39,31),
                    new Point3D(-41,-39,35),
                    new Point3D(41,-39,31),
                    new Point3D(41, -39, 35)).setEmissionColor(new Color(java.awt.Color.PINK));
            new Polygon(
           		 new Point3D(41,-39,-14),
                    new Point3D(45,-39,-14),
                    new Point3D(41,-39,35),
                    new Point3D(45, -39, 35)).setEmissionColor(new Color(java.awt.Color.PINK));
                      //  new Point3D(35,-39,-14),
                      //  new Point3D(-35,-39,-14),
                        //new Point3D(-35,-39,40),
                     //   new Point3D(35, -39, 40)).setEmissionColor(new Color(15,15,15))
                       // .setMaterial(new Material().setkS(0.5).setkR(0.8).setnShininess(180)));
        		       
        		   

    /*    for(int i = 0; i < 60; i++) {
            geometries.add(  pages.get(i)
                            .setEmissionColor(new Color(255, 255, 255))
                            .setMaterial(new Material().setkD(1).setkS(0).setnShininess(50)));
        }*/

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
                	
                   //     new Color(100,50, 0),
                        new Point3D(0, 60, 50)));

     lightSources.add(
                new DirectionalLight(
                      //  new Color(50,25, 0),
                        new Color(java.awt.Color.RED),
                        new Vector(-40, -60, 20)));

        lightSources.add(
                new DirectionalLight(
                    //    new Color(100,50, 33),
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
