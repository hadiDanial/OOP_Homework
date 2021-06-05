package mines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import mines.AudioManager.AudioType;

public class MinesFX extends Application
{
	private HBox root;
	private GridPane grid;
	private Mines mines;
	private Stage stage;
	private List<GridButton> buttons;
	private AudioManager audioManager;
	private static int buttonSize = 40;
    private double startTime, endTime;
    private boolean isGameDone = false;
    
    public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage stage)
	{
		MineSweeperController controller;
		audioManager = new AudioManager();
		this.stage = stage;
		root = new HBox();
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("mines.fxml"));
			root = loader.load();
			controller = loader.getController();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return;
		}
		
		grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setAlignment(Pos.CENTER_LEFT);
		controller.setupController(this);
		root.getChildren().add(grid);
				
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setMinWidth(350);
		stage.setMinHeight(150);
		stage.setTitle("Hadi's MineSweeper");
		stage.show();
	}



	public void reset(int width, int height, int numMines) 
	{
		grid.getChildren().clear();
		mines = new Mines(height, width, numMines);
		buttons = new ArrayList<>();
		GridButtonHandler handler = new GridButtonHandler();
		int alternate = 0;
		String color, hoverColor = "-fx-background-color: rgb(198, 241, 192);"; //rgb(230, 234, 220);\";
		String normalCornerRadius = "-fx-background-radius: 0 0 0 0;", radiusFX;
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				radiusFX = getCornerRadius(i, j, height, width, normalCornerRadius);
				if(alternate % 2 == 0)
				{
					color = "-fx-background-color: rgb(171, 216, 81);";					
				}
				else
				{
					color = "-fx-background-color: rgb(151, 204, 46);";					
				}
				GridButton button = new GridButton(mines.get(i, j), i, j, color, hoverColor, radiusFX);
				buttons.add(button);
				button.setOnMouseClicked(handler);
				button.setOnMouseEntered(handler);
				button.setOnMouseExited(handler);
				button.setPrefSize(buttonSize, buttonSize);
				button.setMaxSize(buttonSize, buttonSize);
				button.setMinSize(buttonSize, buttonSize);
				button.setOnMouseEntered(handler);
				grid.add(button, j, i);
				alternate++;
			}
			if(width % 2 == 0) 
				alternate++;
		}
		stage.setMinWidth(width * buttonSize + 250);
		stage.setMinHeight(height * buttonSize + 100);
		stage.setWidth(width * buttonSize + 250);
		stage.setHeight(height * buttonSize + 100);
		
		startTime = System.currentTimeMillis();
		isGameDone = false;
	}
	
	/**
	 * @return Corner Radius based on grid position - 0 inside, 5 on the corners.
	 */
	private String getCornerRadius(int i, int j, int height, int width, String normalCornerRadius) 
	{
		String radiusFX = normalCornerRadius;
		if(i == 0 && j == 0)
		{
			radiusFX = "-fx-background-radius: 5 0 0 0;";
		}
		else if(i == 0 && j == width - 1)
		{
			radiusFX = "-fx-background-radius: 0 5 0 0;";
		}
		else if(i == height - 1 && j == 0)
		{
			radiusFX = "-fx-background-radius: 0 0 0 5;";
		}
		else if(i == height - 1 && j == width - 1)
		{
			radiusFX = "-fx-background-radius: 0 0 5 0;";
		}
		return radiusFX;
	}

	private void onButtonPress(int i, int j)
	{
		if(mines.open(i, j))
		{
			if(mines.isDone())
			{
				endTime = System.currentTimeMillis();
				audioManager.playSFX(AudioType.Win);
				showEndScreen("You Won!");
				
			}
			else
				audioManager.playSFX(AudioType.Safe);
		}
		else
		{
			audioManager.playSFX(AudioType.Mine);
			endTime = System.currentTimeMillis();
			showEndScreen("You lost! Better luck next time...");
		}
		updateButtonText();
		
	}

	private void showEndScreen(String endMessage) {
		// TODO Auto-generated method stub
		mines.setShowAll(true);
		isGameDone = true;
		Stage endStage = new Stage();
		endStage.setWidth(350);
		endStage.setHeight(150);
		endStage.setTitle("Game Over");
		VBox vbox = new VBox();
		Label endLabel = new Label(endMessage);
		Label gameTime = new Label("You took " + (endTime - startTime) / 1000 + " seconds to finish.");
		endLabel.setStyle("-fx-alignment: center;");
		gameTime.setStyle("-fx-alignment: center;");
		vbox.setAlignment(Pos.CENTER);
		Insets inset = new Insets(15);
		VBox.setMargin(endLabel, inset);
		VBox.setMargin(gameTime, inset);
		vbox.setPadding(inset);
		vbox.getChildren().addAll(endLabel, gameTime);
		Scene scene = new Scene(vbox);
		endStage.setScene(scene);
		endStage.show();	
		
	}


	private void onSetFlag(int x, int y) 
	{
		mines.toggleFlag(x, y);
		audioManager.playSFX(AudioType.Flag);
		updateButtonText();
	}
	
	private void updateButtonText() {
		for(GridButton button : buttons)
		{
			button.setText(mines.get(button.getX(), button.getY()));
		}
	}
	
	private class GridButtonHandler implements EventHandler<MouseEvent>
	{
		@Override
		public void handle(MouseEvent event) 
		{
			ScaleTransition scaleUp = new ScaleTransition();
			ScaleTransition scaleDown = new ScaleTransition();
			GridButton btn = (GridButton) event.getSource();
			if(!isGameDone)
			{
				if(event.getButton() == MouseButton.PRIMARY)
					onButtonPress(btn.getX(), btn.getY());
				if(event.getButton() == MouseButton.SECONDARY)
					onSetFlag(btn.getX(), btn.getY());
				if(event.getEventType() == MouseEvent.MOUSE_ENTERED)
				{
					btn.setHoverColor();
					scaleUp.setDuration(Duration.millis(100));
					scaleUp.setFromX(1);
					scaleUp.setFromY(1);
					scaleUp.setToX(1.1);
					scaleUp.setToY(1.1);			
					scaleUp.setNode(btn);
					scaleUp.play();
				}
				if(event.getEventType() == MouseEvent.MOUSE_EXITED)
				{
					btn.setNormalColor();				
					scaleDown.setDuration(Duration.millis(80));
					scaleDown.setFromX(1.1);
					scaleDown.setFromY(1.1);
					scaleDown.setToX(1);
					scaleDown.setToY(1);	
					scaleDown.setNode(btn);
					scaleDown.play();
				}
			}
		}		
	}
	
}
