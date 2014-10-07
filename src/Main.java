import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.SlogoView;
import model.SlogoModel;

public class Main extends Application {

	private static final double SCREEN_WIDTH = 1000;
	private static final double SCREEN_HEIGHT = 800;
	SlogoModel myModel;
	SlogoView myView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		String language = "English";
		myModel = new SlogoModel();
		myView = new SlogoView(language, myModel);
		myModel.addObserver(myView);
		Scene scene = new Scene(myView, SCREEN_WIDTH, SCREEN_HEIGHT);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
