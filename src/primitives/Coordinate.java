package primitives;
import static primitives.Util.*;

public final class Coordinate
{

    final double coord;

   
    public Coordinate(double coord)
    {
        // if it too close to zero make it zero
        this.coord = alignZero(coord);
    }

   
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate)obj;
        return isZero(coord - other.coord);
    }

  
    public String toString() 
    {
        return "" + coord;
    }
}
