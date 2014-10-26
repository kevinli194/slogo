package view;

import java.util.List;
import model.CommandsList;

/**
 * 
 * @author Kevin Li
 * @author Meng'en Huang
 * 
 */
public class BasicCommandsView extends DataViewComponents {

	public BasicCommandsView(InputView input, double width, double height) {
		super(input, width, height);
		// TODO Auto-generated constructor stub
	}

	public void update(CommandsList commandsList) {
		myView.getChildren().clear();
		List<String[]> instructions = commandsList.generate();
		for (String s : instructions.get(0)) {
			addTextBox(s);
		}
	}

}
