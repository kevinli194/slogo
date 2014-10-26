package view;

import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * The abstract class which is the super class of HistoryResults View and 
 * DataView class.
 * @author Mengen Huang
 * @author Kevin Li
 *
 */
public abstract class ScrollView extends ScrollPane {

	private static final int INSTRUCTION_FONT_SIZE = 12;
	private InputView myInput;
	protected VBox myView;

	public ScrollView() {
	}

	/**
	 * Set up the ScrollView
	 * @param input InputView
	 * @param width width of the view
	 * @param height height of the view
	 */
	public ScrollView(InputView input, double width, double height) {
		myInput = input;
		myView = new VBox();
		setView(width * 1 / 5, height * 11 / 16);
		this.setContent(myView);
	}

	/**
	 * Set up the size of the view
	 * @param width width of the view
	 * @param height height of the view
	 */
	public void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

	/**
	 * Take in a string and add the String as a HBox
	 * @param s String displayed
	 */
	public void addTextBox(String s) {
		HBox h = new HBox();
		Text t = makeClickableText(s);
		h.getChildren().add(t);
		myView.getChildren().add(h);
	}

	/**
	 * Take in a string and make it into a clickable Text
	 * @param s String displayed
	 * @return the clickable text
	 */
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