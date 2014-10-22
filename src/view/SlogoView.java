package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class SlogoView {
	private Scene myScene;
	private BorderPane myRoot;
	private TabPane myTabs;
	private Button myAddButton = new Button("+");
	private int myTabCount;

	public SlogoView(String language, double width, double height) {
		myTabs = new TabPane();
		myTabCount = 1;

		SlogoWindow firstWindow = new SlogoWindow(language, width,
				height * 9 / 10);
		Tab tab = new Tab("Program " + myTabCount++);
		tab.setContent(firstWindow);
		myTabs.getTabs().add(tab);
		setTabView(width, height * 19 / 20);

		myRoot = new BorderPane();
		myRoot.setCenter(myTabs);
		myRoot.setTop(new ToolBar(myAddButton));

		myAddButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Tab tab = new Tab("Program " + myTabCount++);
				SlogoWindow additionalWindow = new SlogoWindow(language, width,
						height * 9 / 10);
				tab.setContent(additionalWindow);
				myTabs.getTabs().add(tab);
				myTabs.getSelectionModel().select(tab);
			}
		});

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
