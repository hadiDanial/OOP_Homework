package game;

public class FourInARow extends Game
{
	private static final int WIDTH = 7, HEIGHT = 6, WIN_CONDITION = 4;

	public FourInARow(String player1, String player2)
	{
		super(HEIGHT, WIDTH, new Player(player1, 'W'), new Player(player2, 'B'));
	}

	@Override
	protected boolean doesWin(int i, int j)
	{
		return (maxLineContaining(i, j) == WIN_CONDITION);
	}
	
	@Override
	protected boolean onePlay(Player p)
	{
		int y;
		System.out.println(p + ", please enter column: ");
		y = s.nextInt();
		while(!isEmpty(0, y)) // If the top element is not empty then the column is full
		{
			System.out.println("Column is full...");
			System.out.println(p + ", please enter column: ");
			y = s.nextInt();
		}
		int x = HEIGHT - 1;
		while(!isEmpty(x, y))
			x--;
		set(x, y, p);
		System.out.println(this);
		return doesWin(x, y);

	}




}
