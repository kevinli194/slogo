package parser;

import java.util.Stack;

import Instructions.Instruction;

/**
 * Parser for converting strings of instructions
 * into stacks of executable instructions.
 * 
 * General format for parsing:
 * - Uses two stacks: one for holding double values
 * from instruction returns while parsing the string
 * and one to return all instructions to the model
 * 
 * - Takes a string input into the parse method
 * - Tokenizes the string using the Tokenizer class
 * - Iterates through string tokens in reverse order 
 * to create Instruction classes with the InstructionFactory
 * - For each instruction, checks to see how many inputs 
 * are needed for the instruction
 * - Pops from double value stack if inputs are needed
 * - Evaluates instruction for double value
 * - Pushes evaluated value back to double value stack
 * - Adds the instruction to a stack of instructions
 * to be exectuted in the Model class
 * 
 * - Error checks syntax throughout parsing
 */
public class Parser {

	/**
	 * Parses a string instruction input passed in through Model.
	 * Makes use of the Tokenizer to split the string into tokens.
	 * @param input String of instructions
	 * @return stack of instructions to run (used in Model)
	 */
	public Stack<Instruction> parse(String input) {
		return null;
	}

}
