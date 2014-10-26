package view;

import instructions.ConstantInstruction;
import instructions.Instruction;
import instructions.UserDefinedCommand;
import instructions.VariableInstruction;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import error_checking.ErrorDialog;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.BackgroundColor;
import model.CommandsList;
import model.History;
import model.ObservableData;
import model.SlogoModel;
import model.VariablesList;

public class SlogoWindow extends BorderPane implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4532547099439124045L;
	KeyControls myControls;
	TurtleView myTurtleView;
	InputView myInputView;
	CommandsView myCommandsView;
	HistoryView myHistoryView;
	SettingsView mySettingsView;
	SlogoModel myModel;
	ObservableData myOD;
        private static final double DEFAULT_XCOORDINATE = 300;
        private static final double DEFAULT_YCOORDINATE = 150;

	public SlogoWindow(String language, double width, double height) {
		myModel = new SlogoModel();
		myModel.addObserver(this);
		myTurtleView = new TurtleView(width, height);
		myInputView = new InputView(myModel, width, height);
		myCommandsView = new CommandsView(myInputView, width, height);
		myHistoryView = new HistoryView(myInputView, width, height);
		mySettingsView = new SettingsView(myModel, myTurtleView, width, height);
		myOD = new ObservableData();

		setCenter(myTurtleView);
		setRight(myCommandsView);
		setBottom(myInputView);
		setLeft(myHistoryView);
		setTop(mySettingsView);
		setVisible(true);
		myModel.load();
		myControls = new KeyControls(myModel, this);
		
		onClickCommand();

	}

	@Override
	public void update(Observable o, Object arg) {

		if (!arg.equals(myOD)) {
			myOD = (ObservableData) arg;
		}

		myTurtleView.update((((ObservableData) arg).getTurtle()).generate());
		myCommandsView.update(
				((CommandsList) ((ObservableData) arg).get("CommandsList")),
				((VariablesList) ((ObservableData) arg).get("VariablesList")));
		myHistoryView.update(((History) ((ObservableData) arg).get("history"))
				.generate());
		myTurtleView.changeColor(((BackgroundColor) ((ObservableData) arg)
				.get("backgroundcolor")).generate());
		mySettingsView.changeBGPicked(((BackgroundColor) ((ObservableData) arg)
				.get("backgroundcolor")).generate());
		mySettingsView.changePenPicked(((ObservableData) arg).getTurtle()
				.getPen().getPenColor());
	}

	public SlogoModel getModel() {
		return myModel;
	}

	public void loadFile(History history) {
		myModel.getMyData().loadFile(history);
		
	}
	
	
	//TODO:error checking to only take two variables
	private void onClickCommand () {
            CommandsList commandsList = (CommandsList) myModel.getMyData().get("CommandsList");            
            myTurtleView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                @Override
                public void handle (MouseEvent mouseEvent) {
                    // TODO Auto-generated method stub
                    if (commandsList.contains("onclick"))
                    {
                        UserDefinedCommand current = (UserDefinedCommand) commandsList.get("onclick");
                        double[] coords = handleClickInstr(mouseEvent, current);
                        myModel.parseAndExecute("onclick " + Double.toString(coords[0]) +" " + Double.toString(coords[1]));

                    }

                }
            });
            
            myTurtleView.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {

                @Override
                public void handle (MouseEvent mouseEvent) {
                    // TODO Auto-generated method stub
                    if (commandsList.contains("onmove"))
                    {
                        UserDefinedCommand current = (UserDefinedCommand) commandsList.get("onmove");
                        double[] coords = handleClickInstr(mouseEvent, current);
                        myModel.parseAndExecute("onmove " + Double.toString(coords[0]) +" " + Double.toString(coords[1]));

                    }

                }
            });
            
   
          
              
              
              
        }
	
    public double[] handleClickInstr(MouseEvent mouseEvent, Instruction current){
	    double[] coords = new double[2];
	    coords[0] = mouseEvent.getX()- DEFAULT_XCOORDINATE;
            coords[1] = -mouseEvent.getY() + DEFAULT_YCOORDINATE;
            current.addParam(new ConstantInstruction(coords[0]));
            current.addParam(new ConstantInstruction(coords[1])); 
            return coords;
	}
	
	

}
