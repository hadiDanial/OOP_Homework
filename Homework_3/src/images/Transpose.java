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
	
	/**
	 * Sets the ImageDecorator dimensions to be a transpose of the base image.
	 */
	@Override
	protected void setDimensions() 
	{
		width = base.getHeight();
		height = base.getWidth();
	}

}
