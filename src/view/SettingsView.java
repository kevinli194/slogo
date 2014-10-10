package view;

import model.SlogoModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SettingsView extends Pane {

	private HBox mySettings;

	public SettingsView(SlogoModel model) {

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

	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}
}