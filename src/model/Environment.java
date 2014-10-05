package model;

import java.util.List;
import java.util.Map;
import Instructions.Instruction;
import javafx.scene.Group;

public class Environment {
	private Turtle myTurtle;
	private Group myDrawing;
	private Map<String, Instruction> myHistory;
	private Map<String, Integer> myVariables;
	private Map<String, Instruction> myBasicCommands;
	private Map<String, Instruction> myUserDefinedCommands;

	public void addInstructions(Instruction instruction) {
	}

	public void addVariable(int variable) {

	}
}
