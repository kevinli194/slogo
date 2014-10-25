package parser;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Splits the instruction string into
 * string tokens. Does syntax error checking
 * along the way.
 *
 */
public class Tokenizer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6777223435329788868L;

	/**
	 * Splits an input string into separate string tokens
	 * base on white spaces.
	 * Should also be able to implement error checking.
	 * @param s String of instructions
	 * @return List of string tokens
	 */
	public List<String> tokenize(String input) {
		String[] tokenArray = input.split("\\s+");
	
		return Arrays.asList(tokenArray);
	}

}
