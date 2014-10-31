// This entire file is part of my masterpiece.
// SANDY

package parser;

import error_checking.ErrorDialog;
import error_checking.InstructionDefineException;
import error_checking.InvalidArgumentsException;
import instructions.Instruction;
import instructions.ListInstruction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import model.ObservableData;


/**
 * Parser for converting strings of instructions into stacks of executable
 * instructions.
 * 
 * General format for parsing: - Uses two stacks: one for holding double values
 * from instruction returns while parsing the string and one to return all
 * instructions to the model
 * 
 * 
 * @author Jennie Ju, Sandy Lee
 */
public class Parser implements Serializable {
    private static final long serialVersionUID = 7476618255022085064L;
    private static final String PARAMETER_ERROR = "NOT ENOUGH PARAMETERS.";
    private ResourceBundle myLanguageBundle;
    private Tokenizer myTokenizer;
    private InstructionFactory myIFactory;

    /**
     * Constructor for a Parser. Creates a new instance of the Tokenizer.
     *
     * @param data of observables
     */
    public Parser (ObservableData data) {
        myTokenizer = new Tokenizer();
        myIFactory = new InstructionFactory(data);
    }

    /**
     * sets language bundle
     * 
     * @param bundle of resource
     */
    public void setLanguage (ResourceBundle bundle) {
        myLanguageBundle = bundle;
    }

    /**
     * Iterates through string tokens in reverse order to create
     * Instruction classes with the InstructionFactory
     * 
     * @param input string input to be parsed
     * @return a stack of instructions to be executed in the Model class
     * @throws InvalidArgumentsException throws when there is invalid parameter
     */
    public Stack<Instruction> parse (String input) throws InvalidArgumentsException {
        List<String> tokens = myTokenizer.tokenize(input);
        Collections.reverse(tokens);
        return parseTokens(tokens);
    }

    /**
     * Parses token and creates Instruction classes with the InstructionFactory
     * 
     * @param tokens to be parsed and created into instructions
     * @return stack of instructions
     * @throws InvalidArgumentsException throws when invalid parameters
     */
    private Stack<Instruction> parseTokens (List<String> tokens) throws InvalidArgumentsException {
        Stack<Instruction> builderStack = new Stack<Instruction>();
        Instruction instr;
        int iter = 0;
        while (iter < tokens.size()) {
            String token = tokens.get(iter);
            if (isRightBracket(token)) {
                int bracketInd = findMatchingBracket(tokens, iter);
                Stack<Instruction> listStack = parseTokens(tokens.subList(
                                                                          iter + 1, bracketInd));

                List<Instruction> lst = new ArrayList<Instruction>();

                while (!listStack.isEmpty()) {
                    Instruction current = listStack.pop();
                    lst.add(current);
                }

                instr = new ListInstruction(lst);

                iter = bracketInd;
            }
            else {

                instr = myIFactory.makeInstruction(token);
                addParams(instr, builderStack);
            }

            builderStack.push(instr);
            iter++;
        }
        return builderStack;
    }

    /**
     * @param token string
     * @return 1 if it is a right bracket, 0 otherwise
     */
    private boolean isRightBracket (String token) {
        return token.equals("]");
    }

    /**
     * @param token string
     * @return 1 if it is a left bracket, 0 otherwise
     */
    private boolean isLeftBracket (String token) {
        return token.equals("[");
    }

    /**
     * @param tokens of strings
     * @param openPos position of right bracket
     * @return position of matching left bracket
     */
    private int findMatchingBracket (List<String> tokens, int openPos) {
        int matchCounter = 0;
        int closePos = openPos;
        while (matchCounter >= 0 && closePos < (tokens.size() - 1)) {
            closePos++;
            String token = tokens.get(closePos);
            if (isRightBracket(token)) {
                matchCounter++;
            }
            else if (isLeftBracket(token)) {
                matchCounter--;
            }
        }

        if (matchCounter < 0) {
            return closePos;
        }
        else {
            new ErrorDialog("MISSING BRACKET");
            throw new InstructionDefineException("MISSING BRACKET.");
        }

    }

    /**
     * For each instruction, checks to see how many inputs are needed for the instruction - Pops
     * from
     * double value stack if inputs are needed -
     * 
     * @param instr instruction to add parameters to
     * @param iStack of parameters
     * @throws InvalidArgumentsException throws when there is not enough parameters
     */
    private void addParams (Instruction instr, Stack<Instruction> iStack)
                                                                         throws InvalidArgumentsException {
        if (instr.getNumParams() > iStack.size()) {
            new ErrorDialog(PARAMETER_ERROR);
            throw new InvalidArgumentsException(PARAMETER_ERROR, this.getClass().getCanonicalName());
        }
        int numParams = instr.getNumParams();
        for (int i = 0; i < numParams; i++) {
            instr.addParam(iStack.pop());
        }
    }

}
