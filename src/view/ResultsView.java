package view;

import javafx.geometry.Pos;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * The view that displays the latest command return value.
 * @author Kevin Li
 *
 */
public class ResultsView extends TilePane {
	
	private static final long serialVersionUID = -5066855452604866278L;
	private static final int FONT_SIZE = 16;
	private static final double VIEW_HEIGHT_RATIO = 0.6875;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private Text myResults;

	/**
	 * Create the ResultsView.
	 * @param width width of the view
	 * @param height height of the view
	 */
	public ResultsView(double width, double height) {
		setPrefSize(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		myResults = new Text();
		myResults.setFont(Font.font("Verdana", FONT_SIZE));
		this.getChildren().add(myResults);
		this.setAlignment(Pos.CENTER);

	}

	/**
	 * Update as part of Observer. Update when the Observable data changes
	 * @param result The result shown as commands return value
	 */
	public void update(String result) {
		myResults.setText(result);

	}

}
