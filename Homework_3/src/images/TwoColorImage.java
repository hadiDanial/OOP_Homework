package images;

public class TwoColorImage extends BaseImage
{
	private TwoDFunc func;
	
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func)	
	{
		super(width, height, zero, one);
		this.func = func;
	}

	@Override
	public RGB get(int x, int y) 
	{
		double alpha = 1 - func.f((double) x / width, (double) y / height);
		return RGB.mix(color1, color2, alpha);
	}

}
