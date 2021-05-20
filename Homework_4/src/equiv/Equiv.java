package equiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Equiv<E>
{
	private List<HashSet<E>> sets;
	
	public Equiv()
	{
		sets = new ArrayList<HashSet<E>>();
	}
	
	public void add(E e1, E e2)
	{
		if(sets.size() == 0)
		{
			addNewSet(e1, e2);
		}
		else
		{
			HashSet<E> set1 = null, set2 = null;
			for(HashSet<E> s : sets)
			{
				if(s.contains(e1))
					set1 = s;
				if(s.contains(e2))
					set2 = s;
			}
			
			// Neither of the new elements exists in a set
			if(set1 == null && set2 == null)
			{
				addNewSet(e1, e2);
			}
			else
			{
				// One of them isn't in a set - just add to the other set
				if(set1 == null) set2.add(e1);
				else if(set2 == null) set1.add(e2);
				else // Combine both sets into one
				{
					if(set1.equals(set2)) return; // Already combined
					combineSets(set1, set2);
				}
			}
		}
	}

	/**
	 * Combines the two HashSets into a new HashSet that gets added to the list, removes the old sets from the list.
	 */
	private void combineSets(HashSet<E> set1, HashSet<E> set2) 
	{
		HashSet<E> combinedSet = new HashSet<E>();
		for(E element : set1)
		{
			combinedSet.add(element);
		}
		for(E element : set2)
		{
			combinedSet.add(element);
		}
		sets.remove(set1);
		sets.remove(set2);
		sets.add(combinedSet);
	}

	/**
	 * Adds a new HashSet to the list, that has elements e1 and e2 in it.
	 */
	private void addNewSet(E e1, E e2) {
		HashSet<E> newSet = new HashSet<E>();
		newSet.add(e1);
		newSet.add(e2);
		sets.add(newSet);
	}
	
	public boolean are(E e1, E e2)
	{
		if(e1.equals(e2)) return true;
		for(HashSet<E> s : sets)
		{
			if(s.contains(e1) && s.contains(e2))
			{
				return true;
			}
		}
		return false;
	}
	
//	public String toString()
//	{
//		String str = "";
//		for(HashSet<E> s : sets)
//		{
//			str += s.toString();
//		}
//		return str;
//	}
}
