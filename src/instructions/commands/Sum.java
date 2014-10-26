package instructions.commands;

import error_checking.InvalidArgumentsException;
import instructions.BinaryInstruction;
import instructions.Instruction;
import model.ObservableData;


public class Sum extends BinaryInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2910753621943189298L;

	@Override
    public double execute (ObservableData data) throws InvalidArgumentsException{
        // TODO Auto-generated method stub
        double sum = 0;
        for (Instruction parameter : super.myParams) {
            sum += parameter.execute(data);

        }
        return sum;

    }
}
