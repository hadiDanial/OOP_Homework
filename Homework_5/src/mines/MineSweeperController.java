package mines;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MineSweeperController 
{

    @FXML
    private Button resetButton;

    @FXML
    private TextField widthText;

    @FXML
    private TextField heightText;

    @FXML
    private TextField numMinesText;
    
    private int width, height, numMines;
    private MinesFX minesFX;
       
    @FXML
    void resetGrid(ActionEvent event) 
    {
    	try
    	{
    		width = Integer.parseInt(widthText.getText());
    		height = Integer.parseInt(heightText.getText());
    		numMines = Integer.parseInt(numMinesText.getText());
    		minesFX.reset(width, height, numMines);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

	public void setupController(MinesFX minesFX) 
	{		
		this.minesFX = minesFX;
	}

}
