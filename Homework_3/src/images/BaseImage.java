package images;

public abstract class BaseImage implements Image 
{
	protected int width, height;
	protected RGB color1, color2;
	
	public BaseImage(int width, int height) 
	{
		this.width = width;
		this.height = height;
	}
	
	public BaseImage(int width, int height, RGB color1, RGB color2) 
	{
		this.width = width;
		this.height = height;
		this.color1 = color1;
		this.color2 = color2;
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
