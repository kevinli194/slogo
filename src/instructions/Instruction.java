package instructions;

import java.io.Serializable;
import model.ObservableData;
import error_checking.InvalidArgumentsException;


/**
 * Highest superclass for the parsing tree tree that will be made to represent
 * an expression.
 *
 * @author Jennie Ju, Sandy Lee
 *
 */

public interface Instruction extends Serializable {

    /**
     * Executes the functionality of the instruction to change data in the
     * program, such as lists of history and scene nodes during drawing.
     *
     * @return Double value of the expression
     * @param data of observables
     * @throws InvalidArgumentsException throws when there is an argument error.
     */
    public double execute (ObservableData data) throws InvalidArgumentsException;

    /**
     * Gets the number of parameters used in the instruction, Used in the parser
     * when evaluating different types of instructions with various numbers of
     * parameters
     *
     * @return int number of parameters
     */
    public int getNumParams ();

    /**
     * Adds an instruction to the list of parameters for the instruction
     *
     * @param param
     *        Instruction used as a parameter in the instruction
     */
    public void addParam (Instruction param);

}
