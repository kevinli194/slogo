package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class InstructionView extends TableView<InstructionsOnView> {

	private static final double width = 200;
	private static final double height = 600;
	
//	private ObservableList<InstructionsOnView> myData;
	//Test Data
	private ObservableList<InstructionsOnView> myData = FXCollections.observableArrayList(
		    new InstructionsOnView("Forward", "No"),
		    new InstructionsOnView("Backward", "Delete")
		);
	
	@SuppressWarnings("unchecked")
	public InstructionView() {
		setPrefWidth(width);
		setPrefHeight(height);
		setMinSize(width, height);
		setMaxSize(width, height);

		updateColums();

	}

	private void updateColums() {

		TableColumn<InstructionsOnView, String> instrCol = new TableColumn<InstructionsOnView, String>("Instructions");
		instrCol.setMinWidth(120);
        TableColumn<InstructionsOnView, String> deleteCol = new TableColumn<InstructionsOnView, String>("UDI");
        deleteCol.setMinWidth(78);

        instrCol.setCellValueFactory(
        		new PropertyValueFactory<InstructionsOnView,String>("instruction")
        		);
        deleteCol.setCellValueFactory(
        		new PropertyValueFactory<InstructionsOnView,String>("deleteButton")
        		);
//		  *Test successful!
//        InstructionsOnView e=new InstructionsOnView("TurnRight","No delete");
//        myData.add(e);
        
        //Try to get the cell clickable
//        ((Node) instrCol.getCellFactory()).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				
//			}
//        	
//        }
//            );
        this.setItems(myData);
        this.getColumns().addAll(instrCol,deleteCol);

	}
	public void update() {
		//Get the instructions from the class which stores all the instructions
//		myData=Instructions.toObservableList();
	}
	
	
	        	
}
