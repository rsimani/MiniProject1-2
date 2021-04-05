
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
public class TubeTests
{

	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{
		 // ============ Equivalence Partitions Tests ==============
		Ray r=new Ray(new Point3D(1,0,0),new Vector(0,1,0));
		Tube t=new Tube(r,1);
		assertEquals(
				"Tube.getNormal() result is wrong",
				new Vector(-1,0,0),
				t.getNormal(new Point3D(0,1,0))
				);
	}
		@Test
	    public void findIntsersections()
		{
			Tube tube = new Tube(new Ray(new Point3D(1, 0, 0),new Vector(0, 1, 0)),1d);
	        Point3D p1 = new Point3D(0, 2, 0);
	        Point3D p2 = new Point3D(2, 2, 0);

	        // TC01: Ray starts before and crosses the tube
	        List<Point3D> result = tube.findIntsersections(new Ray(new Point3D(-1, 2, 0),new Vector(1, 0, 0)));
	        assertEquals("Wrong number of points", 2, result.size());

	        if (result.get(0).getZ().get() > result.get(1).getZ().get())
	            result = List.of(result.get(1), result.get(0));
	        assertEquals("Ray crosses tube", List.of(p1, p2), result);
	        
	     // TC02: Ray starts after the tube
	        assertNull("Ray's start point out of tube",
	                tube.findIntsersections(new Ray(new Point3D(3, 2, 0),new Vector(1, 0, 0))));

	        // TC03: Ray starts inside the tube
	        result = tube.findIntsersections(new Ray(new Point3D(0.5, 2, 0),new Vector(1, 0, 0)));

	        assertEquals("Wrong number of points", 1, result.size());
	        assertEquals("Ray's crosses the tube", List.of(p2), result);

	        // TC04: Ray outside the tube
	        result = tube.findIntsersections(new Ray(new Point3D(0, 4, 3),new Vector(1, 0, 0)));
	        assertNull("Ray out of tube", result);

	        // =============== Boundary Values Tests ==================

	        //TC05: Ray starts at tube and go inside
	        result = tube.findIntsersections(new Ray(p1,new Vector(1, 0, 0)));

	        assertEquals("Wrong number of points", 1, result.size());
	        assertEquals("Ray's crosses the tube", List.of(p2), result);

	        // TC06: Ray starts at tube and goes outside
	        assertNull("Ray's start point the tube and go outside",
	                tube.findIntsersections(new Ray(p2,new Vector(1, 0, 0))));
	    }
		
		
	

}
