package elements;
import primitives.Color;
/**
 * ambient light
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class AmbientLight extends Light
{

	/**
	 * Constructor
	 * 
	 * @param IA - light of original filling
	 * @param KA - Coefficient of attenuation of filler light
	 */
	public AmbientLight(Color IA, double KA)
	{
		super(IA.scale(KA));
	}
	/**
	 * A default constructor
	 */
	public AmbientLight() {
		super(Color.BLACK);
	}

 

}


