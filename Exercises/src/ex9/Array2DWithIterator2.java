package ex9;

import java.util.Iterator;

public class Array2DWithIterator2<E> extends Array2DBase<E> implements Iterable<E>
{
	public Array2DWithIterator2(int sizeX, int sizeY) 
	{
		super(sizeX, sizeY);
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new Iterator<E>()
		{
			int i, j;
			@Override
			public boolean hasNext() 
			{
				return (i < sizeX && j < sizeY);
			}

			@Override
			public E next() 
			{
				E element = array[i][j];
				j++;
				if(j >= sizeY)
				{
					j = 0;
					i++;
				}
				return element;
			}
		};
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
