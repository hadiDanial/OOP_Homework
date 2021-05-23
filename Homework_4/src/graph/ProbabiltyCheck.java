package graph;

import java.util.Random;

/**
 * Check the percentage of mazes that are solvable when walls are places randomly with a 50% probability.
 */
public class ProbabiltyCheck 
{
	public static void main(String[] args) 
	{
		int count = 0, runAmount = 1000000;
		int size = 10;
		Random rnd = new Random();
		Place start = new Place(0, 0, size), end = new Place(9, 9, size);
		int rndRes;
		
		for (int r = 0; r < runAmount; r++) 
		{
			Maze m = new Maze(size, 0, 0, 9, 9);
			ConnectionChecker<Place> cc = new ConnectionChecker<>(m);
			for (int i = 0; i < size; i++) 
			{
				for (int j = 0; j < size; j++) 
				{
					rndRes = rnd.nextInt(2);
					if((i == 0 && j == 0)||(i == 9 && j == 9))
						continue;
					if(rndRes == 1)
						m.addWall(i, j);
				}
			}
			if(cc.check(start, end)) 
			{
				count++;
			}
//			if(m.isSolvable())
//			{
//				count ++;
//			}
		}
		double probablity = (double) count / runAmount;
		
		System.out.println(count + "/" + runAmount + " mazes were solvable - " + probablity);
		// ConnectionChecker:
		// Run 1: 22042/1000000 mazes were solvable - 0.022042
		// Run 2: 21938/1000000 mazes were solvable - 0.021938
		// Run 3: 21985/1000000 mazes were solvable - 0.021985
		// Run 4: 109677/5000000 mazes were solvable - 0.0219354
		
		// Maze.isSolvable():
		// Run 1: 21949/1000000 mazes were solvable - 0.021949
		// Run 2: 21846/1000000 mazes were solvable - 0.021846
	}
}
