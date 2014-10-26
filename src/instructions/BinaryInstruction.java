package instructions;

/**
 * This represents the super class for instructions with two parameters.
 *
 * @author Sandy Lee
 *
 */
public abstract class BinaryInstruction extends ParameterInstruction {

    private static final long serialVersionUID = -7463789415798666493L;
    private static final int BINARY_NUM_PARAM = 2;

    /**
     * Constructor for Binary Instruction.
     *
     */
    public BinaryInstruction () {
        super.myNumParams = BINARY_NUM_PARAM;
    }

}
