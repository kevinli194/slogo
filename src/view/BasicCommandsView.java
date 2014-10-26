package view;

import java.util.List;

import model.CommandsList;

public class BasicCommandsView extends DataViewComponents {

	public BasicCommandsView(InputView input, double width, double height) {
		super(input, width, height);
		// TODO Auto-generated constructor stub
	}

	public void update(CommandsList commandsList) {
		myView.getChildren().clear();
		List<String[]> instructions = commandsList.generate();
		addLable("Default Commands:");
		for (String s : instructions.get(0)) {
			addTextBox(s);
		}
	}

}
