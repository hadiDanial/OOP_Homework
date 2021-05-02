package images;

public class Mix extends BinaryImageDecorator
{
	private double alpha;

	public Mix(Image base1, Image base2, double alpha)
	{
		super(base1, base2);
		this.alpha = alpha;
	}

	@Override
	protected RGB getColorFromBoth(int x, int y)
	{
		return RGB.mix(base1.get(x, y), base2.get(x, y), alpha);
	}


}
