package ex9;

import java.util.ArrayList;

public class Array2DBase<E> 
{
	protected E[][] array;
	protected final int sizeX, sizeY;
	
	public Array2DBase(int sizeX, int sizeY) 
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		array = (E[][])new Object[sizeX][sizeY];
	}
	
	
	public void set(int x, int y, E val) {
		array[x][y] = val;
	}
	
	public E get(int x, int y) {
		return array[x][y];
	}  
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(1000*1000);
		for (int x = 0; x <= 1000; x++) {
			for (int y = 0; y <= 1000; y++) 
			{	
				int res = x | (y << 15);//((x+31)<<16 + y + x) * 31;
				if(!list.contains(res))
				{
					list.add(res);
					System.out.println("<" + x + ", " + y + "> : " + res);
				}
				else
				{
					System.out.println("ERROR <" + x + ", " + y + "> : " + res);
					throw new OutOfMemoryError();
				}
			}
		}
	}
}

