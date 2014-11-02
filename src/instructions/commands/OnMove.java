// This entire file is part of my masterpiece. 
// SANDY

package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.InteractionInstruction;
import instructions.UserDefinedCommand;
import model.ObservableData;

/**
 * If OnMove command is defined by the user, this class will execute the OnClick command 
 * with the mouse's x and y coordinates as arguments.
 * 
 * @author SandyLee
 */


public class OnMove extends InteractionInstruction {

    private static final long serialVersionUID = 1L;

    public double execute (ObservableData data) throws InvalidArgumentsException {
        UserDefinedCommand command = (UserDefinedCommand) data.get("onmove");
        super.setVariable(data, command);
        return command.execute(data);
    }
}
