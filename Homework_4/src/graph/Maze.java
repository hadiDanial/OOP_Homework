package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Maze implements GraphInterface<Place>
{
	private Place start, end;
	private Place[][] maze;
	private Place[][] invertedMaze;
	private int size;
	
	private static final char EMPTY_MARK = '.'; // null element
	private static final char START_MARK = 'S'; // equals start
	private static final char END_MARK = 'E';   // equals end
	private static final char WALL_MARK = '@';  // any other element/walls
	
	public Maze(int size, int startx, int starty, int endx, int endy) 
	{
		this.size = size;
		maze = new Place[size][size];
		start = new Place(startx, starty, size);
		end = new Place(endx, endy, size);
		maze[startx][starty] = start;
		maze[endx][endy] = end;
	}
	
	public boolean addWall(int x, int y)
	{
		Place wall = new Place(x, y, size);
		if(wall.equals(start) || wall.equals(end)) 
			return false;
		if(maze[x][y] != null) return false;
		maze[x][y] = wall;
		return true;
	}
	
	public boolean isSolvable()
	{
		generateInvertedMaze();
		try
		{
			Graph<Place> graph = new Graph<>();
			
			// Add vertices to the graph
			for (int i = 0; i < size; i++) 
			{
				for (int j = 0; j < size; j++)
				{
					if(invertedMaze[i][j] != null)
					{
						graph.addVertex(invertedMaze[i][j]);
					}
				}
			}
			
			// Connect edges
			// For each vertex, connect all surrounding vertices in the graph 
			// Graph.addEdge adds a two way connection, so we have to make sure we only add each edge once in here
			// Add edges on alternating elements (1):  1010 - For each 1, add all surrounding vertices (if they're traversable)
			//                                         0101 - Each 0 gets added when the ones next to it get added
			//                                         1010
			//                                         0101
			boolean addEdge = true;
//			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) 
			{
				if(size % 2 == 0) 
					addEdge = i % 2 == 0 ? true : false;
				
				for (int j = 0; j < size; j++)
				{
					if(invertedMaze[i][j] != null && addEdge)
					{
						addEdge(i - 1, j, graph, invertedMaze[i][j]);
						addEdge(i, j - 1, graph, invertedMaze[i][j]);
						addEdge(i + 1, j, graph, invertedMaze[i][j]);
						addEdge(i, j + 1, graph, invertedMaze[i][j]);			
					}
//					sb.append(addEdge ? "1" : "0");
					addEdge = !addEdge;
				}
//				sb.append("\n");
			}
//			System.out.println(sb.toString());
			
			return graph.connected(start, end); 
		}
		catch (GraphException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Generates an inverted maze array to use for navigation.
	 * Contains the start and end Places, and a place for every null element (no walls).
	 */
	private void generateInvertedMaze() {
		invertedMaze = new Place[size][size];
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++)
			{
				if(maze[i][j] != null)
				{
					if(isStartOrEndPlace(i, j))
					{
						
						if(maze[i][j].equals(start))
							invertedMaze[i][j] = start;
						else if(maze[i][j].equals(end))
							invertedMaze[i][j] = end;
					}
					else
						invertedMaze[i][j] = null;
				}
				else
					invertedMaze[i][j] = new Place(i,j,size);
			}
		}
	}

	/**
	 * @return True if the element in <i, j> is the start or end Place.
	 */
	private boolean isStartOrEndPlace(int i, int j) 
	{
		return maze[i][j].equals(start) || maze[i][j].equals(end);
	}

	/**
	 * Checks if the element <i, j> is valid and adds an edge in the graph between it and point if it is valid.
	 */
	private void addEdge(int i, int j, Graph<Place> graph, Place point) throws GraphException 
	{
		if(isValidIndex(i, j) && invertedMaze[i][j] != null)
		{
			graph.addEdge(invertedMaze[i][j], point);
		}
		
	}
	
	private boolean isValidIndex(int i, int j)
	{
		return (i >= 0) && (j >= 0) && (i < size) && (j < size);
	}

	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				if(maze[i][j] == null)
					sb.append(EMPTY_MARK);
				else if(maze[i][j].equals(start))
					sb.append(START_MARK);
				else if(maze[i][j].equals(end))
					sb.append(END_MARK);
				else sb.append(WALL_MARK);
				if(j == size - 1) 
					sb.append("\n");
			}
		}
		return sb.toString();
	}
	

	@Override
	public Collection<Place> neighbours(Place v) 
	{
		if(v == null) 
			return Collections.emptyList();
		generateInvertedMaze();
		List<Place> places = new ArrayList<>();
		int i = v.getX(), j = v.getY();
		addPlaceToNeighbors(i - 1, j, places);
		addPlaceToNeighbors(i, j - 1, places);
		addPlaceToNeighbors(i + 1, j, places);
		addPlaceToNeighbors(i, j + 1, places);					
		return places;		
	}
	
	/**
	 * Adds the element <i, j> in the invertedMaze to the List if it's valid and not null.
	 */
	private void addPlaceToNeighbors(int i, int j, List<Place> places)
	{
		if(isValidIndex(i, j) && invertedMaze[i][j] != null)
		{
			places.add(invertedMaze[i][j]);
		}
	}
	
//	// Print the inverted matrix
//	private String toStringInverted() 
//	{
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < size; i++) 
//		{
//			for (int j = 0; j < size; j++) 
//			{
//				if(invertedMaze[i][j] == null)
//					sb.append(EMPTY_MARK);
//				else if(invertedMaze[i][j].equals(start))
//					sb.append(START_MARK);
//				else if(invertedMaze[i][j].equals(end))
//					sb.append(END_MARK);
//				else sb.append(WALL_MARK);
//				if(j == size - 1) 
//					sb.append("\n");
//			}
//		}
//		return sb.toString();
//	}
}
