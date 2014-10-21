package view;

import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public abstract class SideView extends ScrollPane {

	private static final double SIDEVIEW_WIDTH = Screen.getPrimary()
			.getVisualBounds().getWidth()
			* 1 / 5 * 3 / 4;
	private static final double SIDEVIEW_HEIGHT = Screen.getPrimary()
			.getVisualBounds().getHeight()
			* 11 / 16 * 4 / 5;
	private InputView myInput;
	protected VBox myView;

	public SideView() {
	}

	public SideView(InputView input) {
		myInput = input;
		myView = new VBox();
		setView(SIDEVIEW_WIDTH, SIDEVIEW_HEIGHT);
		this.setContent(myView);
	}

	public void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
	}

	public void addTextBox(String s) {
		HBox h = new HBox();
		Text t = new Text(s);
		h.getChildren().add(t);

		t.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				myInput.addAndShowText(s);
			}
		});
		myView.getChildren().add(h);
	}
}
