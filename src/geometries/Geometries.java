package geometries;
import java.util.*;
import primitives.*;
/**
 *  class Geometries
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class Geometries implements Intersectable

{
	 private  List<Intersectable> _geometries =new ArrayList<>() ;
	 /*constractor with empty list by ArrayList*/
	    public Geometries() 
	    {
	    	_geometries = new ArrayList<>();
	    }
	    /*constractor that get geometries and add him to the collection*/
	    public Geometries(Intersectable... geometries) 
	    {
	        this._geometries = new ArrayList<Intersectable>();
	        add(geometries);
	    }
	    /*add geometry*/
	    public void add(Intersectable... geometries) 
	    {
	        for (Intersectable geometry : geometries ) 
	        {
	        	_geometries.add(geometry);
	        }
	    }


/*
* A method that receives a Ray and checks the Ray's GeoIntersection points with all the bodies of the class
*
* @param ray the ray received
*
* @return  null / list that includes all the GeoIntersection points (contains the geometry (shape) and the point in 3D)
*/
@Override
public List<GeoPoint> findGeoIntersections(Ray ray, double maxDistance) {
   List<GeoPoint> result = null;
   for (Intersectable item : this._geometries) {
       List<GeoPoint> itemPoints = item.findGeoIntersections(ray,maxDistance);
       if (itemPoints != null) {
           if (result == null) {
               result = new LinkedList<>();
           }
           result.addAll(itemPoints);
       }
   }
   return result;
}
}




