package view;

import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HistoryView extends SideView {


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
