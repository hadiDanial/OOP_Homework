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
	
	protected boolean pointInImageBounds(Image img, int x, int y)
	{
		return (x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight());
	}
	
	
	@Override
	public RGB get(int x, int y) 
	{
		boolean bounds1 = pointInImageBounds(base1, x, y);
		boolean bounds2 = pointInImageBounds(base2, x, y);
		if(bounds1 && bounds2) return getBoth(x, y);
		else if(bounds1 && !bounds2) return getFirst(x, y);
		else if(!bounds1 && bounds2) return getSecond(x, y);
		else return getNone(x, y);
	}
	
	protected abstract RGB getBoth(int x, int y);
	protected RGB getFirst(int x, int y)
	{
		return base1.get(x, y);
	}
	protected RGB getSecond(int x, int y)
	{
		return base2.get(x, y);
	}
	protected RGB getNone(int x, int y)
	{
		return RGB.BLACK;
	}
}
