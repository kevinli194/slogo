package view;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

/**
 * Visual Component containing the subcomponents that displays the history and
 * the calculated results.
 * @author Kevin Li
 * @author Mengen Huang
 *
 */
public class HistoryResultsView extends PaneView {

	private static final String DEFAULT_DISPLAY_RESOURCE = "resources.languages/Display";
	private static final double WIDTH_RATIO=0.2;
	private static final double HEIGHT_RATIO=0.6875;
	private static final double HISTORYVIEW_HEIGHT_RATIO=0.666667;
	private static final double RESULTVIEW_HEIGHT_RATIO=0.166667;
	private static final double TITLEDPANE_WIDTH_RATIO=0.166667;
	private static final double TITLEDPANE_HEIGHT_RATIO=0.6875;




	private HistoryView myHistory;
	private ResultsView myResults;
	private VBox myView;
	private Locale myLocale;

	/**
	 * Initiate the History Results View. 
	 * @param input Input View
	 * @param width width of the view
	 * @param height height of the view
	 * @param locale language and locale the view uses
	 */
	public HistoryResultsView(InputView input, double width, double height,
			Locale locale) {
		super.setView(width * WIDTH_RATIO, height * HEIGHT_RATIO);
		myLocale = locale;
		myView = new VBox();
		myView.setPrefSize(width * WIDTH_RATIO, height * HEIGHT_RATIO);

		myHistory = new HistoryView(input, width, height * HISTORYVIEW_HEIGHT_RATIO);
		myResults = new ResultsView(width, height * RESULTVIEW_HEIGHT_RATIO);
		ResourceBundle languageBundle = ResourceBundle.getBundle(
				DEFAULT_DISPLAY_RESOURCE, myLocale);
		TitledPane t1 = new TitledPane(languageBundle.getString("History"),
				myHistory);
		TitledPane t2 = new TitledPane(
				languageBundle.getString("CalculatedResult"), myResults);
		t1.setCollapsible(false);
		t2.setCollapsible(false);
		t1.setPrefSize(width * TITLEDPANE_WIDTH_RATIO, 
						height * TITLEDPANE_HEIGHT_RATIO);
		t2.setPrefSize(width * TITLEDPANE_WIDTH_RATIO, 
						height * TITLEDPANE_HEIGHT_RATIO);
		myView.getChildren().add(t1);
		myView.getChildren().add(t2);
		this.getChildren().add(myView);
	}

	/**
	 * Calls the update function in the subcomponents in order to update the
	 * view based off model data.
	 * @param history
	 *            List of the runnable history that has been entered into
	 *            the input area.
	 * @param result
	 *            The result from the last instruction.
	 */

	public void update(List<String> history, String result) {
		myHistory.update(history);
		myResults.update(result);

	}
}
