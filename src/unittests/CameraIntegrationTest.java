package unittests;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import elements.Camera;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;


public class CameraIntegrationTest 
{
	    Camera cam1 = new Camera(Point3D.ZERO, new Vector(0, 0, 1),  new Vector(0, -1, 0)); 
	    Camera cam2 = new Camera(new Point3D(0, 0, -0.5), new Vector(0, 0, 1), new Vector(0, -1, 0));

	 // **** Group: Construct Ray Throw Pixel With Sphere
	    //TC01:the sphere is against the view plane
	    @Test
	    void constructRayThroughPixelWithSphere1() {
	        Sphere sph =  new Sphere(1,new Point3D(0, 0, 3));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < Nx; ++i) {
	            for (int j = 0; j < Ny; ++j) {
	            	results = sph.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("too bad",2,count);
	        System.out.println("count: "+count);

	    }
	  //TC02:the shpere starts befor the view plane
	    @Test
	    void constructRayThroughPixelWithSphere2() {
	        Sphere sph =  new Sphere(2.5,new Point3D(0, 0, 2.5));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < Nx; ++i) {
	            for (int j = 0; j < Ny; ++j) {
	                results = sph.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("too bad",18,count);
	        System.out.println("count: "+count);
	    }
	    
	  //TC03:five rayes cross the sphere
		@Test
		public void constructRayThroughPixelWithSphere3() {
			Sphere sphere =  new Sphere(2,new Point3D(0, 0, 2));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                results = sphere.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("Bad ray",10,count);
	        System.out.println("count: "+count);

		}
		
		//TC04:the camera is in the shpere
		@Test
		public void constructRayThroughPixelWithSphere4() {
			Sphere sphere =  new Sphere(4,new Point3D(0, 0, 0));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                results = sphere.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("Bad ray",9,count);
	        System.out.println("count: "+count);

		}
		
		//TC05:the sphere is befor the camera
		@Test
		public void constructRayThroughPixelWithSphere5() {
			Sphere sphere =  new Sphere(0.5,new Point3D(0, 0, -1));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                results = sphere.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("Bad ray",0,count);
	        System.out.println("count: "+count);

		}
		
	    // **** Group: Construct Ray Throw Pixel With Plane
		//TC06:the plane is orthogonal to the view plane
		@Test
	    public void constructRayThroughPixelWithPlane1() {
			Plane plane =  new Plane( new Point3D(0, 0, 2), new Vector(0,0,1));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                results = plane.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("Bad ray",9,count);
	        System.out.println("count: "+count);

		}
		
		//TC07:the plane is at an angle to the view plane
		@Test
	    public void constructRayThroughPixelWithPlane2() {
			Plane plane =  new Plane( new Point3D(0, 0, 2), new Point3D(1,-3,1), new Point3D(0,-6,0));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                results = plane.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("Bad ray",9,count);
	        System.out.println("count: "+count);
		}
		
		//TC08:the plane is at an angle to the view plane but cross the top of the view plane
		@Test
	    public void constructRayThroughPixelWithPlane3() {
			Plane plane =  new Plane( new Point3D(0, 0, 5), new Point3D(0,-5,0), new Point3D(1,-2.5,2.5));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                results = plane.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("Bad ray",6,count);
	        System.out.println("count: "+count);
		}
		
	    // **** Group: Construct Ray Throw Pixel With Triangle
		//TC09:the triangle against only one of the pixels
		@Test
	    public void constructRayThroughPixelWithTriangle1() {
			Triangle triangle =  new Triangle( new Point3D(0, -1, 2), new Point3D(1,1,2), new Point3D(-1,1,2));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                results = triangle.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("Bad ray",1,count);
	        System.out.println("count: "+count);
		}
		
		//TC010:the triangle against two of the pixels
		@Test
	    public void constructRayThroughPixelWithTriangle2() {
			Triangle triangle =  new Triangle( new Point3D(0, -20, 2), new Point3D(1,1,2), new Point3D(-1,1,2));
	        List<Point3D> results;
	        int count = 0;
	        int Nx =3;
	        int Ny =3;
	        cam1.setViewPlaneSize(3,3);
	        cam1.setDistance(1);
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                results = triangle.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i));
	                if (results != null)
	                    count += results.size();
	            }
	        }

	        assertEquals("Bad ray",2,count);
	        System.out.println("count: "+count);
		}

}

