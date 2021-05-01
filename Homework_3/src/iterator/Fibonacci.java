package iterator;

public class Fibonacci implements MyIterator
{
	private int upperBound;
	private int nextNum = 1, currentNum = 1, previousNum = 0;
	
	public Fibonacci(int upperBound) 
	{
		this.upperBound = upperBound;
	}
	
	@Override
	public boolean hasNext() 
	{
		return isWithinBounds();
	}

	@Override
	public int next() 
	{
		int res;
		if(isWithinBounds())
		{
			res = currentNum;
			previousNum = currentNum;
			currentNum = nextNum;
			nextNum = currentNum + previousNum;
		}
		else 
			return res = previousNum;
		return res;
	}

	private boolean isWithinBounds() 
	{
		return currentNum < upperBound;
	}

}
