package geometries;
import primitives.*;
import java.util.List;
import java.util.stream.Collectors;

public interface Intersectable 
{

	default List<Point3D> findIntersections(Ray ray) {
		var geoList = findGeoIntsersections(ray);
		return geoList == null ? null
		: geoList .stream().map(gp->gp._point).collect(Collectors.toList());
		
		}
	List<GeoPoint> findGeoIntsersections(Ray ray);
	 /**
     * GeoPoint is just a tuple holding
     * references to a specific geometry and it's specific point
     * acting as a public static class (inner class)
     */
  public static class GeoPoint
  {

	  public Geometry _geometry;
	  public Point3D _point;

        public GeoPoint(Geometry geometry, Point3D pt) 
        {
            this._geometry = geometry;
            this._point = pt;
        }
        @Override
        public boolean equals(Object o) 
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            GeoPoint geoPoint = (GeoPoint) o;

            return
            		((_geometry.equals(geoPoint._geometry)) && (_point.equals(geoPoint._point)));
        }
        /**
         * @param ray current ray
         * @return list of GeoPoint that intersect with the ray
         */
    
}
}
