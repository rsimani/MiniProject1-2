package geometries;

import primitives.Point3D;
import primitives.*;

public abstract class Geometry implements Intersectable
{
	public Material material=new Material();
	 protected  primitives.Color _emissionColor=primitives.Color.BLACK;
	public abstract Vector getNormal(Point3D p);
   
    /*--------------------------------------------------getters and setters------------------------------------------------------*/
	  /**
	   * getter to EmissionColor
     * @return emissionColor instance
     */


    public primitives.Color getEmissionColor()
    {
        return _emissionColor;
    }

    
	  /**
	   setter to EmissionColor
     * @return Geometry instance
     */
    public Geometry setEmissionColor( primitives.Color color) 
    {
        this._emissionColor=color;
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

