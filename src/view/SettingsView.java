package view;

import model.SlogoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class SettingsView extends PaneView {
	private static final double SETTINGSVIEW_WIDTH = Screen.getPrimary()
			.getVisualBounds().getWidth() * 3 / 4;
	private static final double SETTINGSVIEW_HEIGHT = Screen.getPrimary()
			.getVisualBounds().getHeight()
			* 1 / 16 * 4 / 5;

	private ToolBar mySettings;

	public SettingsView(SlogoModel model, TurtleView view) {
		setView(SETTINGSVIEW_WIDTH, SETTINGSVIEW_HEIGHT);
		mySettings = new ToolBar();
		mySettings.setPrefSize(SETTINGSVIEW_WIDTH, SETTINGSVIEW_HEIGHT);
		addButtons(model);
		changeBackgroundColor(view);
		this.getChildren().add(mySettings);

	}

	private void changeBackgroundColor(TurtleView view) {
		ObservableList<String> options = FXCollections.observableArrayList(
				"Black", "Red", "Blue", "Green");
		ComboBox<String> colorOptions = new ComboBox<String>(options);
		mySettings.getItems().add(colorOptions);

		colorOptions.setOnAction((event) -> {
			String selectedColor = colorOptions.getSelectionModel()
					.getSelectedItem();
			view.changeColor(selectedColor);

		});
	}

	private void addButtons(SlogoModel model) {
		Button load = makeButton("Load", handle -> model.load());
		Button move = makeButton("Move", handle -> model.testThings());
		Button clear = makeButton("Clear", handle -> model.clear());
		Button turtleInfo = makeButton("Show/Hide Info",
				handle -> model.changeInfoVis());
		Button help = makeButton("HelpPage", handle -> model.accessHelpHTML());
		mySettings.getItems().addAll(load, move, clear, turtleInfo, help);

	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}

}