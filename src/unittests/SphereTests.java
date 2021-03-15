/**
 * 
 */
package unittests;
import geometries.*;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Rivka&Ora
 *
 */
public class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() 
	{
		 // ============ Equivalence Partitions Tests ==============
	    Sphere sp = new Sphere(1, new Point3D(0, 0, 1));
        assertNotEquals(new Vector(0, 0, 1), sp.getNormal(new Point3D(0, 1, 1)));
        System.out.println(sp.getNormal(new Point3D(0, 1, 1)));
    }

}
