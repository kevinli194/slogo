package instructions;

/**
 * This represents the super class for instructions with one parameter
 * 
 * @author Sandy Lee
 */
public abstract class UnaryInstruction extends ParameterInstruction {

    private static final int UNARY_NUM_PARAM = 1;
    private static final long serialVersionUID = -6285500985853679738L;

    /**
     * Constructor for unary instrcution.
     */
    public UnaryInstruction () {
        super.myNumParams = UNARY_NUM_PARAM;
    }

}
