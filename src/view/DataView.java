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
 * 
 * @author Kevin Li
 * @author Meng'en Huang
 *
 */
public class DataView extends PaneView {

	private static final String DEFAULT_DISPLAY_RESOURCE = "resources.languages/Display";
	private BasicCommandsView myBasicCommands;
	private UDCommandsView myUDCommands;
	private VariablesView myVariablesView;
	private Accordion myView;
	private Locale myLocale;

	public DataView(InputView input, double width, double height, Locale locale) {
		myView = new Accordion();
		myLocale = locale;
		myView.setPrefSize(width * 1 / 5, height * 11 / 16);
		setView(width * 1 / 5, height * 11 / 16);
		myBasicCommands = new BasicCommandsView(input, width, height);
		myUDCommands = new UDCommandsView(input, width, height);
		myVariablesView = new VariablesView(input, width, height);
		ResourceBundle languageBundle = ResourceBundle.getBundle(
				DEFAULT_DISPLAY_RESOURCE, myLocale);
		TitledPane t1 = new TitledPane(
				languageBundle.getString("BasicCommands"), myBasicCommands);
		TitledPane t2 = new TitledPane(
				languageBundle.getString("UserDefinedCommands"), myUDCommands);
		TitledPane t3 = new TitledPane(
				languageBundle.getString("UserDefinedVariables"),
				myVariablesView);
		myView.getPanes().addAll(t1, t2, t3);
		this.getChildren().add(myView);
	}

	/**
	 * Updates the view using model's commandsList and variablesList data. Calls
	 * the respective update function in the subcomponents.
	 * 
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
