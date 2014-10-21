package view;

import model.SlogoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SettingsView extends Pane {
	private static final double SETTINGSVIEW_WIDTH = 1000;
	private static final double SETTINGSVIEW_HEIGHT = 25;

	private HBox mySettings;

	public SettingsView(SlogoModel model, TurtleView view) {

		setPrefWidth(SETTINGSVIEW_WIDTH);
		setPrefHeight(SETTINGSVIEW_HEIGHT);
		
		mySettings = new HBox();
		this.getChildren().add(mySettings);

		addButtons(model);
		changeBackgroundColor(view);

	}

	private void changeBackgroundColor(TurtleView view) {
		ObservableList<String> options = FXCollections.observableArrayList(
				"Black", "Red", "Blue", "Green");
		ComboBox<String> colorOptions = new ComboBox<String>(options);
		mySettings.getChildren().add(colorOptions);

		colorOptions.setOnAction((event) -> {
			String selectedColor = colorOptions.getSelectionModel()
					.getSelectedItem();
			view.changeColor(selectedColor);

		});
	}

	private void addButtons(SlogoModel model) {
		Button load=makeButton("Load", handle->model.load()); 
		Button move=makeButton("Move",handle->model.testThings());
		Button clear=makeButton("Clear",handle->model.clear());
		Button turtleInfo=makeButton("Show/Hide Info", handle->model.changeInfoVis());
		Button help=makeButton("HelpPage", handle->model.accessHelpHTML());
		mySettings.getChildren().addAll(load,move,clear,turtleInfo,help);
	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}

}