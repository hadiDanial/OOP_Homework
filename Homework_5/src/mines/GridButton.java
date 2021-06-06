package mines;

import javafx.scene.control.Button;

public class GridButton extends Button 
{
	private int x, y;
	private String color;
	private String hoverColor = "-fx-background-color: rgb(198, 241, 192);";
	private String openColor = "-fx-background-color: rgb(247, 239, 99);";
	private String cornerFX;
	private String font = "-fx-font-weight: bold; -fx-font-size: 16;";
	private double defaultFontSize = 18;
	private boolean isOpen = false;
	
	public GridButton(String text, int x, int y, boolean alternateColor, String corner, double scalePercent)
	{
		super(text);
		this.x = x;
		this.y = y;
		color = alternateColor ? "-fx-background-color: rgb(171, 216, 81);" : "-fx-background-color: rgb(151, 204, 46);";
		openColor = alternateColor ? "-fx-background-color: rgb(230, 195, 161);" : "-fx-background-color: rgb(216, 186, 155);";
		this.cornerFX = corner;
		double fontScale = (scalePercent == 1) ? defaultFontSize : defaultFontSize * scalePercent;
		font = "-fx-font-weight: bold; -fx-font-size: " + fontScale + ";";
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
		if(!isOpen)
			setStyle(hoverColor + cornerFX + font);
	}

	public void setNormalColor() 
	{
		if(!isOpen)
			setStyle(color + cornerFX +font);
	}	

	public void updateButton(String text) 
	{
		if(!isOpen && !(text.equals("X") || text.equals("F") || text.equals(".")))
		{
			isOpen = true;
			setStyle(openColor + cornerFX +font);
		}
		setText(text);	
	}
}
