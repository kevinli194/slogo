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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SettingsView extends Pane {

	private HBox mySettings;

	public SettingsView(SlogoModel model, TurtleView view) {

		this.setPrefWidth(1000);
		this.setPrefHeight(25);
		mySettings = new HBox();
		this.getChildren().add(mySettings);
		mySettings.getChildren().add(
				makeButton("Load", new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						model.load();
					}
				}));
		mySettings.getChildren().add(
				makeButton("Move", new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						model.testThings();
					}
				}));
		mySettings.getChildren().add(
				makeButton("Clear", new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						model.clear();
					}
				}));


		// Combo box that lets you change color of the background
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

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}

}