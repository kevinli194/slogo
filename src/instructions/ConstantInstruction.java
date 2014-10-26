package instructions;

import model.ObservableData;


/**
 * This is the class for instructions that only store a constant value. Its
 * evaluate method will return its double value.
 *
 * @author Jennie Ju
 *
 */

public class ConstantInstruction extends ZeroParamInstruction {

    private static final long serialVersionUID = 6304998740133863536L;
    private double myValue;

    /**
     * Constructor for constant instruction.
     *
     * @param value of the constant instruction.
     */
    public ConstantInstruction (double value) {
        myValue = value;
    }

    @Override
    public double execute (ObservableData data) {
        return myValue;
    }
}
