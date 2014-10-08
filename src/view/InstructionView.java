package view;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InstructionView extends TableView<Button> {

	private static final double width = 200;
	private static final double height = 600;

	public InstructionView() {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
		setMaxSize(width, height);

		// TableView<String> table = new TableView<String>();
		// table.setItems(commands);
		// TableColumn<String,String> firstNameCol = new
		// TableColumn<String,String>("Command Name");
		// firstNameCol.setCellValueFactory();
		// table.getColumns().setAll(firstNameCol);

	}
}
