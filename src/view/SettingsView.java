package view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToolBar;
import model.SlogoModel;

public class SettingsView extends ToolBar {
	ColorPicker myColorPicker;

	public SettingsView(SlogoModel model, TurtleView view, double width,
			double height) {
		myColorPicker = new ColorPicker();
		setView(width, height);
		addButtons(model);
		addColorPicker(view);
	}

	private void setView(double width, double height) {
		setPrefSize(width, height * 1 / 16);
	}

	private void addColorPicker(TurtleView view) {
		myColorPicker.setOnAction(new EventHandler() {
			public void handle(Event t) {
				view.changeColor(myColorPicker.getValue());
			}
		});
		this.getItems().add(myColorPicker);

	}

	private void addButtons(SlogoModel model) {
		Button load = makeButton("Load", handle -> model.load());
		Button move = makeButton("Move", handle -> model.testThings());
		Button clear = makeButton("Clear", handle -> model.clear());
		Button turtleInfo = makeButton("Show/Hide Info",
				handle -> model.changeInfoVis());
		Button help = makeButton("HelpPage", handle -> model.accessHelpHTML());
		this.getItems().addAll(load, move, clear, turtleInfo, help);

	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}

}