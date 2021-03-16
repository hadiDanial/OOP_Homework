package root;

public class Rooter
{
//	public static void main(String[] args)
//	{
//		Rooter r = new Rooter(0.1);
//		System.out.println(r.sqrt(2));
//		r.setPrecision(0.00001);
//		System.out.println(r.sqrt(-5));
//	}

	private double precision;

	public Rooter(double precision)
	{
		this.precision = precision;
	}

	public void setPrecision(double precision)
	{
		this.precision = precision;
	}
 
	public double sqrt(double x)
	{
		double one = x / 2, two;
		double result = one;
		boolean found = false;
		if(x == 0)
			return 0;
		else if(x < 0)
		{
			System.out.println("Negative number, returning -1.");
			return -1;
		}
		two = x / one;
		while (!isWithinPrecisionMargin(one, two) && !found) {
			two = x / one;
			if (one == two) {
				result = one;
				found = true;
			} else {
				one = (one + two) / 2.0;
			}
		}
		if (!found)
			result = one;
		return result;
	}

	/// Returns true if the difference between one and two is lower than the
	/// precision margin.
	private boolean isWithinPrecisionMargin(double one, double two)
	{
		double diff = one - two;
		if (diff < 0) // Absolute value
			diff *= -1;
		return (diff <= precision);
	}

}

