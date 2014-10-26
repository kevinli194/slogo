package parser;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


/**
 * Splits the instruction string into
 * string tokens.
 * 
 * @author Jennie Ju, Sandy Lee
 *
 */
public class Tokenizer implements Serializable {
    private static final long serialVersionUID = -6777223435329788868L;

    /**
     * Splits an input string into separate string tokens
     * base on white spaces.
     * 
     * @param input String of instructions
     * @return List of string tokens
     */
    public List<String> tokenize (String input) {
        String[] tokenArray = input.split("\\s+");
        return Arrays.asList(tokenArray);
    }

}
