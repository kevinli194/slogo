package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.SlogoView;
import model.SlogoModel;

public class Main extends Application {

	// Removed hard coding of the application. Should scale with screen
	// dimensions.

	private static final double SCREEN_WIDTH = Screen.getPrimary()
			.getVisualBounds().getWidth() * 3 / 4;
	private static final double SCREEN_HEIGHT = Screen.getPrimary()
			.getVisualBounds().getHeight() * 4 / 5;
	SlogoModel myModel;
	SlogoView myView;
	KeyControls myKeyControls;

	@Override
	public void start(Stage primaryStage) throws Exception {
		String language = "English";

		primaryStage.setResizable(false);

		myModel = new SlogoModel();
		myView = new SlogoView(language, myModel);
		myModel.addObserver(myView);
		Scene scene = new Scene(myView, SCREEN_WIDTH, SCREEN_HEIGHT);
		myKeyControls = new KeyControls(myModel, scene);
		myKeyControls.makeKeyCommands();
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}
}
