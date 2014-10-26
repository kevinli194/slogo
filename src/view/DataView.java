package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import model.CommandsList;
import model.VariablesList;

public class DataView extends PaneView {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6355318324699961137L;
	public static final String DEFAULT_DISPLAY_RESOURCE = "resources.languages/Display";

	/**
	 * 
	 */
	BasicCommandsView myBasicCommands;
	UDCommandsView myUDCommands;
	VariablesView myVariablesView;
	Accordion myView;
	Locale myLocale;

	public DataView(InputView input, double width, double height, Locale locale) {
		myView = new Accordion();
		myLocale=locale;
		myView.setPrefSize(width * 1 / 5, height * 11 / 16);
		setView(width * 1 / 5, height * 11 / 16);
		myBasicCommands = new BasicCommandsView(input, width, height);
		myUDCommands = new UDCommandsView(input, width, height);
		myVariablesView = new VariablesView(input, width, height);
		ResourceBundle languageBundle = ResourceBundle.getBundle(DEFAULT_DISPLAY_RESOURCE, myLocale);
		TitledPane t1 = new TitledPane(languageBundle.getString("BasicCommands"), myBasicCommands);
		TitledPane t2 = new TitledPane(languageBundle.getString("UserDefinedCommands"), myUDCommands);
		TitledPane t3 = new TitledPane(languageBundle.getString("UserDefinedVariables"),
				myVariablesView);
		myView.getPanes().addAll(t1, t2, t3);
		this.getChildren().add(myView);

	}

	public void update(CommandsList commandsList, VariablesList variablesList) {
		myBasicCommands.update(commandsList);
		myUDCommands.update(commandsList);
		myVariablesView.update(variablesList);
	}
}
