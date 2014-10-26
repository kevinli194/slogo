package view;

import model.CommandsList;
import model.VariablesList;
import javafx.scene.layout.VBox;

public class DataView extends PaneView {
	BasicCommandsView myBasicCommands;
	UDCommandsView myUDCommands;
	VariablesView myVariablesView;
	VBox myView;

	public DataView(InputView input, double width, double height) {
		myView = new VBox();
		myView.setPrefSize(width * 1 / 5, height * 11 / 16);
		setView(width * 1 / 5, height * 11 / 16);

		myBasicCommands = new BasicCommandsView(input, width, height / 3);
		myUDCommands = new UDCommandsView(input, width, height / 3);
		myVariablesView = new VariablesView(input, width, height / 3);
		myView.getChildren().addAll(myBasicCommands, myUDCommands,
				myVariablesView);
		this.getChildren().add(myView);

	}

	public void update(CommandsList commandsList, VariablesList variablesList) {
		myBasicCommands.update(commandsList);
		myUDCommands.update(commandsList);
		myVariablesView.update(variablesList);
	}
}
