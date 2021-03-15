/**
 * 
 */
package unittests;
import primitives.*;
import geometries.*;
import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Sphere;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Rivka
 *
 */
public class PlaneTests {

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

}
