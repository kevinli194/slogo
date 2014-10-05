package Instructions;

import model.Environment;

/**
 * Base class for the parsing tree tree that will be made to represent an expression.
 * 
 */

public interface Instruction {

    /**
     * Evaluates the current node of the expression.
     * 
     * @return The double value of the expression.
     */
    public double evaluate (Environment environment);

}
