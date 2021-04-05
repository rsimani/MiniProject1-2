
package unittests;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import geometries.*;
import primitives.*;


/**
 * triangle testing
 * @author Rivka&Ora
 *
 */
public class TriangleTests
{

	/**
	 * Test method for {@link geometries.Triangle#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		 // ============ Equivalence Partitions Tests ==============
		Polygon p = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
	     double sqrt3 = Math.sqrt(1d / 3);
	     assertEquals("Bad normal to triangle", new Vector(sqrt3, sqrt3, sqrt3), p.getNormal(new Point3D(0, 0, 1)));
	}
	public void findIntersections() 
    {
        Triangle t = new Triangle(new Point3D(0, 3, -3),new Point3D(3, 0, -3),new Point3D(-3, 0, -3));
     
        // ============ Equivalence Partitions Tests ==============

        // TC01:the ray goes through the triangle
        assertEquals("the ray goes through the triangle", List.of(new Point3D(-1, 1.5, -3)), 
        		t.findIntsersections(new Ray( new Point3D(1, 1, -2),new Vector(-2, 0.5, -1))));
        // TC02:the ray is outside the triangle between 2 far sides
        assertNull("the ray is outside the triangle between 2 far sides",
        		t.findIntsersections(new Ray(new Point3D(4, 4, -2),new Vector(1, 1, -4))));
        // TC03:the ray is outside the triangle between 2 close sides
        assertNull("the ray is outside the triangle between 2 close sides",
        		t.findIntsersections(new Ray(new Point3D(-4, -1, -2),new Vector(-1, -1, -1))));

        // =============== Boundary Values Tests ==================
        
        // TC04:ray goes through the continuation of side 1
        assertNull("Ray goes through the continuation of side 1", t.findIntsersections(new Ray(new Point3D(-1, 4, -2), new Vector(0, 0, -1))));
       
        // TC05:ray through edge
        assertNull("Ray intersect the triangle on the edge", t.findIntsersections(new Ray( new Point3D(-2, 1, -1),new Vector(0, 0, -1))));
     
        // TC06:ray through vertex 
        assertNull("Ray intersect the triangle in vertex", t.findIntsersections(new Ray( new Point3D(0, 3, -2),new Vector(0, 0, -1))));
      
    }
}