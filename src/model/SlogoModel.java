package model;

import java.util.Observable;
import java.util.Stack;

import Instructions.Instruction;

public class SlogoModel extends Observable {

	public SlogoModel() {

	}

	// Calls readString to get a list of instructions. Then, runs the
	// executeCommands function to run.
	public void readStringAndExecuteCommands(String s) {

	}
	
	// Feeds the string to the parser to be read and converted into a stack of instructions.

	public void readString(String s) {

	}

	// Executes all of the instructions on the instance variable myEnvironment.
	// Then, it notifyObservers that myEnvironment has changed.
	public void executeCommands(Stack<Instruction> ParsedInstructions) {

	}
}
