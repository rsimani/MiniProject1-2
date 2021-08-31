package elements;
import primitives.*;
import static primitives.Util.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A class that describes a camera
 * @author Rivka simani-bohbot
 */

public class Camera
{
    /**
     * Private CTOR of the class built by Builder Pattern only
     *
     * @param cameraBuilder A virtual entity of the class we are currently implementing
     */
    private Camera(CameraBuilder cameraBuilder) {

        this.distance = cameraBuilder.distance;
        this.width = cameraBuilder.width;
        this.height = cameraBuilder.height;
        this.p0 = cameraBuilder.p0;
        this.vto = cameraBuilder.vTo;
        this.vup = cameraBuilder.vUp;
        this.vright = cameraBuilder.vRight;
    }
	private final Point3D p0;
    private final  Vector vup;
    private final  Vector vto;
    private final  Vector vright;
    private  double width;
    private  double height;
    private  double distance;


    /**
     * Builder Pattern, by this class we are updating the parent class (Camera),
     * instance that we are interested in creating even before we create it
     */
    public static class CameraBuilder
    {

        /**
         * the camera location in 3D
         */
        private Point3D p0;

        /**
         * Direction vector that defines what is the "top" of the camera
         */
        private Vector vUp;

        /**
         * vector toward - the direction vector in which the camera is aimed
         */
        private Vector vTo;

        /**
         * Direction vector that defines what is the "right" direction of the camera
         */
        private Vector vRight;

        /**
         * distance from camera to view plane
         */
        private double distance;

        /**
         * view - plane's width
         */
        private double width;

        /**
         * view - plane's height
         */
        private double height;
        /**
         * CameraBuilder's CTOR,
         * gets three components he needs to create a show
         *
         * @param p0 Location of the camera in 3D
         * @param vTo vector toward - the direction vector in which the camera is aimed
         * @param vUp Direction vector that defines what is the "top" of the camera
         */
        public CameraBuilder(Point3D p0, Vector vTo, Vector vUp)
        {
            this.p0 = p0;
            this.vTo = vTo.normalized();
            this.vUp = vUp.normalized();

            // check that vUp is orthogonal to vTo
            if(!isZero(vTo.dotProduct(vUp))) {
                throw new IllegalArgumentException("vUp is not orthogonal to vTo");
            }
            // Right hand rule
            vRight = vTo.crossProduct(vUp).normalized();
        }
    	/**
         * set the value of width and height
         * @return CameraBuilder value
         */
    	public CameraBuilder setViewPlaneSize(double width, double height)
    	{
    		this.width=width;
    		this.height=height;
    		return this;
    	}
    	/**
         * set the value of distance
         * @return CameraBuilder value
         */
    	public CameraBuilder setDistance(double distance)
    	{
    		if (isZero(distance)) 
    		{
                throw new IllegalArgumentException("distance cannot be 0");
            }
    		this.distance=distance;
    		return this;
    	}
    	   /**
         * We call this function when we have finished giving values to all the fields of the class,
         * and we are interested in creating an entity
         *
         * @return Camera
         */
        public Camera build() {
            return new Camera(this);
        }
    }


	/**
     * Returns the Point3D value of P0
     * @return Point3D value
     */
	public Point3D getP0() 
	{
		return new Point3D(p0);
	}
	/**
     * Returns the Vector value of getVup
     * @return Vector value
     */
	public Vector getVup() 
	{
		return vup;
	}
	/**
     * Returns the Vector value of getVto
     * @return Vector value
     */
	public Vector getVto() 
	{
		return vto;
	}
	
	/**
     * Returns the Vector value of getVright
     * @return Vector value
     */
	public Vector getVright()
	{
		return vright;
	}
	/**
     * Returns the value of width
     * @return double value
     */
	public double getWidth()
	{
		return width;
	}
	/**
     * Returns the value of height
     * @return double value
     */
	public double getHeight()
	{
		return height;
	}
	/**
     * Returns the value of distance
     * @return double value
     */
	public double getDistance()
	{
		return distance;
	}
	/**
     * a constructor for the camera element
     * @param p0= the position point of the camera
     * @param Vto= vector of the camera axises
     * @param Vup= vector of the camera axises
     */
	
	public Camera(Point3D p0, Vector vTo, Vector vUp) throws IllegalArgumentException {
		super();
		if (!isZero(vUp.dotProduct(vTo))) // if vTo doesn't orthogonal to vUp
			throw new IllegalArgumentException("vUp doesnt ortogonal to vTo");
		this.vup = vUp.normalized();
		this.vto = vTo.normalized();
		this.vright = (vTo.crossProduct(vUp)).normalize();
		this.p0 = p0;
	}


	/**
     * set the value of distance
     * @return camera value
     */
	public Camera setDistance(double distance)
	{
		if (isZero(distance)) 
		{
            throw new IllegalArgumentException("distance cannot be 0");
        }
		this.distance=distance;
		return this;
	}
	/**
     * this function create a ray thrown from the camera through a center of a pixel
     * @param nX= number of pixels on x
     * @param nY= number of pixels on y
     * @param j= point of where the pixel start on y
     * @param i= point of where the pixel start on x
     * @return ray thrown from the camera through a center of a pixel
     */
	public Ray constructRayThroughPixel (int nX, int nY, int j, int i)
	{


		Point3D Pc = p0.add(vto.scale(distance));

		double Ry = height / nY;
		double Rx = width / nX;
		double yi = (i - (nY - 1) / 2d) * Ry;
		double xj = (j - (nX - 1) / 2d) * Rx;

		Point3D Pij = Pc;

		if (!isZero(xj)) {
			Pij = Pij.add(vright.scale(xj));
		}
		if (!isZero(yi)) {
			Pij = Pij.add(vup.scale(-yi));
		}

		Vector Vij = Pij.subtract(p0);

		return new Ray(p0, Vij);

	}

    /**
     *gets the middle of pixel
     *
     * @param ray ray to move to the middle of it
     * @param nX number of pixels in the view plane in the x axis
     * @param nY number of pixels in the view plane in the y axis
     *
     * @return ray in the middle of the pixel
     */
    public Ray constructPixelCenterRay(Ray ray, double nX, double nY){

        // pixel height
        double height = alignZero(this.height / nY);
        // pixel width
        double width = alignZero(this.width / nX);

        double dis = distance;

        //use trigonemetry to get to the point
        double t = dis/(vto.dotProduct(ray.getDirection())); //cosinus on the angle
        Point3D point = ray.getPoint(t);
        point = point.add(vright.scale(width/2)).add(vup.scale(-height/2));
        return new Ray(p0, point.subtract(p0));
    }

    /**
     * constructing 4 rays from one ray, using if we got a different color in the previous test of the colors
     * in the 'square' of the pixel
     *
     * @param ray the ray to separate
     * @param nX number of pixels in x axis
     * @param nY number of pixels in y axis
     * @return list of 4 rays for adaptive super sampling
     */
    public List<Ray> constructFourRays(Ray ray, double nX, double nY) {

        // pixel height
        double height = alignZero(this.height / nY);
        // pixel width
        double width = alignZero(this.width / nX);

        //creates a list of 4 rays in the middle
        //     *
        //  *     *
        //     *
        List<Ray> myRays = new ArrayList<>();
        Point3D center = getPointOnViewPlane(ray);

        Point3D point1 = center.add(vup.scale(height / 2));
        //     #
        //  *     *
        //     *
        Point3D point2 = center.add(vright.scale(-width / 2));
        //     *
        //  #     *
        //     *
        Point3D point3 = center.add(vright.scale(width / 2));
        //     *
        //  *     #
        //     *
        Point3D point4 = center.add(vup.scale(-height / 2));
        //     *
        //  *     *
        //     #
        myRays.add(new Ray(p0, point1.subtract(p0)));
        myRays.add(new Ray(p0, point2.subtract(p0)));
        myRays.add(new Ray(p0, point3.subtract(p0)));
        myRays.add(new Ray(p0, point4.subtract(p0)));
        return myRays;
    }

    /**
     * Function to find a specific point on the plane
     * we need to calculate the distance from the point on the camera to the plane
     * for that we use the cos of the angle of the direction ray with vTo vector
     * @param ray ray to the specific point
     * @return the distance to the point
     */
    private Point3D getPointOnViewPlane(Ray ray) {
        double dis = distance;
        /**
         * distance from camera to our pixel
         */
        double t = dis / (vto.dotProduct(ray.getDirection())); //cosinus of the angle
        return ray.getPoint(t);
    }
    /**
     * In the first iteration we want to check the colors in all the corners of the pixel and in the center
     * and of course keep them in order to avoid re-checking later
     *
     * @param myRays array of the rays, at first it contains only the central ray in the third index
     * @param nX number of pixels in row
     * @param nY  number of pixels in column
     *
     * @return array of the rays
     */
    public Ray[] constructFiveRays(Ray myRays[], double nX, double nY) {

        /**
         * pixel height
         */
        double rY = alignZero(height / nY);
        /**
         * pixel width
         */
        double rX = alignZero(width / nX);

        Ray myRay = myRays[3];

        double dis = distance;
        /**
         * distance from camera to our pixel
         */
        double t = dis / vto.dotProduct(myRay.getDirection());
        /**
         * the middle of the pixel
         */
        Point3D center = myRay.getPoint(t);

        // up left
        myRays[1] =  new Ray(p0, center.add(vright.scale(-rX / 2)).add(vup.scale(rY / 2)).subtract(p0));
        // up right
        myRays[2] = new Ray(p0, center.add(vright.scale(rX / 2)).add(vup.scale(rY / 2)).subtract(p0));
        // down left
        myRays[4] = new Ray(p0, center.add(vright.scale(-rX / 2)).add(vup.scale(-rY / 2)).subtract(p0));
        // down right
        myRays[5] = new Ray(p0, center.add(vright.scale(rX / 2)).add(vup.scale(-rY / 2)).subtract(p0));
        //list of rays to be returned
        // *     *
        //    *
        // *     *
        return myRays;
    }
    /**
     * consruct a beam of rays around one ray, inside the pixel, according to the division it received,
     * and inside each sub-square takes out a random point for checking the color
     *
     * @param nX amount of pixels in width
     * @param nY amount of pixels in height
     * @param j the pixel's column
     * @param i the pixel's row
     * @param divide size of single pixels view plane
     *
     * @return list of internal rays
     */
    public LinkedList<Ray> constructBeam(int nX,  int nY, int j , int i, double divide) {

        /**
         * the image's center
         */
        Point3D Pc = getP0().add(vto.scale(distance));

        /**
         * height of single pixel
         */
        double Ry = alignZero(height/nY);

        /**
         * width of single pixel
         */
        double Rx = alignZero(width/nX);

        /**
         * amount of pixels to move in y axis from pc to i
         */
        double Yi = alignZero(-(i - ((nY - 1) / 2d)) * Ry);

        /**
         * amount of pixels  to move in x axis from pc to j
         */
        double Xj = alignZero((j - ((nX - 1) / 2d)) * Rx);

        Point3D Pij = Pc;

        if(!isZero(Xj)) {
            //only move on X axis
            Pij = Pij.add(vright.scale(Xj));
        }


        if(!isZero(Yi)) {
            //only move on Y axis
            Pij = Pij.add(vup.scale(Yi));
        }

        var rayList = new LinkedList<Ray>();
        rayList.add(constructRayThroughPixel(nX, nY, j, i));
        /**
         * up left corner of pixel
         */
        Point3D pixStart = Pij.add(vright.scale(-Rx / 2)).add(vup.scale(Ry / 2));
        // The formation of the rays within the division of the pixel,
        // in each square a point of intersection is selected at random
        for (double row = 0; row < divide; row++) {
            for (double col = 0; col < divide; col++) {
                rayList.add(randomPointRay(pixStart, col/divide, -row/divide));
            }
        }
        return rayList;
    }
    /**
     * using in simple anti alysing for calculate color in a point in a sub-square
     *
     * @param pixStart up left corner of the sub-square
     * @param col the column
     * @param row the row
     *
     * @return random ray inside the range
     */
    private Ray randomPointRay(Point3D pixStart, double col, double row)
    {
        Point3D point = pixStart;
        if(!isZero(col)) {
            //only move on X axis
            point = point.add(vright.scale(random(0, col)));
        }
        if(!isZero(row)) {
            //only move on Y axis
            point = point.add(vup.scale(random(row, 0)));
        }
        return new Ray(getP0(), point.subtract(getP0()));
    }
 	/**
     * set the value of width and height
     * @return Camera value
     */
	public Camera setViewPlaneSize(double width, double height)
	{
		this.width=width;
		this.height=height;
		return this;
	}
  

       


}

	
	


