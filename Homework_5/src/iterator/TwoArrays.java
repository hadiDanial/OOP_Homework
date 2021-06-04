package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer>
{
	private int[] a1, a2;
	
	public TwoArrays(int[] a1, int[] a2)
	{
		this.a1 = a1;
		this.a2 = a2;
	}
	
	@Override
	public Iterator<Integer> iterator() 
	{
		return new TwoArrayIterator();
	}
	
	private class TwoArrayIterator implements Iterator<Integer>
	{
		private int i, j;
		private int counter = 0;
		
		@Override
		public boolean hasNext() 
		{
			return (i < a1.length) || (j < a2.length);
		}

		@Override
		public Integer next() 
		{
			if(!hasNext()) return null;
			Integer next;
			if(i == a1.length)
			{
				next = a2[j];
				j++;
			}
			else if(j == a2.length)
			{
				next = a1[i];
				i++;
			}
			else if(counter % 2 == 0)
			{
				next = a1[i];
				i++;
			}
			else			
			{
				next = a2[j];
				j++;
			}
			counter++;
			return next;
		}
	}
}
