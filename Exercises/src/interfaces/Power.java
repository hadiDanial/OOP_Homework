package interfaces;

public class Power implements Function
{
	private int y;
	public Power(int y)
	{
		this.y = y;
	}
	@Override
	public int f(int i) 
	{
		int res = i;
		for (int j = 1; j < y; j++) 
		{
			res *= i;
		}
		return res;
	}

}
