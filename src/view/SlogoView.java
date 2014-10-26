package view;

import java.util.Locale;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SlogoView {
	private Scene myScene;
	private BorderPane myRoot;
	private TabPane myTabs;

	public SlogoView(Stage stage, Locale locale, double width, double height) {
		myTabs = new TabPane();
		setTabView(width, height * 19 / 20);

		myRoot = new BorderPane();
		myRoot.setCenter(myTabs);
		myRoot.setTop(new MenuView(stage, locale, myTabs, width, height));
		myScene = new Scene(myRoot, width, height);
	}

	private void setTabView(double width, double height) {
		myTabs.setPrefSize(width, height);
		myTabs.setMaxSize(width, height);
		myTabs.setMinSize(width, height);
	}

	public Scene generateScene() {
		return myScene;
	}
}
