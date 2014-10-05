package Instructions;

import model.ObservableData;

/**
 * Highest superclass for the parsing tree tree that will be made to represent an expression.
 * 
 */

public interface Instruction {
	/**
	 * Evaluates the expression for the double return value only.
	 * Does not carry out other tasks on any observable data.
	 * @return Double value of the expression
	 */
    public double evaluate();
    
    /**
     * Executes the functionality of the instruction to
     * change data in the program, such as lists of history
     * and scene nodes during drawing.
     * 
     * @return Double value of the expression
     */
    public void execute(ObservableData od);


}
