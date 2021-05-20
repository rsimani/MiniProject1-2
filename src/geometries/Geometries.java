package geometries;
import java.util.ArrayList;
import java.util.List;
import primitives.*;
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


    @Override
    public List<GeoPoint> findGeoIntsersections(Ray ray)
    {
        List<GeoPoint> intersections = new ArrayList<GeoPoint>();

        for (Intersectable geometry : _geometries) {
            List<GeoPoint> result = geometry.findGeoIntsersections(ray);
            if (result != null) 
            {
                intersections.addAll(result);
            }
        }
        if (intersections.size()> 0)
            return intersections;
        return null;
    }

}




