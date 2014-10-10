package parser;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Instructions.Instruction;
import Instructions.ListInstruction;


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
	private ResourceBundle languageBundle;
	private Tokenizer tokenizer;
	private InstructionFactory iFactory;

	/**
	 * Constructor for a Parser.
	 * Creates a new instance of the Tokenizer.
	 */
	public Parser() {
		tokenizer = new Tokenizer();
		iFactory = new InstructionFactory();
	}

	public void setLanguage(ResourceBundle bundle) {
		languageBundle = bundle;
	}


	public Stack<Instruction> parse(String input) {
		// get tokens
		List<String> tokens = tokenizer.tokenize(input);
		// reverse list of tokens
		Collections.reverse(tokens);
		// parse tokens
		return parseTokens(tokens);
	}

	private Stack<Instruction> parseTokens (List<String> tokens) {
		// stack for parsing
		Stack<Instruction> builderStack = new Stack<Instruction>();
		Instruction instr;
		int iter = 0;
		while (iter < tokens.size()) {
			String token = tokens.get(iter);
			if (isRightBracket(token)) {
				// if right bracket found, find matching left bracket in subList
				List<String> subList = tokens.subList(iter + 1, tokens.size());
				int bracketInd = findMatchingBracket(subList);
				// Parse tokens contained in brackets
				Stack<Instruction> listStack = parseTokens(subList.subList(1, bracketInd));
				// Add listStack to new instance of a ListInstruction class
				instr = new ListInstruction(listStack);
				// update iterator
				iter = iter + bracketInd;
			}
			else {
				instr = iFactory.makeInstruction(token);
				// add parameters
				addParams(instr, builderStack);
			}
			// add to both the builder stack and result stack

			builderStack.push(instr);
			iter++;
		}
		return builderStack;
	}

	private boolean isRightBracket (String token) {
		return token.equals("]");
	}

	private boolean isLeftBracket (String token) {
		return token.equals("[");
	}

	private int findMatchingBracket (List<String> tokens) {
		int matchCounter = 0;
		int index = 0;
		while (matchCounter >= 0) {
			String token = tokens.get(index);
			if (isRightBracket(token)) {
				matchCounter++;
			}
			else if (isLeftBracket(token)) {
				matchCounter--;
			}
			index++;
		}
		return index;
	}

	private void addParams (Instruction instr, Stack<Instruction> iStack) {
		int numParams = instr.getNumParams();
		for (int i = 0; i < numParams; i++) {
			// Add error exceptions HERE
			instr.addParam(iStack.pop());
		}
	}

}
