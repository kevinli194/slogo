package view;

import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class CommandTable extends TableView implements Observer{

	private static final double width=200;
	private static final double height=600;
	
	public CommandTable(){
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
		setMaxSize(width, height);
		
//		TableView<String> table = new TableView<String>();
//		table.setItems(commands);
//		TableColumn<String,String> firstNameCol = new TableColumn<String,String>("Command Name");
//		firstNameCol.setCellValueFactory();
//		table.getColumns().setAll(firstNameCol);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
