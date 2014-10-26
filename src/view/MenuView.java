package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.History;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuView extends MenuBar {
	TabPane myTabs;
	private int myTabCount;
	private FileChooser myFileChooser;
	private Stage myStage;

	public MenuView(Stage stage, String language, TabPane tabs, double width,
			double height) {

		myTabs = tabs;
		myTabCount = 1;
		myStage = stage;
		myFileChooser = new FileChooser();
		setView(width, height);
		createFileMenu(language, width, height);

	}

	public void createFileMenu(String language, double width, double height) {
		Menu menuFile = new Menu("File");
		newFile(language, width, height, menuFile);
		openFile(language, width, height, menuFile);
		saveFile(language, width, height, menuFile);
		this.getMenus().add(menuFile);

	}

	private void openFile(String language, double width, double height,
			Menu menuFile) {
		MenuItem openFile = new MenuItem("Open...");
		openFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				File file = myFileChooser.showOpenDialog(myStage);
				if (file != null) {
					try {
						ObjectInputStream is = new ObjectInputStream(
								new FileInputStream(file));
						History h = (History) is.readObject();
						Tab tab = new Tab(file.getName());
						SlogoWindow additionalWindow = new SlogoWindow(
								language, width, height * 9 / 10);
						additionalWindow.loadFile(h);
						additionalWindow.getModel().rerun();
						tab.setContent(additionalWindow);
						myTabs.getTabs().add(tab);
						myTabs.getSelectionModel().select(tab);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		menuFile.getItems().add(openFile);

	}

	private void saveFile(String language, double width, double height,
			Menu menuFile) {
		MenuItem saveFile = new MenuItem("Save As...");
		saveFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				File file = myFileChooser.showSaveDialog(myStage);
				if (file != null) {
					try {
						ObjectOutputStream os = new ObjectOutputStream(
								new FileOutputStream(file));
						int currentTab = myTabs.getSelectionModel()
								.getSelectedIndex();
						os.writeObject(((SlogoWindow) myTabs.getTabs()
								.get(currentTab).getContent()).getModel()
								.getMyData().get("History"));
						os.close();
						System.out.println("Done saving file.");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		menuFile.getItems().add(saveFile);

	}

	private void newFile(String language, double width, double height,
			Menu menuFile) {
		MenuItem newFile = new MenuItem("New...");
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
	}

	private void setView(double width, double height) {
		setPrefSize(width, height * 1 / 16);

	}

}
