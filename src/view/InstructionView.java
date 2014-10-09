package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InstructionView extends TableView<InstructionsOnView> {

	private static final double width = 200;
	private static final double height = 600;
	private final ObservableList<InstructionsOnView> instructions =
	        FXCollections.observableArrayList(
	                new InstructionsOnView("Forward", ""),
	                new InstructionsOnView("Backward", ""));

	public InstructionView() {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
		setMaxSize(width, height);

		TableColumn instrCol = new TableColumn("Instructions");
		instrCol.setMinWidth(130);
		instrCol.setCellValueFactory(new PropertyValueFactory("instructions"));
		
		
        TableColumn UDCol = new TableColumn("UDF");
		UDCol.setMinWidth(80);
		instrCol.setCellValueFactory(new PropertyValueFactory<InstructionsOnView, 
				String>("deleteButton"));
        
		this.setItems(instructions);
		getColumns().setAll(instrCol, UDCol);

	}
}
