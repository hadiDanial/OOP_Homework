package game;

public class TicTacToe extends Game
{
	private static final int TICTAC_BOARD = 3;

	public TicTacToe(String player1, String player2)
	{
		super(TICTAC_BOARD, TICTAC_BOARD, new Player(player1, 'X'), new Player(player2, 'O'));
	}
	
	
	@Override
	protected boolean doesWin(int x, int y) 
	{
		return maxLineContaining(x, y) == TICTAC_BOARD;
	}


}
