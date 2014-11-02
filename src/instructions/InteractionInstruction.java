// This entire file is part of my masterpiece. 
// SANDY

package instructions;

import model.ObservableData;
import model.VariablesList;
import error_checking.InvalidArgumentsException;

/**
 * Super class for user interaction (mouse click) commands
 * 
 * @author SandyLee
 */


public class InteractionInstruction extends BinaryInstruction {
    /**
     * 
     */
    private static final long serialVersionUID = -7708851534217808268L;

    @Override
    public double execute (ObservableData data) throws InvalidArgumentsException {
        return myNumParams;

    }

    public void setVariable (ObservableData data, UserDefinedCommand command)
                                                                             throws InvalidArgumentsException {
        VariablesList varList = (VariablesList) data.get("VariablesList");
        
        //repetitive code below could have been avoided, but I decided not to create a 
        //separate command to avoid duplicate code because it would take in too many parameters.
        
        VariableInstruction var1 = new VariableInstruction("x");
        varList.add(var1.getName(), command.myParams.get(0).execute(data));
        VariableInstruction var2 = new VariableInstruction("y");
        varList.add(var2.getName(), command.myParams.get(1).execute(data));
    }


}
