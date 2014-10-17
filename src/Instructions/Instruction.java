package Instructions;

import java.util.Map;

import model.Feature;
import model.ObservableData;

/**
 * Highest superclass for the parsing tree tree that will be made to represent
 * an expression.
 * 
 */

public interface Instruction {

	/**
	 * Executes the functionality of the instruction to change data in the
	 * program, such as lists of history and scene nodes during drawing.
	 * 
	 * @return Double value of the expression
	 */
	public double execute(ObservableData data);

	/**
	 * Gets the number of parameters used in the instruction, Used in the parser
	 * when evaluating different types of instructions with various numbers of
	 * parameters
	 * 
	 * @return int number of parameters
	 */
	public int getNumParams();

	/**
	 * Adds an instruction to the list of parameters for the instruction
	 * 
	 * @param param
	 *            Instruction used as a parameter in the instruction
	 */
	public void addParam(Instruction param);

}
