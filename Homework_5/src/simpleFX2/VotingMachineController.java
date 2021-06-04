package simpleFX2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


public class VotingMachineController 
{
	private int counter = 0;
	private int maxColorSteps = 10; // Color gradient steps
	private Color currentColor = new Color(0, 1, 0, 0.4);
	private Color defaultColor = new Color(0, 1, 0, 0.4);
	private Color ofraColor = new Color(1, 0, 0, 0.4);
	private Color yardenaColor = new Color(0, 0, 1, 0.4);
	private BackgroundFill fill = null;
	
	
    @FXML
    private Button ofraButton;

    @FXML
    private Button yardenaButton;

    @FXML
    private Label label;

    @FXML
    void updateOfra(ActionEvent event) 
    {
    	counter++;
    	updateLabel();
    }

    @FXML
    void updateYardena(ActionEvent event) 
    {
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
