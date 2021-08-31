package geometries;
import primitives.*;
/**
 *  class Geometry
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public abstract class Geometry implements Intersectable
{
	private Material material=new Material();
	 protected Color emission =Color.BLACK;
	public abstract Vector getNormal(Point3D p);
   
    /*--------------------------------------------------getters and setters------------------------------------------------------*/
	  /**
	   * getter to EmissionColor
     * @return emissionColor instance
     */


    public primitives.Color getEmission()
    {
        return emission ;
    }

    
	  /**
	   setter to EmissionColor
     * @return Geometry instance
     */
    public Geometry setEmission(Color emission ) 
    {
        this.emission =emission ;
        return this;
    }
    /**
     * getter to material
     * @return Material instance
     */


    public Material getMaterial()
    {
        return material;
    }
    /**
	   setter to material
     * @return Geometry instance
     */
    public Geometry setMaterial( Material material) 
    {
        this.material=material;
        return this;
    }
 
}