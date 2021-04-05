
package unittests;
import static org.junit.Assert.*;
import org.junit.Test;
import geometries.*;
import primitives.*;



/**
 *  Testing Polygons
 * @author Rivka&Ora
 *
 */
public class PolygonTests
{

	 /**
     * Test method for
     * {@link geometries.Polygon#Polygon(primitives.Point3D, primitives.Point3D, primitives.Point3D, primitives.Point3D)}.
     */
    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct concave quadrangular with vertices in correct order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(-1, 1, 1));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct polygon");
        }

        // TC02: Wrong vertices order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(0, 1, 0),
                    new Point3D(1, 0, 0), new Point3D(-1, 1, 1));
            fail("Constructed a polygon with wrong order of vertices");
        } catch (IllegalArgumentException e) {}

        // TC03: Not in the same plane
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 2, 2));
            fail("Constructed a polygon with vertices that are not in the same plane");
        } catch (IllegalArgumentException e) {}

        // TC04: Concave quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0.5, 0.25, 0.5));
            fail("Constructed a concave polygon");
        } catch (IllegalArgumentException e) {}

        // =============== Boundary Values Tests ==================

        // TC10: Vertex on a side of a quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0.5, 0.5));
            fail("Constructed a polygon with vertix on a side");
        } catch (IllegalArgumentException e) {}

        // TC11: Last point = first point
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0, 1));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

        // TC12: Colocated points
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 1, 0));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

    }

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{
		   // ============ Equivalence Partitions Tests ==============
	    // TC01: There is a simple single test here
	    Polygon pl = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0),
	            new Point3D(-1, 1, 1));
	    double sqrt3 = Math.sqrt(1d / 3);
	    assertEquals("Bad normal to trinagle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
	
	}
	   @Test
	    public void findIntsersections() 
	   {
	    	Polygon polygon =new Polygon(new Point3D(1,0,1),new Point3D(1,0,0), new Point3D(3,0,0),new Point3D(3, 0, 1));
			 // ============ Equivalence Partitions Tests ==============
	    	
	        //TC01 - ray intersects with polygon
	        assertEquals("Ray Inside the polygon", 
	        		polygon.findIntsersections((new Ray(new Point3D(2,-2,0.5),new Vector(0, 1, 0)))));

	        //TC02- ray intersects with plane but outside the polygon against edge
	        assertNull("Ray starts outside against edge",polygon.findIntsersections((new Ray(new Point3D(2, -2, -1),new Vector(0, 1, 0)))));

	        //TC03- ray intersects with plane but outside the polygon against vertex
	        assertNull("Ray starts outside against vertex", polygon.findIntsersections((new Ray(new Point3D(3.5, -2, -0.2),new Vector(0, 1, 0)))));

	        // =============== Boundary Values Tests ==================

	        //TC04- the ray begins before the plane on the edge of polygon
	        assertNull("Ray's point is on the edge", polygon.findIntsersections((new Ray(new Point3D(3, -2, 0.5),new Vector(0, 1, 0)))));

	        //TC05- the ray begins before the plane on vertex
	        assertNull("Ray's point is in vertex", polygon.findIntsersections((new Ray(new Point3D(3, -2, 0),new Vector(0, 1, 0)))));

	        //TC06- the ray begins before the plane on edge's continuation
	        assertNull("Ray's point is On edge's continuation", polygon.findIntsersections((new Ray(new Point3D(3, -2, 2),new Vector(0, 1, 0)))));
	    }

	}


