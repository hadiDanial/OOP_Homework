package mines;

import javafx.scene.control.Button;

public class GridButton extends Button 
{
	private int x, y;
	private String color, hoverColor, corner;
	private String font = "-fx-font-weight: bold; -fx-font-size: 16;";
	public GridButton(String text, int x, int y, String color, String hoverColor, String corner)
	{
		super(text);
		this.x = x;
		this.y = y;
		this.color = color;
		this.corner = corner;
		this.hoverColor = hoverColor;
		setStyle(color + corner + font);
	}
	
	public int getX() 
	{
		return x;
	}
	
	public int getY() 
	{
		return y;
	}

	public void setHoverColor() 
	{
		setStyle(hoverColor + corner + font);		
	}

	public void setNormalColor() 
	{
		setStyle(color + corner + font);
	}
}
