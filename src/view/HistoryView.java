package view;

import java.util.List;

/**
 * Scrollable history that contains runnable commands that have been run
 * previously.
 * 
 * @author Kevin Li
 * @author Meng'en Huang
 *
 */

public class HistoryView extends ScrollView {

	public HistoryView(InputView input, double width, double height) {
		super(input, width, height);
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
}
