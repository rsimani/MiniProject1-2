package scene;
import elements.*;
import geometries.*;
import primitives.Color;

public class Scene 
{
	public String _name;
    public  Color _background;
    public AmbientLight _ambientLight;
    public Geometries _geometries;
 
    
    /**
     * constructor for the scene
     * @param name of the scene
     */

    public Scene(String name) 
    {
    	this._name=name;
        this._geometries=new Geometries();
	}


    /**
     * set the background color field
     * @param value of the background color
     *
     */
    public Scene set_background(Color _background) 
    {
        this._background = _background;
        return this;
    }

    /**
     * set the ambient light field
     * @param value of the ambient light 
     */
    public Scene set_ambientLight(AmbientLight _ambientLight) 
    {
        this._ambientLight = _ambientLight;
        return this;
    }
    /**
     * set the ambient light field
     * @param value of the ambient light 
     */
    public Scene set_geometries(Geometries _geometries) 
    {
        this._geometries = _geometries;
        return this;
    }


}
