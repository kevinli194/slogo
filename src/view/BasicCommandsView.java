package view;

import java.util.List;
import model.CommandsList;

/**
 * Visual component that displays the instructions that pre-exist within the
 * program.
 * @author Kevin Li
 * @author Meng'en Huang
 */
public class BasicCommandsView extends DataViewComponents {

	/**
	 * Basic Commands View extending super class DataViewComponents.
	 * @param input Input view
	 * @param width width of the view
	 * @param height height of the view
	 */
	public BasicCommandsView(InputView input, double width, double height){
		super(input, width, height);
	}

	/**
	 * Updates the view based on the command list from the model.
	 * @param commandsList Data from the model that stores the commands
	 */
	public void update(CommandsList commandsList) {
		myView.getChildren().clear();
		List<String[]> instructions = commandsList.generate();
		for (String s : instructions.get(0)) {
			addTextBox(s);
		}
	}

}
