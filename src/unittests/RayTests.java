
package unittests;
import static org.junit.Assert.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


import primitives.*;

public class RayTests 
{
	public void raytests()
	{
		
	 // ============ Equivalence Partitions Tests ==============
	//TC01:A point in the middle is the closet point
	Ray r=new Ray(new Point3D(0,0,0),new Vector(1,1,1));
	List<Point3D> points = new ArrayList<Point3D>();
	points.add(new Point3D(3,3,3));
	points.add(new Point3D(2,2,2));
	points.add(new Point3D(4,4,4));

	assertEquals("point in tne middle of the list is the closet point", new Point3D(2,2,2), r.findClosestPoint(points));
	// =============== Boundary Values Tests ==================
	//TCO2:Empty list retutn null
	points=new ArrayList<Point3D>();
	assertEquals("List is empty", null, r.findClosestPoint(points));
	//TCO3:The first point is the most closet
	points.add(new Point3D(2,2,2));
	points.add(new Point3D(3,3,3));
	points.add(new Point3D(4,4,4));
	assertEquals("The first point is the closet point",new Point3D(2,2,2), r.findClosestPoint(points));
	//TCO4:The last point is the most closet
		points.add(new Point3D(4,4,4));
		points.add(new Point3D(3,3,3));
		points.add(new Point3D(2,2,2));
		assertEquals("The last point is the closet point",new Point3D(2,2,2), r.findClosestPoint(points));
						

}
}

