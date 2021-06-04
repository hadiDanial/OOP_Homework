package simpleFX2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VotingMachine extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		GridPane root = new GridPane();
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("votingMachine.fxml"));
			root = loader.load();
			//controller = loader.getController();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setMinWidth(300);
		stage.setMinHeight(125);
		stage.show();
	}
}
