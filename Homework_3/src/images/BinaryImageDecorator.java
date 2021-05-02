package images;

public abstract class BinaryImageDecorator implements Image
{
	protected int width, height;
	protected Image base1, base2;

	public BinaryImageDecorator(Image base1, Image base2) 
	{
		this.base1 = base1;
		this.base2 = base2;
		setDimensions();
	}
	
	/**
	 * Sets the BinaryImageDecorator dimensions to match the largest values of the base image dimensions.
	 */
	protected void setDimensions()
	{
		width = Math.max(base1.getWidth(), base2.getWidth());
		height = Math.max(base1.getHeight(), base2.getHeight());
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
		
	@Override
	public RGB get(int x, int y) 
	{
		boolean bounds1 = pointInImageBounds(base1, x, y);
		boolean bounds2 = pointInImageBounds(base2, x, y);
		if(bounds1 && bounds2) return getColorFromBoth(x, y);
		else if(bounds1 && !bounds2) return getColorFromImage(base1, x, y);
		else if(!bounds1 && bounds2) return getColorFromImage(base2, x, y);
		else return getDefaultNone(x, y);
	}
	
	/**
	 * Returns true if the point (x, y) is within the image bounds.
	 */
	protected boolean pointInImageBounds(Image img, int x, int y)
	{
		return (x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight());
	}
	
	/**
	 * Returns the color at point (x, y) as some combination of the two base images.
	 */
	protected abstract RGB getColorFromBoth(int x, int y);
	
	/**
	 * Returns the color at point (x, y) from the image.
	 */
	protected RGB getColorFromImage(Image img, int x, int y)
	{
		return img.get(x, y);
	}
	
	/**
	 * Returns the default color (from neither image).
	 */
	protected RGB getDefaultNone(int x, int y)
	{
		return RGB.BLACK;
	}
}
