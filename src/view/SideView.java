package view;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public abstract class SideView extends ScrollPane {

	private static final int INSTRUCTION_FONT_SIZE = 12;
	private InputView myInput;
	protected VBox myView;

	public SideView() {
	}

	public SideView(InputView input, double width, double height) {
		myInput = input;
		myView = new VBox();
		setView(width * 1 / 5, height * 11 / 16);
		this.setContent(myView);
	}

	public void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

	public void addTextBox(String s) {
		HBox h = new HBox();
		Text t = makeClickableText(s);
		h.getChildren().add(t);
		myView.getChildren().add(h);
	}

	protected Text makeClickableText(String s) {
		Text t = new Text(s + "\n");
		t.setFont(new Font(INSTRUCTION_FONT_SIZE));
		t.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				myInput.addAndShowText(s);
			}
		});
		return t;
	}

}