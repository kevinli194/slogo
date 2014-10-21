package view;

import java.util.List;

public class HistoryView extends SideView {

	private static final double HISTORYVIEW_WIDTH = 200;
	private static final double HISTORYVIEW_HEIGHT = 600;

	public HistoryView(InputView input) {
		super(input);
	}

	/**
	 * Takes the data structure for history and converts it into display
	 * elements to be displayed on the view. *
	 * 
	 * @param history
	 *            List of strings containing the history of the program.
	 */
	public void update(List<String> history) {
		myView.getChildren().clear();
		for (String i : history) {
			addTextBox(i);
		}
	}

	// Duplicated code as in InstructionList. Refactor after combining model to
	// view;

}
