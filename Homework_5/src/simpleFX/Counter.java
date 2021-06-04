package simpleFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Counter implements EventHandler<ActionEvent>
{
	private static int counter = 0;
	private static int maxColorSteps = 10; // Color gradient steps
	private static Color currentColor = new Color(0, 1, 0, 0.4);
	private static Color defaultColor = new Color(0, 1, 0, 0.4);
	private static Color ofraColor = new Color(1, 0, 0, 0.4);
	private static Color yardenaColor = new Color(0, 0, 1, 0.4);
	private static BackgroundFill fill = null;
	private Label label;
	private boolean addOnHandle;
	
	public Counter(Label label, boolean addOnHandle)
	{
		this.label = label;
		this.addOnHandle = addOnHandle;
		if(fill == null)
		{
			fill = new BackgroundFill(defaultColor, new CornerRadii(10), null);
			Background bg = new Background(fill);
			label.setBackground(bg);
		}
	}
	
	@Override
	public void handle(ActionEvent event) 
	{
		if(addOnHandle)
			counter++;
		else 
			counter--;
		updateLabel();		
	}

	private void updateLabel() {
		label.setText("" + counter);
		currentColor = mix(defaultColor, (counter>0) ? ofraColor : yardenaColor);
		fill = new BackgroundFill(currentColor, new CornerRadii(10), null);			
		Background bg = new Background(fill);
		label.setBackground(bg);
	}
	
	private Color mix(Color c1, Color c2)
	{
		int abs = Math.abs(counter);
		double alpha = 1 - ((abs > maxColorSteps) ? 1 : (double) abs /  maxColorSteps);
		double r = (alpha * c1.getRed() +  (1 - alpha) * c2.getRed());
		double g = (alpha * c1.getGreen() +(1 - alpha) *  c2.getGreen());
		double b = (alpha * c1.getBlue() + (1 - alpha) *  c2.getBlue());
		return new Color(r,g,b, 0.5);
	}

}
