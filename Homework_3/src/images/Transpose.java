package images;

public class Transpose extends ImageDecorator
{

	public Transpose(Image base) 
	{
		super(base);
	}

	@Override
	public RGB get(int x, int y) 
	{
		return base.get(y, x);
	}
	
	@Override
	protected void setDimensions() 
	{
		width = base.getHeight();
		height = base.getWidth();
	}

}
