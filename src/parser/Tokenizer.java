package parser;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Splits the instruction string into
 * string tokens. Does syntax error checking
 * along the way.
 *
 */
public class Tokenizer {

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
