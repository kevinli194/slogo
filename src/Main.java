import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.SlogoView;
import model.SlogoModel;


public class Main extends Application{

	private static final double SCREEN_WIDTH=1000;
	private static final double SCREEN_HEIGHT=800;
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		String language = "English";
		SlogoModel model=new SlogoModel();
		BorderPane root= new SlogoView(language, model);
		Scene scene= new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main (String args[]){
		launch(args);
	}
}
