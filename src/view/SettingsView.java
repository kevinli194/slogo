package view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.BackgroundColor;
import model.SlogoModel;

public class SettingsView extends ToolBar {
	ColorPicker myBGColor;
	ColorPicker myPenColor;
	SlogoModel myModel;

	public SettingsView(SlogoModel model, TurtleView view, double width,
			double height) {
		myModel = model;
		setView(width, height);
		addButtons(model);
		addBGColorPicker(view);
		addPenColorPicker();
	}

	private void setView(double width, double height) {
		setPrefSize(width, height * 1 / 16);
	}

	private void addBGColorPicker(TurtleView view) {
		myBGColor = new ColorPicker();
		myBGColor.setStyle("-fx-color-label-visible: false ;");
		myBGColor.setOnAction(new EventHandler() {
			public void handle(Event t) {
				view.changeColor(myBGColor.getValue());
				((BackgroundColor) (myModel.getMyData().get("backgroundcolor")))
						.set(myBGColor.getValue());
			}
		});
		myModel.initializeBGColor(getCustomColors(myBGColor));
		this.getItems().add(new Separator());
		this.getItems().add(new Text("Background Color: "));
		this.getItems().add(myBGColor);
		this.getItems().add(new Separator());

	}

	private void addPenColorPicker() {
		myPenColor = new ColorPicker();
		myPenColor.setStyle("-fx-color-label-visible: false ;");
		myPenColor.setOnAction(new EventHandler() {
			public void handle(Event t) {
				myModel.getMyData().getTurtle()
						.changePenColor(myPenColor.getValue());

			}
		});
		myModel.initializePenColor(getCustomColors(myPenColor));
		this.getItems().add(new Separator());
		this.getItems().add(new Text("Pen Color: "));
		this.getItems().add(myPenColor);
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

	public ObservableList<Color> getCustomColors(ColorPicker colorpicker) {
		ObservableList<Color> customColors = colorpicker.getCustomColors();
		return customColors;
	}

}