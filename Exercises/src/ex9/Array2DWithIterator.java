package ex9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array2DWithIterator<E> extends Array2DBase<E> implements Iterable<E>{

	public Array2DWithIterator(int sizeX, int sizeY) 
	{
		super(sizeX, sizeY);
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new Iterator2D();
	}

	private class Iterator2D implements Iterator<E>
	{
		int i, j;
		@Override
		public boolean hasNext() 
		{
			return i < sizeX; // (i < sizeX && j < sizeY); // j is never bigger than sizeY, because it resets to 0, so no need to check
		}

		@Override
		public E next() 
		{
			if(!hasNext())
				throw new NoSuchElementException();
			E element = array[i][j];
			j++;
			if(j >= sizeY)
			{
				j = 0;
				i++;
			}
			return element;
		}
		
	}
	
	public static void main(String[] args) {
		Array2DWithIterator2<String> a = new Array2DWithIterator2<>(4, 4);
		for (int x = 0; x < 4; x++) 
			for (int y = 0; y < 4; y++)
				a.set(x,  y, x + "" + y);
		for (String val : a)
			System.out.print(val + " ");
	}
}
