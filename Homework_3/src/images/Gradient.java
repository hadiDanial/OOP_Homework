package images;

public class Gradient extends BaseImage
{
	private RGB start;
	private RGB end;
	
	public Gradient(int width, int height, RGB start, RGB end)
	{
		super(width, height);
		this.end = end;
		this.start = start;
	}

	@Override
	public RGB get(int x, int y) 
	{
		double percent = 1 - (double) x / width;
		return RGB.mix(start, end, percent);
	}

}
