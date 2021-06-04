package simpleFX;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		Scene scene = new Scene(createRoot());
		stage.setScene(scene);
		stage.setMinWidth(300);
		stage.setMinHeight(125);
		stage.setTitle("Voting Machine");
		stage.show();
	}

	private GridPane createRoot() 
	{
		GridPane gridPane = new GridPane();	
		setupGridPane(gridPane);
		addElements(gridPane);
//		gridPane.setGridLinesVisible(true);
		return gridPane;
	}

	private void setupGridPane(GridPane gridPane) {
		Insets inset = new Insets(20);
		gridPane.setMinWidth(250);
		gridPane.setPrefWidth(300);
		
		gridPane.setMaxHeight(Double.MAX_VALUE);
		gridPane.setPadding(inset);
		gridPane.setHgap(20);
		gridPane.setVgap(15);

		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(45);
		col1.setHalignment(HPos.CENTER);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(45);
		col2.setHalignment(HPos.CENTER);
		gridPane.getColumnConstraints().addAll(col1, col2);
		
		RowConstraints row1 = new RowConstraints();
		row1.setMinHeight(30);
		row1.setValignment(VPos.TOP);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(70);
		row2.setValignment(VPos.CENTER);
		row2.setPrefHeight(30);

		gridPane.getRowConstraints().addAll(row1, row2);

	}

	private void addElements(GridPane gridPane) {

		gridPane.setAlignment(Pos.CENTER);
		Button ofraButton = new Button("Ofra Haza");
		Button yardenaButton = new Button("Yardena Arazi");
		ofraButton.setPrefWidth(Double.MAX_VALUE);
		yardenaButton.setPrefWidth(Double.MAX_VALUE);
		ofraButton.setMaxHeight(Double.MAX_VALUE);
		yardenaButton.setMaxHeight(Double.MAX_VALUE);
		gridPane.add(ofraButton, 0, 0);
		gridPane.add(yardenaButton, 1, 0);
		
		Label label = new Label("0");
		label.setPrefHeight(30);
		label.setMaxHeight(Double.MAX_VALUE);

		label.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		label.setStyle("-fx-font: 18 arial; -fx-font-weight: bold; -fx-alignment: center;");
		gridPane.add(label,0,1,2,1);
		
		ofraButton.setOnAction(new Counter(label, true));
		yardenaButton.setOnAction(new Counter(label, false));
	}


}
