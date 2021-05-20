package primitives;
/**
 *  Material
 * 
 * @author Rivka Simani-Bohbot
 *
 */
public class Material 
{
public double kD=0;
public double kS=0;
public int nShininess=0;
/**
 * setter of kD
 * 
 * @param kD
 * @return material
 */
/*--------------------------------------------------setters------------------------------------------------------*/
public Material setkD(double kD)
{
	this.kD=kD;
	return this;
}
/**
 * setter of kS
 * 
 * @param kS
 * @return material
 */
public Material setkS(double kS)
{
	this.kS=kS;
	return this;
}
/**
 * setter of kD
 * 
 * @param kD
 * @return material
 */
public Material setnShininess(int nShininess)
{
	this.nShininess=nShininess;
	return this;
}
}


