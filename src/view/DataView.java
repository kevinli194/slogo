package view;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import model.CommandsList;
import model.VariablesList;

/**
 * The visual component that puts all three types of views - variables, user
 * defined commands, and basic commands into an Accordian.
 * @author Kevin Li
 * @author Meng'en Huang
 *
 */
public class DataView extends PaneView {

	private static final String DEFAULT_DISPLAY_RESOURCE = "resources.languages/Display";
	private static final double WIDTH_RATIO=0.2;
	private static final double HEIGHT_RATIO=0.6875;

	private BasicCommandsView myBasicCommands;
	private UDCommandsView myUDCommands;
	private VariablesView myVariablesView;
	private Accordion myView;
	private Locale myLocale;

	public DataView(InputView input, double width, double height, Locale locale) {
		myView = new Accordion();
		myLocale = locale;
		myView.setPrefSize(width * WIDTH_RATIO, height * HEIGHT_RATIO);
		setView(width * WIDTH_RATIO, height * HEIGHT_RATIO);
		myBasicCommands = new BasicCommandsView(input, width, height);
		myUDCommands = new UDCommandsView(input, width, height);
		myVariablesView = new VariablesView(input, width, height);
		ResourceBundle languageBundle = ResourceBundle.getBundle(
				DEFAULT_DISPLAY_RESOURCE, myLocale);
		createTitledPanes(languageBundle);
		this.getChildren().add(myView);
	}

	private void createTitledPanes(ResourceBundle languageBundle) {
		TitledPane t1 = new TitledPane(
				languageBundle.getString("BasicCommands"),
				myBasicCommands);
		TitledPane t2 = new TitledPane(
				languageBundle.getString("UserDefinedCommands"),
				myUDCommands);
		TitledPane t3 = new TitledPane(
				languageBundle.getString("UserDefinedVariables"),
				myVariablesView);
		myView.getPanes().addAll(t1, t2, t3);
	}

	/**
	 * Updates the view using model's commandsList and variablesList data.
	 * Calls the respective update function in the subcomponents.
	 * @param commandsList
	 *            List of all the commands - user defined and basic.
	 * @param variablesList
	 *            List of all the user defined variables.
	 */

	public void update(CommandsList commandsList, VariablesList variablesList) {
		myBasicCommands.update(commandsList);
		myUDCommands.update(commandsList);
		myVariablesView.update(variablesList);
	}
}
