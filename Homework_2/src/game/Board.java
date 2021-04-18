package game;

public class Board 
{
	protected Player[][] board;
	protected int n, m;

	private int cellCount;

	
	public Board(int n, int m)                           
	{
		board = new Player[n][m];
		this.n = n;
		this.m = m;
		cellCount = 0;
	}
	protected boolean set(int i, int j, Player p)        
	{
		if(!isEmpty(i,j)) 
			return false;
		else 
		{
			board[i][j] = p;
			cellCount++;
			return true;
		}
	}
	
	public boolean isEmpty(int i, int j)                 
	{
		return board[i][j] == null;
	}
	
	public Player get(int i, int j)                      
	{
		if(!isValid(i, j)) return null;
		return board[i][j];
	}
	
	public boolean isFull()                              
	{
		return cellCount == n * m;
	}
	
	public String toString()                             
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				Player p = get(i, j);
				if(p == null)
					sb.append(".");
				else
					sb.append(get(i, j).getMark());
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	protected int maxLineContaining(int i, int j)        
	{
		int verticalCount, horizontalCount;
		int forwardDiagonalCount, backwardsDiagonalCount;
		if(!isValid(i, j) || isEmpty(i, j)) return 0;
		Player p = get(i, j);
		
		horizontalCount = getHorizontalCount(p, i, j);
		verticalCount = getVerticalCount(p, i, j);
		forwardDiagonalCount = getDiagonalCount(p, i, j, true);
		backwardsDiagonalCount = getDiagonalCount(p, i, j, false);
		
		// Return the maximum line
		return Math.max(Math.max(horizontalCount, verticalCount),Math.max(forwardDiagonalCount, backwardsDiagonalCount));
	}
	
	/**
	 * Gets the number of cells the player has in a horizontal line.
	 * @param p The player to check for.
	 * @param x Starting X Coordinate
	 * @param y Starting Y Coordinate
	 * @return Count of cells the player has captured horizontally.
	 */
	private int getHorizontalCount(Player p, int x, int y) 
	{
		int count = 1, initX = x;
		boolean done = false;
		x++;
		while(isValidNumber(x, n) && !done) 
		{
			if(checkCell(p, x, y))
				count++;
			else
				done = true;
			x++;		
		}
		x = initX - 1;
		done = false;
		while(isValidNumber(x, n) && !done)
		{
			if(checkCell(p, x, y))
				count++;
			else
				done = true;
			x--;	
		}
		return count;
	}

	/**
	 * Gets the number of cells the player has in a vertical line.
	 * @param p The player to check for.
	 * @param x Starting X Coordinate
	 * @param y Starting Y Coordinate
	 * @return Count of cells the player has captured vertically.
	 */
	private int getVerticalCount(Player p, int x, int y) 
	{
		int count = 1, initY = y;
		boolean done = false;
		y++;

		while(isValidNumber(y, m) && !done)
		{
			if(checkCell(p, x, y))
				count++;
			else
				done = true;
			y++;		
		}
		y = initY - 1;
		while(isValidNumber(y, m) && !done)
		{
			if(checkCell(p, x, y))
				count++;
			else
				done = true;
			y--;	
		}
		return count;
	}
	
	/**
	 * Gets the number of cells the player has in a diagonal line.
	 * @param p The player to check for.
	 * @param x Starting X Coordinate
	 * @param y Starting Y Coordinate
	 * @param forwards If true, checks the forwards diagonal (left to right), otherwise check the other diagonal (right to left).
	 * @return Count of cells the player has captured diagonally.
	 */
	private int getDiagonalCount(Player p, int x, int y, boolean forwards)
	{
		int count = 1, initX = x, initY = y;
		int sign = (forwards) ? 1 : -1;
		boolean done = false;

		x++;
		y += sign;
		while(isValidNumber(x, n) && isValidNumber(y, m) && !done) 
		{
			if(checkCell(p, x, y))
				count++;
			else
				done = true;
			x++;
			y += sign;
		}
		x = initX - 1;
		y = initY - sign;
		while(isValidNumber(x, n) && isValidNumber(y, m) && !done) 
		{
			if(checkCell(p, x, y))
				count++;
			else
				done = true;
			x--;
			y -= sign;
		}
		return count;
	}
	
	/**
	 * @param p Player to compare to.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @return Returns true if the player in cell (x,y) is owned by the provided player.
	 */
	private boolean checkCell(Player p, int x, int y) 
	{
		Player other;
		if(isEmpty(x, y)) return false;
		other = get(x,y);
		return p == other;
	}
	
	/**
	 * @param num Number to check.
	 * @param max The maximum number.
	 * @return Returns true if the number is valid (between 0 and max-1)
	 */
	private boolean isValidNumber(int num, int max) 
	{
		return ((num >= 0) && (num <= max - 1));
	}

	/**
	 *  Returns true if the coordinate <i, j> is valid
	 */
	private boolean isValid(int i, int j)
	{
		return isValidNumber(i, n) && isValidNumber(j, m);
	}
	
	
	
	
//	public static void main(String[] args) {
//		Player p1 = new Player("Bibi", 'B');
//		Player p2 = new Player("Gantz", 'G');
//		Board b = new Board(3,4);
//		b.set(0, 0, p1);
//		b.set(1, 0, p1);
//		b.set(2, 2, p2);
//		b.set(0, 0, p2);
//		b.set(0, 1, p1);
//		System.out.print(b);
//		System.out.println("Max(1,0) -> " + b.maxLineContaining(1, 0));
//		System.out.println("Max(2,2) -> " + b.maxLineContaining(2, 2));
//		System.out.println("Max(3,1) -> " + b.maxLineContaining(4, 3));
//
//	}
//	
}
