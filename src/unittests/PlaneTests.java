
package unittests;
import primitives.*;
import geometries.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
/**
 * @author Rivka&Ora
 *
 */
public class PlaneTests
{

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{
		Plane pl=new Plane(new Point3D(1,1,1),new Vector(2,0,0));
	
	        assertNotEquals(
	        		"Plane.getNormal() result is wrong",
	        		new Vector(1,0, 0),
	        		pl.getNormal(new Point3D(1, 1, 1)));
	}
	@Test
	   public void findIntsersections()
	{
	       Plane plane = new Plane(new Point3D(1, 0, 0), new Point3D(0, 0, 0), new Point3D(0, 0, 1));
	       Point3D point;

	       // ============ Equivalence Partitions Tests ==============
	       // TC01: Ray intersects the plane
	       List<Point3D> result = plane.findIntsersections(new Ray(new Point3D(0, -2, 0),new Vector(1, 1, 1)));
	       assertEquals("Wrong number of points", 1, result.size());
	       point = new Point3D(2, 0, 2);
	       assertEquals("Ray does not intersect the plane", List.of(point), result);

	       // TC02: Ray does not intersect the plane
	       result = plane.findIntsersections(new Ray(new Point3D(0, -2, 0),new Vector(-1, 0, 0)));
	       assertNull("Ray intersects the plane", result);


	       // =============== Boundary Values Tests ==================
	       // **** Group: Ray is parallel to the plane
	       // TC3: the ray included in the plane
	       assertNull("the ray doesn't included in the plane", 
	       		plane.findIntsersections(new Ray(new Point3D(-2, 0, 0),new Vector(2, 0, 2))));

	       // TC4: the ray does not included in the plane
	       assertNull("the ray included in the plane", plane.findIntsersections(new Ray(new Point3D(0, 1, 0),new Vector(2, 1, 2))));

	       
	 //Ray is orthogonal to the plane
	       
	       // TC5: Ray starts before the plane
	       Ray r5 = new Ray(new Point3D(0, 1, 0),new Vector(0, -2, 0));
	       assertEquals("the ray doesn't orthogonal to the plane", 0, new Vector(2, 0, 2).dotProduct(r5.getDirection().normalize()), 0);
	       assertEquals("the ray doesn't orthogonal to the plane", 1, (plane.findIntsersections(r5)).size());
	       List<Point3D> result5= plane.findIntsersections(r5);
	       Point3D point5 = new Point3D(0, 0, 0);
	       assertEquals("the ray is orthogonal and starts before the plane", List.of(point5), result5);

	       // TC6: Ray starts in the plane
	       Ray r6 = new Ray(new Point3D(0, 0, 0),new Vector(0, -2, 0));
	       assertEquals("the ray doesn't orthogonal to the plane", 0, new Vector(2, 0, 2).dotProduct(r6.getDirection().normalize()), 0);
	       assertNull("the ray is orthogonal and starts in the plane", plane.findIntsersections(r6));

	       // TC7: Ray starts after the plane
	       Ray r7 = new Ray(new Point3D(0, -1, 0),new Vector(0, -2, 0));
	       assertEquals("the ray doesn't orthogonal to the plane", 0, new Vector(2, 0, 2).dotProduct(r7.getDirection().normalize()), 0);
	       assertNull("the ray is orthogonal and starts after the plane", plane.findIntsersections(r7));

	       // **** Group: Ray is neither orthogonal nor parallel to the plane

	       // TC8: Ray begins at the plane
	       Ray r8 = new Ray(new Point3D(0, 0, 0),new Vector(4, -2, 3));
	       assertNull("in, and not parallel or orthogonal, start on p0", plane.findIntsersections(r8));

	       // TC9: Ray begins in the same point which appears as reference point in the plane
	       Ray r9 = new Ray(new Point3D(1, 0, 0),new Vector(4, -2, 3));
	       assertNull("in,  and not parallel or orthogonal, start on reference point", plane.findIntsersections(r9));


	   }
}
