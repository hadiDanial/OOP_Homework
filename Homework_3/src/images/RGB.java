package images;

public class RGB 
{
	private double red;
	private double green;
	private double blue;
	
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1,0,0);
	public static final RGB GREEN = new RGB(0,1,0);
	public static final RGB BLUE = new RGB(0,0,1);	

	
	
	public RGB(double red, double green, double blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
		clampRGBValues();
	}

	public RGB(double grey)
	{
		red = grey;
		green = grey;
		blue = grey;
		clampRGBValues();
	}
	public double getRed() 
	{
		return red;
	}
	public double getGreen() 
	{
		return green;
	}
	public double getBlue() 
	{
		return blue;
	}
	
	public RGB invert()
	{
		return new RGB(1 - red, 1 - green, 1 - blue);
	}
	
	public RGB filter(RGB filter)
	{
		return new RGB(red * filter.red, green * filter.green, blue * filter.blue);
	}
	

	public static RGB superpose(RGB rgb1, RGB rgb2) 
	{
		RGB add = new RGB(rgb1.red + rgb2.red, rgb1.green + rgb2.green, rgb1.blue + rgb2.blue);
		return add;
	}

	public static RGB mix(RGB rgb1, RGB rgb2, double alpha)
	{
		double r = alpha * rgb1.red + (1-alpha) * rgb2.red;
		double g = alpha * rgb1.green + (1-alpha) * rgb2.green;
		double b = alpha * rgb1.blue + (1-alpha) * rgb2.blue;
		return new RGB(r,g,b);
	}
	
	
	public String toString()
	{
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}
	
	private void clampRGBValues() 
	{
		red = clamp(red, 0, 1);
		green = clamp(green, 0, 1);
		blue = clamp(blue, 0, 1);
	}
	
	private double clamp(double value, double min, double max) 
	{
		if(value < min) value = min;
		else if(value > max) value = max;
		return value;
	}
}
