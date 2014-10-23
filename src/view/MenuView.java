package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MenuView extends MenuBar {
	TabPane myTabs;
	private int myTabCount;

	public MenuView(String language, TabPane tabs, double width, double height) {
		myTabs = tabs;
		myTabCount = 1;
		setView(width, height);
		createFileMenu(language, width, height);

	}

	public void createFileMenu(String language, double width, double height) {
		Menu menuFile = new Menu("File");
		MenuItem newFile = new MenuItem("New");
		newFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Tab tab = new Tab("Program " + myTabCount++);
				SlogoWindow additionalWindow = new SlogoWindow(language, width,
						height * 9 / 10);
				tab.setContent(additionalWindow);
				myTabs.getTabs().add(tab);
				myTabs.getSelectionModel().select(tab);
			}
		});
		menuFile.getItems().add(newFile);
		this.getMenus().add(menuFile);

	}

	private void setView(double width, double height) {
		setPrefSize(width, height * 1 / 16);

	}

}
