/**
 * 
 */
package unittests;
import primitives.*;
import geometries.*;
import static org.junit.Assert.*;

import org.junit.Test;

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
		Tube t=new Tube(1,r);
		assertEquals(
				"Tube.getNormal() result is wrong",
				new Vector(-1,0,0),
				t.getNormal(new Point3D(0,1,0))
				);
				
		
	}

}
