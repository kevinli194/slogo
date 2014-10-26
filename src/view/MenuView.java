package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
	private String testSave;
	private Locale myLocale;
	private Map<String, Locale> localeMap=new HashMap<String, Locale>();
	
	private double myWidth;
	private double myHeight;

	public MenuView(Stage stage, Locale locale, TabPane tabs, double width,
			double height) {
		testSave = new String("This is a test.");
		myLocale=locale;
		myTabs = tabs;
		myTabCount = 1;
		myStage = stage;
		
		myWidth=width;
		myHeight=height;
		
		myFileChooser = new FileChooser();
		setMap();
		setView(width, height);
		createFileMenu(locale, width, height);

	}

	private void setMap() {
		localeMap.put("English", new Locale("en","US"));
		localeMap.put("中文", new Locale("cn","CN"));
	}

	public void createFileMenu(Locale locale, double width, double height) {
		Menu menuFile = new Menu("File");
		Menu menuLanguage=new Menu("Language");
		getLocale(menuLanguage);
		setFile(myLocale, width, height, menuFile);
		this.getMenus().addAll(menuFile,menuLanguage);
	}

	private void getLocale(Menu menuLanguage) {
		MenuItem langEnglish = makeLanguageItem("English");
		MenuItem langChinese = makeLanguageItem("中文");

		menuLanguage.getItems().addAll(langEnglish,langChinese);
	}

	private MenuItem makeLanguageItem(String language) {
		MenuItem languageItem = new MenuItem(language);
		languageItem.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				myLocale=localeMap.get(language);
				clear();
				createFileMenu(myLocale,myWidth,myHeight);
			}
			
		});
		return languageItem;
	}

	private void setFile(Locale locale, double width, double height,
			Menu menuFile) {
		newFile(locale, width, height, menuFile);
		openFile(locale, width, height, menuFile);
		saveFile(locale, width, height, menuFile);
	}

	private void openFile(Locale locale, double width, double height,
			Menu menuFile) {
		MenuItem openFile = new MenuItem("Open...");
		openFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				File file = myFileChooser.showOpenDialog(myStage);
				if (file != null) {
					try {
						ObjectInputStream is = new ObjectInputStream(
								new FileInputStream(file));
						String s = (String) is.readObject();
						System.out.println("The contents of the file are " + s);
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

	private void saveFile(Locale locale, double width, double height,
			Menu menuFile) {
		MenuItem saveFile = new MenuItem("Save As...");
		saveFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				File file = myFileChooser.showSaveDialog(myStage);
				if (file != null) {
					try {
						ObjectOutputStream os = new ObjectOutputStream(
								new FileOutputStream(file));
						os.writeObject(testSave);
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

	private void newFile(Locale locale, double width, double height,
			Menu menuFile) {
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {

				Tab tab = new Tab("Program " + myTabCount++);
				SlogoWindow additionalWindow = new SlogoWindow(locale, width,
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
	
	private void clear(){
		this.getMenus().clear();
	}

}
