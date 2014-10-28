package main;

import java.util.Locale;

import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.SlogoModel;
import view.SlogoView;

public class Main extends Application {

	private static final double SCREEN_WIDTH = Screen.getPrimary()
			.getVisualBounds().getWidth() * 3 / 4;
	private static final double SCREEN_HEIGHT = Screen.getPrimary()
			.getVisualBounds().getHeight() * 4 / 5;
	SlogoModel myModel;
	SlogoView myView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Locale locale = new Locale("en","US");

		primaryStage.setResizable(false);
		myModel = new SlogoModel(locale);
		myView = new SlogoView(primaryStage, locale, SCREEN_WIDTH,
				SCREEN_HEIGHT);

		primaryStage.setScene(myView.generateScene());
		primaryStage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}
}
