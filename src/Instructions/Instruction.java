package Instructions;

import java.util.Map;

import model.Feature;

/**
 * Highest superclass for the parsing tree tree that will be made to represent
 * an expression.
 * 
 */

public interface Instruction {

	/**
	 * Evaluates the expression for the double return value only. Does not carry
	 * out other tasks on any observable data.
	 * 
	 * @return Double value of the expression
	 */
	public double evaluate();

	/**
	 * Executes the functionality of the instruction to change data in the
	 * program, such as lists of history and scene nodes during drawing.
	 * 
	 * @return Double value of the expression
	 */
	public void execute(Map<String, Feature> data);

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
