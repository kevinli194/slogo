package instructions;

import error_checking.InvalidArgumentsException;
import model.ObservableData;
import model.VariablesList;


/**
 * Class to create variable instructions
 * 
 * @author Jennie Ju, Sandy Lee
 *
 */
public class VariableInstruction extends UserDefinedInstruction {

    private static final long serialVersionUID = -197584065175920865L;

    /**
     * @param name of the variable instruction
     */
    public VariableInstruction (String name) {
        super(name);
    }

    /**
     * Gets value of variable from VariablesList
     * 
     * @param data of observables
     * @throws InvalidArgumentsException throws when there is wrong argument.
     */
    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        VariablesList varList = (VariablesList) data.get("VariablesList");
        return varList.get(super.myName);
    }

}
