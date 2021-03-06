package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.Instruction;
import instructions.UnaryInstruction;
import model.ObservableData;
import model.Turtle;


/**
 * Implements the backward command.
 * Moves turtle backward an amount specified by the first argument.
 * 
 * @author Sandy Lee
 * 
 */
public class Backward extends UnaryInstruction {


    private static final long serialVersionUID = -4282136336006076328L;

    @Override
    public double execute (ObservableData od) throws InvalidArgumentsException {
        double amount = 0;
        for (Instruction parameter : super.myParams) {
            amount = parameter.execute(od);
        }
        Turtle myTurtle = od.getTurtle();
        myTurtle.moveTurtleAndDrawLine(-amount);
        return amount;
    }
}
