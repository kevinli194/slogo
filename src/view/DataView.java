package view;

import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import model.CommandsList;
import model.VariablesList;

public class DataView extends PaneView {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6355318324699961137L;
	/**
	 * 
	 */
	BasicCommandsView myBasicCommands;
	UDCommandsView myUDCommands;
	VariablesView myVariablesView;
	Accordion myView;

	public DataView(InputView input, double width, double height) {
		myView = new Accordion();
		myView.setPrefSize(width * 1 / 5, height * 11 / 16);
		setView(width * 1 / 5, height * 11 / 16);
		myBasicCommands = new BasicCommandsView(input, width, height);
		myUDCommands = new UDCommandsView(input, width, height);
		myVariablesView = new VariablesView(input, width, height);
		TitledPane t1 = new TitledPane("Basic Commands", myBasicCommands);
		TitledPane t2 = new TitledPane("User-Defined Commands", myUDCommands);
		TitledPane t3 = new TitledPane("User-Defined Variables",
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
