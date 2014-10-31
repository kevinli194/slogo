package view;

import java.util.Locale;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * The over-arching view contains menuView and multiple SlogoWindows.
 * @author Mengen Huang
 * @author Kevin Li
 *
 */
public class SlogoView {
	private static final double HEIGHT_RATIO = 0.95;
	private Scene myScene;
	private BorderPane myRoot;
	private TabPane myTabs;

	/**
	 * Create the SlogoView.
	 * @param stage
	 * @param locale language and locale used in SlogoView
	 * @param width width of View
	 * @param height height of View
	 */
	public SlogoView(Stage stage, Locale locale, double width, double height) {
		myTabs = new TabPane();
		setTabView(width, height * HEIGHT_RATIO);

		myRoot = new BorderPane();
		myRoot.setCenter(myTabs);
		myRoot.setTop(new MenuView(locale, myTabs, width, height));
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
