package javaFX;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		VBox vbox;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("testApp.fxml"));
			vbox = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.show();
	}
}
