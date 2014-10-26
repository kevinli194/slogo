package view;

import java.util.List;

import model.CommandsList;

public class UDCommandsView extends DataViewComponents {

	public UDCommandsView(InputView input, double width, double height) {
		super(input, width, height);
		// TODO Auto-generated constructor stub
	}

	public void update(CommandsList commandsList) {
		myView.getChildren().clear();
		addLable("User Defined Commands:");
		List<String[]> instructions = commandsList.generate();
		for (String s : instructions.get(1)) {
			addTextBoxWithDeleteButton(s, commandsList);
		}

	}

}
