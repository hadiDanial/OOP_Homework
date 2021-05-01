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
