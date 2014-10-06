package parser;

import java.util.Collections;
import java.util.List;
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
	private Tokenizer tokenizer;
	private InstructionFactory iFactory;

	/**
	 * Parses a string instruction input passed in through Model.
	 * Makes use of the Tokenizer to split the string into tokens.
	 * @param input String of instructions
	 * @return stack of instructions to run (used in Model)
	 */

	/**
	 * Constructor for a Parser.
	 * Creates a new instance of the Tokenizer.
	 */
	public Parser() {
		tokenizer = new Tokenizer();
		iFactory = new InstructionFactory();
	}


	public Stack<Instruction> parse(String input) {
		// two stacks for parsing
		Stack<Instruction> result = new Stack<Instruction>();
		Stack<Instruction> builder = new Stack<Instruction>();

		// get tokens
		List<String> tokens = tokenizer.tokenize(input);

		// reverse list of tokens
		Collections.reverse(tokens);

		// iterate through tokens
		for (String token : tokens) {
			Instruction instr = iFactory.makeInstruction(token);
			// add parameters
			addParams(instr, builder);
			// add to both the builder stack and result stack
			builder.push(instr);
			result.push(instr);
		}

		return result;
	}

	private void addParams(Instruction instr, Stack<Instruction> iStack) {
		int numParams = instr.getNumParams();
		for (int i = 0; i < numParams; i++) {
			// Add error exceptions HERE
			
			
			instr.addParam(iStack.pop());
		}
	}

}
