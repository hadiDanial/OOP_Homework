package images;

public abstract class ImageDecorator implements Image
{
	protected Image base;
	protected int width, height;

	
	public ImageDecorator(Image base)
	{
		this.base = base;
		setDimensions();
	}

	/**
	 * Set the ImageDecorator dimensions to match the base.
	 */
	protected void setDimensions() 
	{
		width = base.getWidth();
		height = base.getHeight();
	}
	
	
	@Override
	public int getWidth() 
	{
		return width;
	}

	@Override
	public int getHeight() 
	{
		return height;
	}
	
}
