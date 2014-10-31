// This entire file is part of my masterpiece.
// Jennie Ju (jsj18)

package parser;

import instructions.ConstantInstruction;
import instructions.Instruction;
import instructions.VariableInstruction;

import java.io.Serializable;
import java.util.ResourceBundle;

import model.CommandsList;
import model.ObservableData;
import error_checking.InvalidArgumentsException;


/**
 * Factory design pattern for creating instances of different instructions
 *
 * @author Jennie Ju
 */
public class InstructionFactory implements Serializable {
    private static final long serialVersionUID = -2129488091762474882L;
    
    private static final String UNKNOWN_INSTR_KEY = "UnknownInstr";
    
    private static final String CONSTANT_KEY = "Constant";
    private static final String VARIABLE_KEY = "Variable";
    private static final String COMMAND_KEY = "Command";

    private ResourceBundle myLanguageBundle;
    private ResourceBundle myDisplayBundle;
    private ObservableData myData;

   /**
    * InstructionFactory constructor
    * @param data - ObservableData passed from Parser
    * @param locale - Sets current language for determining instruction regexes in resources for
    */
    public InstructionFactory (ObservableData data, 
    		ResourceBundle languageBundle, ResourceBundle displayBundle) {
        myLanguageBundle = languageBundle;
        myDisplayBundle = displayBundle;
        myData = data;
    }

    /**
     * Takes a string type of instruction and instantiates the class based on
     * the type (constant, variable, or command)
     * 
     * @param type - String name indicating type of instruction based on regexes
     * @return Instruction class of that type
     */
    public Instruction makeInstruction (String type) throws InvalidArgumentsException {
        type = type.toLowerCase();

        if (type.matches(myLanguageBundle.getString(CONSTANT_KEY))) {
            double value = Double.parseDouble(type);
            return new ConstantInstruction(value);
        }
        else if (type.matches(myLanguageBundle.getString(VARIABLE_KEY))) {
            return new VariableInstruction(type);
        }
        else if (type.matches(myLanguageBundle.getString(COMMAND_KEY))) {
            CommandsList allCommands = (CommandsList) myData.get("CommandsList");
            return allCommands.get(type);
        }
        else {
            throw new InvalidArgumentsException(myDisplayBundle.getString(UNKNOWN_INSTR_KEY),type);
        }
    }
}
