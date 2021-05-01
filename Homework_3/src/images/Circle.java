package images;

public class Circle extends BaseImage
{
	private int radius;
	private int centerX, centerY;
	private RGB center, outside;
	
	
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) 
	{
		super(width, height);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}
	
	public Circle(int size, int radius, RGB center, RGB outside) 
	{
		super(size, size);
		centerX = size/2;
		centerY = size/2;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}
	
	@Override
	public RGB get(int x, int y) 
	{
		double distance = getDistance(x, y);
		if(distance > radius) return outside;
		double percent = 1 - distance/radius;
		return RGB.mix(center, outside, percent);
	}
	
	private double getDistance(int x, int y)
	{
		double deltaX = x - centerX;
		double deltaY = y - centerY;
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}

}
