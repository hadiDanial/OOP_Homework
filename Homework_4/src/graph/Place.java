package graph;

public class Place 
{
	private int x;
	private int y;

	public Place(int x, int y, int bound)
	{
		if(isInBounds(x, bound) && isInBounds(y, bound)) 
		{			
			this.x = x;
			this.y = y;
		}
		else
			throw new IllegalArgumentException("Values out of bounds!");
	}
	
	
	private boolean isInBounds(int val, int bound)
	{
		return (val >= 0) && (val < bound);
	}


	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if(!(obj instanceof Place))
				return false;
		Place p = (Place) obj;
		return (x == p.getX()) && (y == p.getY());
	}
	
	@Override
	public int hashCode() 
	{
		return x | (y << 15); // (x * x * x + y * y + 2 * y) * 31; not unique enough
	}
	
	@Override
	public String toString() 
	{
		return "Place <" + x + ", " + y +">";
	}

}
