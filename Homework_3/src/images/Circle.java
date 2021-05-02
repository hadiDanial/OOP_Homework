package images;

public class Circle extends BaseImage
{
	private int radius;
	private int centerX, centerY;
	
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) 
	{
		super(width, height, center, outside);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	
	public Circle(int size, int radius, RGB center, RGB outside) 
	{
		super(size, size, center, outside);
		centerX = size/2;
		centerY = size/2;
		this.radius = radius;
	}
	
	@Override
	public RGB get(int x, int y) 
	{
		double distance = getDistanceFromCenter(x, y);
		if(distance > radius) return color2;
		double percent = 1 - distance/radius;
		return RGB.mix(color1, color2, percent);
	}
	
	/**
	 * Returns the distance of (x, y) from the center of the circle.
	 */
	private double getDistanceFromCenter(int x, int y)
	{
		double deltaX = x - centerX;
		double deltaY = y - centerY;
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}

}
