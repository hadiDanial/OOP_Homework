package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> 
{
	private Set<V> vertices = new HashSet<>();
	private Map<V, Set<V>> edges = new HashMap<>(); // Set of vertices that are connected to a certain vertex...
	
	public void addVertex(V v) throws GraphException
	{
		if(vertices.contains(v))
			throw new GraphException("Vertex " + v.toString() + " already exists in the graph.");
		vertices.add(v);
	}
	
	public void addEdge(V v1, V v2) throws GraphException
	{
		if(!vertices.contains(v1) || !vertices.contains(v2))
				throw new GraphException("Can't add edge, vertex doesn't exist in graph.");
		if(hasEdge(v1, v2))
			throw new GraphException("Edge already exists.");

		// Add a two way connection/edge between the vertices (add to each other's connected sets)
		addVertexToSet(v1, v2);
		addVertexToSet(v2, v1);
	}

	/**
	 * Adds v2 to the set of vertices connected to v1.
	 * If v1 doesn't have a set of vertices, create a new one.
	 */
	private void addVertexToSet(V v1, V v2) 
	{
		Set<V> set = edges.get(v1);
		if(set == null) 
		{
			set = new HashSet<>();
			edges.put(v1, set);
		}
		set.add(v2);
	}
	
	public boolean hasEdge(V v1, V v2)
	{
		Set<V> set1, set2;
		set1 = edges.get(v1);
		set2 = edges.get(v2);
		if(set1 == null || set2 == null) 
			return false;
		if(set1.contains(v2) && set2.contains(v1))
			return true;
		return false;
	}
	
	public boolean connected(V v1, V v2) throws GraphException
	{
		if(!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("Vertex doesn't exist, can't connect.");
		if(v1.equals(v2)) return true;
		Set<V> visitedSets = new HashSet<>();
		return checkNeighbors(v1, v2, visitedSets);
	}

	/**
	 * A recursive function which checks all the neighbors of the current vertex for the target
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
		Set<V> set = edges.get(current);
		if(set == null) // Nowhere to go, Only happens if there is no path, like in ProbabilityCheck (surrounded by walls).
			return false;
		for(V key : set)
		{
			value = value || checkNeighbors(key, target, visitedSets);
		}
		return value;			
	}
}
