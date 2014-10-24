package view;

import java.util.List;

public class CommandsView extends SideView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7295555317903571842L;

	public CommandsView(InputView input, double width, double height) {
		super(input, width, height);
	}

	public void update(List<String[]> instructions) {
		myView.getChildren().clear();
		for (String s : instructions.get(0)) {
			addTextBox(s);
		}
		for (String s : instructions.get(1)) {
			addTextBoxWithDeleteButton(s);
		}
	}

}
