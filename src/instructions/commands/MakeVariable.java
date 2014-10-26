package instructions.commands;

import error_checking.ErrorDialog;
import error_checking.InvalidArgumentsException;
import model.ObservableData;
import model.VariablesList;
import instructions.BinaryInstruction;
import instructions.Instruction;
import instructions.VariableInstruction;


// NEED TO MAKE THIS CLASS
public class MakeVariable extends BinaryInstruction {

    /**
	 * 
	 */
    private static final long serialVersionUID = -3545647644856338247L;
    private static final String PARAMETER_TYPE =
            "PARAMETER NOT A VARIABLE";

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        VariablesList varList = (VariablesList) data.get("VariablesList");

        if (!(super.myParams.get(0) instanceof VariableInstruction)) {
            new ErrorDialog(PARAMETER_TYPE);
            throw new InvalidArgumentsException(PARAMETER_TYPE, this.getClass().getCanonicalName());
        }

        VariableInstruction var = (VariableInstruction) super.myParams.get(0);
        Instruction value = super.myParams.get(1);
        double doubleValue = value.execute(data);
        varList.add(var.getName(), doubleValue);
        return doubleValue;
    }

}
