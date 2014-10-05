package model;

import java.util.List;
import java.util.Map;

import javafx.scene.Group;

public class Environment {
	private Turtle myTurtle;
	private Group myDrawing;
	private Map<String, Instructions> myHistory;
	private Map<String, Integer> myVariables;
	private Map<String, Instructions> myBasicCommands;
	private Map<String, Instructions> myUserDefinedCommands;

	public void addInstructions(Instructions instruction) {
	}

	public void addVariable(int variable) {

	}
}
