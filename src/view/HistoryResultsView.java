package view;

import java.util.List;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class HistoryResultsView extends PaneView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7573295502363922006L;
	HistoryView myHistory;
	ResultsView myResults;
	VBox myView;

	public HistoryResultsView(InputView input, double width, double height) {
		super.setView(width * 1 / 5, height * 11 / 16);
		myView = new VBox();
		myView.setPrefSize(width * 1 / 5, height * 11 / 16);

		myHistory = new HistoryView(input, width, height * 2 / 3);
		myResults = new ResultsView(width, height * 1 / 6);
		TitledPane t1 = new TitledPane("History", myHistory);
		TitledPane t2 = new TitledPane("Calculated Result :", myResults);
		t1.setCollapsible(false);
		t2.setCollapsible(false);
		t1.setPrefSize(width * 1 / 6, height * 11 / 16);
		t2.setPrefSize(width * 1 / 6, height * 11 / 16);
		myView.getChildren().add(t1);
		myView.getChildren().add(t2);
		this.getChildren().add(myView);
	}

	public void update(List<String> history, String result) {
		myHistory.update(history);
		myResults.update(result);

	}
}
