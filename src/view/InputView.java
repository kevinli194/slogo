package view;

import java.util.Locale;
import java.util.ResourceBundle;
import error_checking.InvalidArgumentsException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import model.SlogoModel;

public class InputView extends PaneView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2499477403984792589L;
	public static final String DEFAULT_DISPLAY_RESOURCE = "resources.languages/Display";

	public HBox myView;
	private TextArea myInput;
	private Button mySubmitButton;
	private SlogoModel myModel;
	private String myText = "";
	private Locale myLocale;

	public InputView(SlogoModel model, double width, double height, Locale locale) {
		myModel = model;
		myLocale=locale;
		myView = new HBox();
		myView.setPrefSize(width, height * 1 / 4);
		setView(width, height * 1 / 4);
		initInputArea(width, height);
		initSubmitButton(width, height);
		myView.getChildren().addAll(myInput, mySubmitButton);
		this.getChildren().add(myView);
	}

	private void initInputArea(double width, double height) {
		myInput = new TextArea();
		myInput.setPrefSize(width * 7 / 8, height * 1 / 4);
		myInput.setMaxSize(width * 7 / 8, height * 1 / 4);
	}

	private void initSubmitButton(double width, double height) {
		mySubmitButton = new Button();
		ResourceBundle languageBundle = ResourceBundle.getBundle(DEFAULT_DISPLAY_RESOURCE, myLocale);
		mySubmitButton.setText(languageBundle.getString("Submit"));
		mySubmitButton.setPrefSize(width * 1 / 8, height * 1 / 4);
		mySubmitButton.setMaxSize(width * 1 / 8, height * 1 / 4);
		mySubmitButton.setMinSize(width * 1 / 8, height * 1 / 4);
		mySubmitButton.setOnAction(new EventHandler<ActionEvent>() {
			// give the string to the back-end parser
			@Override
			public void handle(ActionEvent event) {
                try {
                    myModel.parseAndExecute(myInput.getText());
                }
                catch (InvalidArgumentsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
				myInput.clear();

			}

		});
	}

	public void addAndShowText(String text) {
		myText = myInput.getText();
		if (!myText.trim().equals(""))
			myText += "\n" + text.trim();
		else
			myText += text.trim();

		myInput.clear();
		myInput.setText(myText);
	}

	public void update(Node node) {
	}

}
