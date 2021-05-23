package graph;

public class MainForMaze 
{
	public static void main(String[] args) throws GraphException {
		Maze m = new Maze(4, 0, 0, 3, 3);
		m.addWall(1, 1);
		m.addWall(3, 1);
		m.addWall(0, 1);
		m.addWall(2, 3);
		m.addWall(2, 3);
		m.addWall(1, 3);
		System.out.println(m);
		
		Graph<Integer> g = new Graph<>();
		for (int i = 0; i < 100; i++)
		g.addVertex(i);
		for (int i = 0; i < 50; i++)
		g.addEdge(i, i+1);
		System.out.println(g.connected(1, 10));
		System.out.println(g.connected(3, 70));
		System.out.println("Solvable? " + m.isSolvable());
		//System.out.println(m.toStringInverted());
		
		Maze m2 = new Maze(4, 0, 0, 3, 3);
		m2.addWall(1, 1);
		m2.addWall(3, 1);
		m2.addWall(0, 1);
		m2.addWall(2, 3);
		m2.addWall(2, 3);
		m2.addWall(1, 3);

		ConnectionChecker<Place> cc = new ConnectionChecker<>(m2);
		System.out.println("Checker: " + cc.check(new Place(0,0,4), new Place(3,2,4)));
		//System.out.println(m2.toStringInverted());
	}
}
