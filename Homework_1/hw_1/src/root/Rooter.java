package root;

/**
 * A class to calculate the square root of a number, up to a given precision margin.
 */
public class Rooter
{
	private double precision;

	public Rooter(double precision)
	{
		this.precision = precision;
	}

	public void setPrecision(double precision)
	{
		this.precision = precision;
	}
 
	/** Returns the square root of x. If x is negative, returns -1.
	 */
	public double sqrt(double x)
	{
		double one = x / 2, two;
		double result = one;
		boolean found = false;
		
		if(x == 0) // Root of 0 is 0 - return now, we don't need to do the work, and we can't divide by 0 anyway.
			return 0;
		else if(x < 0)
		{
			return -1;
		}
		two = x / one;
		
		while (!isWithinPrecisionMargin(one, two) && !found) 
		{
			two = x / one;
			if (one == two) 
			{
				result = one;
				found = true;
			} else 
			{
				one = (one + two) / 2.0;
			}
		}
		if (!found) // Got to the required precision margin.
			result = one;
		return result;
	}

	/** 
	 * Returns true if the difference between one and two is lower than the precision margin.
	 */
	private boolean isWithinPrecisionMargin(double one, double two)
	{
		double diff = one - two;
		if (diff < 0) // Absolute value
			diff *= -1;
		return (diff <= precision);
	}

}

