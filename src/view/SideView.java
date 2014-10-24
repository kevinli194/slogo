package view;

import java.io.Serializable;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class SideView extends ScrollPane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3594461139193098537L;
	private static final int INSTRUCTION_FONT_SIZE = 12;
	private static final int DELETE_BUTTON_X = 100;
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

	private Text makeClickableText(String s) {
		Text t = new Text(s+"\n");
		t.setFont(new Font(INSTRUCTION_FONT_SIZE));
		t.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				myInput.addAndShowText(s);
			}
		});
		return t;
	}
	
	public void addTextBoxWithDeleteButton(String s) {
		HBox h = new HBox();
		Text t = makeClickableText(s);
		Button delete=makeDeleteButton();
		h.getChildren().addAll(t,delete);
		myView.getChildren().add(h);
	}

	private Button makeDeleteButton() {
		Button b=new Button();
		b.setText("delete");
		b.setTranslateX(DELETE_BUTTON_X);
		b.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				myView.getChildren().remove(b.getParent());
			}
			
		});
		return b;
	}
	
	
	
}
