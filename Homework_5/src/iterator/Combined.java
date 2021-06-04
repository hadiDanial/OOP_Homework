package iterator;

import java.util.Iterator;

public class Combined<E> implements Iterable<E>
{
	private Iterable<E> first, second;
	
	public Combined(Iterable<E> first, Iterable<E> second) 
	{
		this.first = first;
		this.second = second;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new CombinedIterator();
	}
	
	private class CombinedIterator implements Iterator<E>
	{
		private Iterator<E> firstIterator = first.iterator();
		private Iterator<E> secondIterator = second.iterator();
		private int counter = 0;
		
		@Override
		public boolean hasNext() 
		{
			return (firstIterator.hasNext()) || (secondIterator.hasNext());
		}

		@Override
		public E next() 
		{
			if(!hasNext()) return null;
			E next;
			if(!firstIterator.hasNext())
			{
				next = secondIterator.next();
			}
			else if(!secondIterator.hasNext())
			{
				next = firstIterator.next();
			}
			else if(counter % 2 == 0)
			{
				next = firstIterator.next();
			}
			else			
			{
				next = secondIterator.next();
			}
			counter++;
			return next;
		}
	}

}
