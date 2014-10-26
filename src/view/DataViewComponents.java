package view;

import error_checking.InvalidArgumentsException;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Feature;

/**
 * Abstract class used construct the dataview subcomponents.
 * 
 * @author Kevin Li
 *
 */
public abstract class DataViewComponents extends ScrollView {
	private static final int DELETE_BUTTON_X = 50;

	public DataViewComponents(InputView input, double width, double height) {
		super(input, width, height);
	}

	/**
	 * Creates a text box with delete buttons to be added to the view.
	 * 
	 * @param s
	 *            The string to be displayed in the textbox.
	 * @param f
	 *            The feature that things are to be deleted from in the model.
	 */
	protected void addTextBoxWithDeleteButton(String s, Feature f) {
		HBox h = new HBox();
		Text t = super.makeClickableText(s);
		Button delete = makeDeleteButton(s, f);
		h.getChildren().addAll(t, delete);
		myView.getChildren().add(h);
	}

	/**
	 * Makes a delete button.
	 * 
	 * @param s
	 *            The string representation of the variable or command.
	 * @param f
	 *            The feature to delete data from.
	 * @return Delete button
	 */
	private Button makeDeleteButton(String s, Feature f) {
		Button b = new Button();
		b.setText("delete");
		b.setTranslateX(DELETE_BUTTON_X);
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				myView.getChildren().remove(b.getParent());
				String key;
				if (f.getClass().getSimpleName().equals("CommandsList"))
					key = s;
				else
					key = ":" + s.split(":")[0].trim();
				System.out.println(key);
				try {
					f.remove(key);
				} catch (InvalidArgumentsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return b;
	}

}
