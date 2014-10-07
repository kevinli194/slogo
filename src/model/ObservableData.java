package model;

import java.util.List;
import java.util.Map;

import Instructions.Instruction;
//import Instructions.Instruction;
import javafx.scene.Group;
import javafx.scene.shape.Line;


public class ObservableData {
    private Turtle myTurtle;
    private Group myDrawing;

    private List<String> myHistory;
    private Map<String, Instruction> myVariables;
    private Map<String, Instruction> myBasicInstructions;
    private Map<String, Instruction> myUserDefinedInstructions;

    // Instantiates all instance variables to default values.
    public ObservableData () {
    }


    // add new user defined variable to myVariables.
    public void addVariable (String variableName, Instruction value) {
    }

    public void deleteInstruction (String instructionName) {

    }

    public void deleteVariable (String variableName) {

    }

    // Adds a line to myDrawing.
    public void addLine (Line line) {

    }

}
