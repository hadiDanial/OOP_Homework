package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator 
{
	private int[] array;
	private int index = 0;
	
	public MyArray(int[] array)
	{
		this.array = array;
	}
	
	@Override
	public boolean hasNext() 
	{
		return index < array.length;
	}

	@Override
	public int next() 
	{
		if(index >= array.length) throw new NoSuchElementException();
		int s = array[index];
		index++;
		return s;
	}

}
