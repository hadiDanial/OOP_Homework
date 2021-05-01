package interfaces;

public class Util 
{
	public static int sum(int n, Function func)
	{
		int sum = 0;
		for (int i = 0; i <= n; i++) 
		{
			sum += func.f(i);
		}
		return sum;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(sum(100, new Square()));
		System.out.println(sum(10, new Power(3)));
	}
}
