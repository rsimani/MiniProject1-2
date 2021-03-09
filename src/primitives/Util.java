
package primitives;

public abstract class Util 
{
    
    private static final int ACCURACY = -40;

 
    private Util() {}
    
 
    private static int getExp(double num)
    {
       
        return (int)((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;
    }

    
    public static boolean isZero(double number)
    {
        return getExp(number) < ACCURACY;
    }

  
    public static double alignZero(double number)
    {
        return getExp(number) < ACCURACY ? 0.0 : number;
    }
    

	public static boolean checkSign(double n1, double n2) {
		return (n1 < 0 && n2 < 0) || (n1 > 0 && n2 > 0);
	}
	

	public static double random(double min, double max) {
		return Math.random() * (max - min) + min;
	}
	
}
