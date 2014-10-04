package view;

import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public abstract class View {

	/**
	 * build the place where turtle moves and lines are drawn.
	 * @return
	 */
	protected abstract Pane pane();
	
	/**
	 * build the place where all the command and user-defined commands are shown
	 * @return
	 */
	protected abstract TableView commandTable();
	
	/**
	 * build the place where all the history inputs and output values are shown
	 * @return
	 */
	protected abstract FlowPane displayArea();
	
	/**
	 * build the area where user input commands.
	 * @return
	 */
	protected abstract TextArea inputTextArea();
	
	/**
	 * build the menu bar above the user interface 
	 * @return
	 */
	protected abstract MenuBar menuBar();
	
	/**
	 * set the controller of the view
	 * @param controller: bridges the view and the model
	 */
	public void setController(Controller controller){
		myController=controller;
	}
	
	public Controller getController(){
		return myController;
	}
	
	
}
