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
/** 
 * Promotes transparency 
 * @param kT
 */
public double kT=0;
/** 
 * Coefficient of reflection 
 * @param kR
 */
public double kR=0;
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
 * setter of nShininess
 * 
 * @param nShininess
 * @return material
 */
public Material setnShininess(int nShininess)
{
	this.nShininess=nShininess;
	return this;
}
/**
 * setter of kT
 * 
 * @param kT
 * @return material
 */
public Material setkT(double kT)
{
	this.kT=kT;
	return this;
}
/**
 * setter of kR
 * 
 * @param kR
 * @return material
 */
public Material setkR(double kR)
{
	this.kR=kR;
	return this;
}


}


