package graph;

public class Place 
{
	private int x;
	private int y;
	private int bound;

	public Place(int x, int y, int bound)
	{
		if(isInBounds(x, bound) && isInBounds(y, bound)) 
		{			
			this.x = x;
			this.y = y;
			this.bound = bound;
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
		return (x == p.getX()) && (y == p.getY()) && (bound == p.bound);
	}
	
	@Override
	public int hashCode() 
	{
		return (x * x * x + y * y + 2 * bound + y) * 31;
	}
	
	@Override
	public String toString() 
	{
		return "Bound: " + bound + " - <" + x + ", " + y +">";
	}

}
