package view;

import javafx.geometry.Pos;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ResultsView extends TilePane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5066855452604866278L;
	Text myResults;

	public ResultsView(double width, double height) {
		setPrefSize(width * 1 / 5, height * 11 / 16);
		myResults = new Text();
		myResults.setFont(Font.font("Verdana", 16));
		this.getChildren().add(myResults);
		this.setAlignment(Pos.CENTER);

	}

	public void update(double result) {
		myResults.setText("" + result);

	}

}
