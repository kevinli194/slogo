package instructions;

import error_checking.InvalidArgumentsException;
import java.util.ArrayList;
import java.util.List;
import model.ObservableData;


/**
 * This represents the super class for instructions with lists
 *
 * @author Sandy Lee
 *
 */

public class ListInstruction extends ZeroParamInstruction {

    private static final long serialVersionUID = 8768754397704316762L;
    private List<Instruction> myInstructionList = new ArrayList<Instruction>();

    /**
     * Constructor for list instruction
     *
     * @param lst of instructions
     */

    public ListInstruction (List<Instruction> lst) {
        myInstructionList = lst;
    }

    /**
     * @return list of instructions
     */
    public List<Instruction> getInstructionList () {
        return myInstructionList;
    }

    @Override
    public double execute (ObservableData od) throws InvalidArgumentsException {
        double returnAmt = 0;
        for (Instruction instr : myInstructionList) {
            returnAmt = instr.execute(od);
        }

        return returnAmt;

    }

}
