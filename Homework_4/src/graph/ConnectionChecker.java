package graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> 
{
	private GraphInterface<V> graphInterface;
	
	public ConnectionChecker(GraphInterface<V> g)
	{
		graphInterface = g;
	}
	
	public boolean check(V v1, V v2)
	{
		if(v1.equals(v2)) return true;
		Set<V> visitedSets = new HashSet<>();
		return checkNeighbors(v1, v2, visitedSets);
	}

	/**
	 * A recursive function which checks all the neighbors of the current vertex for the target (Same as the one in Graph)
	 * @param current the current vertex
	 * @param target the target vertex
	 * @param visitedSets a set of visited vertices.
	 * @return true if the target can be reached from the current vertex, otherwise false.
	 */
	private boolean checkNeighbors(V current, V target, Set<V> visitedSets) 
	{
		if(visitedSets.contains(current))
			return false;
		visitedSets.add(current);
		if(current.equals(target)) return true;
		boolean value = false;
		Collection<V> neighbors = graphInterface.neighbours(current);
		for(V key : neighbors)
		{
			value = value || checkNeighbors(key, target, visitedSets);
		}
		return value;
	}
}
