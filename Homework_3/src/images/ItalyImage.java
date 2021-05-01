package images;

public class ItalyImage implements Image 
{
	public int getWidth() { return 200; }
	
	public int getHeight() { return 100; }
	
	public RGB get(int x, int y) 
	{ 
		return x<200/3 ? RGB.GREEN: 
			x > 200-200/3 ? RGB.RED: RGB.WHITE;
	}
	
	public static void main(String[] args) {
		Displayer.display(new ItalyImage());
	}
}
