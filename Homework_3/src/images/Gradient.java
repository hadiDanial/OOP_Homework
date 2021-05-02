package images;

public class Gradient extends BaseImage
{
	
	public Gradient(int width, int height, RGB start, RGB end)
	{
		super(width, height, start, end);
	}

	@Override
	public RGB get(int x, int y) 
	{
		double percent = 1 - (double) x / width;
		return RGB.mix(color1, color2, percent);
	}

}
