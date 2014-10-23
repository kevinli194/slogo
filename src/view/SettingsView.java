package view;

import javafx.collections.ObservableList;
import model.BackgroundColor;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.SlogoModel;

public class SettingsView extends ToolBar {
	ColorPicker myColorPicker;
	SlogoModel myModel;

	public SettingsView(SlogoModel model, TurtleView view, double width,
			double height) {
		myModel = model;
		setView(width, height);
		addButtons(model);
		addColorPicker(view);
	}

	private void setView(double width, double height) {
		setPrefSize(width, height * 1 / 16);
	}

	private void addColorPicker(TurtleView view) {
		myColorPicker = new ColorPicker();
		myColorPicker.setStyle("-fx-color-label-visible: false ;");
		myColorPicker.setOnAction(new EventHandler() {
			public void handle(Event t) {
				view.changeColor(myColorPicker.getValue());
				((BackgroundColor) (myModel.getMyData().get("backgroundcolor")))
						.set(myColorPicker.getValue());
			}
		});
		myModel.initializeBGColor(getCustomColors());
		this.getItems().add(new Separator());
		this.getItems().add(new Text("Background Color: "));
		this.getItems().add(myColorPicker);
		this.getItems().add(new Separator());

	}

	private void addButtons(SlogoModel model) {
		Button load = makeButton("Load", handle -> model.load());
		Button move = makeButton("Move", handle -> model.testThings());
		Button clear = makeButton("Clear", handle -> model.clear());
		Button help = makeButton("HelpPage", handle -> model.accessHelpHTML());
		this.getItems().addAll(load, move, clear, help);

	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}

	public ObservableList<Color> getCustomColors() {
		ObservableList<Color> customColors = myColorPicker.getCustomColors();
		return customColors;
	}

}