package parser;

import error_checking.ErrorDialog;
import error_checking.InstructionDefineException;
import instructions.ConstantInstruction;
import instructions.Instruction;
import instructions.VariableInstruction;
import java.io.Serializable;
import java.util.ResourceBundle;
import model.CommandsList;
import model.ObservableData;


/**
 * Factory design pattern for creating instances of different instructions
 *
 * @author Jennie Ju
 */
public class InstructionFactory implements Serializable {
    private static final long serialVersionUID = -2129488091762474882L;
    private static final String CONSTANT_REGEX = "-?[0-9]+\\.?[0-9]*";
    private static final String VARIABLE_REGEX = ":[a-zA-z]+";
    private static final String COMMAND_REGEX = "[a-zA-Z_]+(\\?)?";
    public static final String CHINESE_REGEX = "[\u4e00-\u9fa5]+(\\?)?";
    private ResourceBundle myLanguageBundle;
    // DON'T KEEP THIS IN THIS MANNER (DISORGANIZED)
    private ObservableData myData;

    /**
     * @param data of observables
     */
    public InstructionFactory (ObservableData data) {
        myLanguageBundle = loadResourceBundle("resources.languages/English");
        myData = data;

    }

    /**
     * @param filepath for the resource bundle
     * @return resource bundle
     */
    private ResourceBundle loadResourceBundle (String filepath) {
        return ResourceBundle.getBundle(filepath);
    }

    /**
     * Takes a string type of instruction and instantiates the class based on
     * the type
     * 
     * @param type String name of type of instruction
     * @return Instruction class of that type
     */
    public Instruction makeInstruction (String type) {
        type = type.toLowerCase();

        if (type.matches(CONSTANT_REGEX)) {
            double value = Double.parseDouble(type);
            return new ConstantInstruction(value);
        }
        else if (type.matches(VARIABLE_REGEX)) {
            return new VariableInstruction(type);
        }
        else if (type.matches(COMMAND_REGEX) || type.matches(CHINESE_REGEX)) {
            CommandsList allCommands = (CommandsList) myData.get("CommandsList");
            return allCommands.get(type);
        }
        new ErrorDialog("THERE IS NO SUCH INSTRUCTION");
        throw new InstructionDefineException("THERE IS NO SUCH INSTRUCTION.");
    }
}
