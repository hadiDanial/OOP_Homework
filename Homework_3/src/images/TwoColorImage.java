package images;

public class TwoColorImage extends BaseImage
{
	private RGB zero;
	private RGB one;
	private TwoDFunc func;
	
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func)	
	{
		super(width, height);
		this.zero = zero;
		this.one = one;
		this.func = func;
	}

	@Override
	public RGB get(int x, int y) 
	{
		double alpha = 1 - func.f((double) x / width, (double) y / height);
		return RGB.mix(zero, one, alpha);
	}

}
