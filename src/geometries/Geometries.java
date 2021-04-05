package geometries;
import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
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

	  /*get geometries
	  @return geometries list
	     
	    public List<Intersectable> getGeometries(){
	        return _geometries;
	    }
	    */
	   public List<Point3D> findIntersections(Ray ray)
	    {
		   List<Point3D> intersections = null;
	    	return intersections;
	    }
	    /* @return list of the intersection that cut with the geometry */
    @Override
    public List<Point3D> findIntsersections(Ray ray) 
    {
        List<Point3D> intersections = new ArrayList<Point3D>();

        for (Intersectable geometry : _geometries) 
        {
            List<Point3D> result = geometry.findIntsersections(ray);
            if (result != null) {
                intersections.addAll(result);
            }
        }
        if (intersections.size()> 0)
            return intersections;
        return null;
    }

}



