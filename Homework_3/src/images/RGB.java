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
		return new RGB(red * filter.getRed(), green * filter.getGreen(), blue * filter.getBlue());
	}
	

	public static RGB superpose(RGB rgb1, RGB rgb2) 
	{
		RGB add = new RGB(rgb1.getRed() + rgb2.getRed(), rgb1.getGreen() + rgb2.getGreen(), rgb1.getBlue() + rgb2.getBlue());
		return add;
	}

	public static RGB mix(RGB rgb1, RGB rgb2, double alpha)
	{
		double r = alpha * rgb1.getRed() + (1-alpha) * rgb2.getRed();
		double g = alpha * rgb1.getGreen() + (1-alpha) * rgb2.getGreen();
		double b = alpha * rgb1.getBlue() + (1-alpha) * rgb2.getBlue();
		return new RGB(r,g,b);
	}
	
	
	public String toString()
	{
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}
	
	/**
	 * Clamps the RGB values between 0 and 1.
	 */
	private void clampRGBValues() 
	{
		red = clamp(red, 0, 1);
		green = clamp(green, 0, 1);
		blue = clamp(blue, 0, 1);
	}
	
	/**
	 * Clamps value between min and max.
	 * @param value Value to clamp
	 * @param min Minimum value
	 * @param max Maximum value
	 * @return value clamped between min and max.
	 */
	private double clamp(double value, double min, double max) 
	{
		if(value < min) value = min;
		else if(value > max) value = max;
		return value;
	}
}
