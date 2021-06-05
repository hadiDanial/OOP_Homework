package mines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mines
{
	private int height, width;
	private int numMines;
	private int numCells; // number of cells/slots
	private Cell[][] cells;
	private boolean showAll = false;
	
	
	public Mines(int height, int width, int numMines)
	{
		this.height = height;
		this.width = width;
		this.numMines = numMines;
		cells = new Cell[height][width];
		numCells = width * height;
		initializeMines();
	}

	private void initializeMines() {
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				cells[i][j] = new Cell(i, j);
			}
		}
		placeMinesRandomly();
	}



	/**
	 * Places numMines randomly around the grid.
	 */
	private void placeMinesRandomly() {
		Random rnd = new Random();
		int x, y;
		int counter = 0;
		if(numMines > numCells)
			numMines = numCells;
		
		while(counter < numMines)
		{
			x = rnd.nextInt(height);
			y = rnd.nextInt(width);
			
			if(!cells[x][y].isMine)
			{
				cells[x][y].isMine = true;
				counter++;
			}
		}
	}
	
	public boolean addMine(int i, int j)
	{
		if(cells[i][j].isMine) 
			return false;
		cells[i][j].isMine = true;
		return true;
	}
	
	public boolean open(int i, int j)
	{
		Cell cell = cells[i][j];
		if(cell.isMine) 
			return false;
		else 
			{
				cell.openCell();
				return true;
			}
	}
	
	public void toggleFlag(int x, int y)
	{
		if(isValidIndex(x, y))
			cells[x][y].toggleFlag();
	}
	
	public boolean isDone()
	{
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				if(!cells[i][j].isOpen && !cells[i][j].isMine)
					return false;
			}
		}
		return true;
	}
	
	public String get(int i, int j)
	{
		Cell cell = cells[i][j];
		if(showAll || cell.isOpen)
		{
			if(cell.isMine)
				return "X";
			else
			{
				cell.calculateNearbyMines();
				return (cell.numNearbyMines == 0) ? " " : cell.numNearbyMines + "";
			}
		}
		else
		{
			if(cell.isFlagged)
				return "F";
			else 
				return ".";
		}
	}
	
	public void setShowAll(boolean showAll)
	{
		this.showAll = showAll;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				sb.append(get(i, j));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * @return true if the index is valid.
	 */
	private boolean isValidIndex(int i, int j) 
	{
		return ((i >= 0 && i < height) && (j >= 0 && j < width));
	}
	
	private class Cell
	{
		private boolean isOpen = false;
		private boolean isFlagged = false;
		private boolean isMine = false;
		private int numNearbyMines = 0;
		private int x, y;
		
		public Cell(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		public void toggleFlag() 
		{
			isFlagged = !isFlagged;
		}

		/**
		 * Calculates how many of this cell's neighbors are mines.
		 */
		private void calculateNearbyMines() 
		{
			List<Cell> neighbors = getNeighbors();
			numNearbyMines = 0;
			for(Cell c : neighbors)
			{		
				if(c.isMine)
					numNearbyMines++;
			}
		}

		public void openCell() 
		{
			if(!isOpen)
			{
				isOpen = true;
				calculateNearbyMines();
				if(numNearbyMines == 0)
					openNeighbors();				
			}
		}

		private void openNeighbors() 
		{
			List<Cell> neighbors = getNeighbors();
			for(Cell c : neighbors)
			{		
				if(!c.isMine && !c.isOpen)
				{
					c.openCell();
				}						
			}
		}
		
		private List<Cell> getNeighbors()
		{
			List<Cell> neighbors = new ArrayList<>();
			for(int i = x - 1; i <= x + 1; i++)
			{
				for(int j = y - 1; j <= y + 1; j++)
				{
					if(i == x && j == y) continue;
					if(isValidIndex(i,j))
						neighbors.add(cells[i][j]);
				}
			}
			return neighbors;
		}
	}
}
