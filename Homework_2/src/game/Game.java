package game;

import java.util.Scanner;

public class Game extends Board
{
	protected Player[] players;          
	protected Scanner s;                     

	private int currentPlayer = 0;
	
//	public static void main(String[] args) {
//		Game g = new Game(3, 4, new Player("Red", 'R'), new Player("Black", 'B'));
//		g.play();
//
//	}
	
	public Game(int n, int m, Player p1, Player p2)  
	{ 
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
		
		s = new Scanner(System.in);
	}
	
	protected boolean doesWin(int i, int j)          
	{ 
		return ((i == 0) && (j == 0));
	}
	
	protected boolean onePlay(Player p)              
	{
		int x, y;
		System.out.println(p + ", please enter x and y: ");
		x = s.nextInt();
		y = s.nextInt();
		while(!isEmpty(x, y))
		{
			System.out.println("There is a piece there already...");
			System.out.println(p + ", please enter x and y: ");
			x = s.nextInt();
			y = s.nextInt();
		}
		set(x, y, p);
		System.out.println(this);
		return doesWin(x, y);

	}
	
	public Player play()                             
	{
		boolean hasWon = false;
		do 
		{	
			hasWon = onePlay(players[currentPlayer]);
			if(!hasWon)
				currentPlayer = (currentPlayer + 1) % players.length;
			
		} while (!hasWon && !isFull());
		
		if(hasWon)
		{
			System.out.println(players[currentPlayer] + " Won!");
			s.close();
			return players[currentPlayer];
		}
		else
		{
			System.out.println(" The board is full, it's a tie!");
			return null;
		}
	}

}
