package view;

import javafx.geometry.Pos;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * The view that displays the latest command return value
 * @author Kevin Li
 *
 */
public class ResultsView extends TilePane {

	private static final long serialVersionUID = -5066855452604866278L;
	Text myResults;

	/**
	 * Create the ResultsView
	 * @param width width of the view
	 * @param height height of the view
	 */
	public ResultsView(double width, double height) {
		setPrefSize(width * 1 / 5, height * 11 / 16);
		myResults = new Text();
		myResults.setFont(Font.font("Verdana", 16));
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
