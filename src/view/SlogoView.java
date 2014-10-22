package view;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class SlogoView {
	private Scene myScene;
	TabPane myView;
	int TabCount;

	public SlogoView(String language, double width, double height) {
		myView = new TabPane();
		TabCount = 1;
		SlogoWindow window = new SlogoWindow(language, width, height);
		Tab tab = new Tab();
		tab.setText("Program " + TabCount);
		TabCount++;
		tab.setContent(window);
		myView.getTabs().add(tab);
		SlogoWindow window2 = new SlogoWindow(language, width, height);
		Tab tab2 = new Tab();
		tab2.setText("Program " + TabCount);
		tab2.setContent(window2);
		myView.getTabs().add(tab2);

		myScene = new Scene(myView, width, height);
	}

	public Scene generateScene() {
		return myScene;
	}
}
