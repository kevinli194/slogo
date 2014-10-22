package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class SlogoView {
	private Scene myScene;
	private AnchorPane myRoot;
	private TabPane myTabs;
	private Button myAddButton = new Button("+");
	private int myTabCount;

	public SlogoView(String language, double width, double height) {
		myTabs = new TabPane();
		myTabCount = 1;
		SlogoWindow firstWindow = new SlogoWindow(language, width, height);
		Tab tab = new Tab("Program " + myTabCount++);
		tab.setContent(firstWindow);
		myTabs.getTabs().add(tab);
		myRoot = new AnchorPane();
		AnchorPane.setTopAnchor(myTabs, 5.0);
		AnchorPane.setLeftAnchor(myTabs, 5.0);
		AnchorPane.setRightAnchor(myTabs, 5.0);
		AnchorPane.setTopAnchor(myAddButton, 10.0);
		AnchorPane.setLeftAnchor(myAddButton, 10.0);

		myAddButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				final Tab tab = new Tab("Program " + myTabCount++);
				SlogoWindow additionalWindow = new SlogoWindow(language, width,
						height);
				tab.setContent(additionalWindow);
				myTabs.getTabs().add(tab);
				myTabs.getSelectionModel().select(tab);
			}
		});
		myRoot.getChildren().addAll(myTabs, myAddButton);

		myScene = new Scene(myRoot, width, height);
	}

	public Scene generateScene() {
		return myScene;
	}
}
