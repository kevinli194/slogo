package instructions;

/**
 * Superclass for instructions that do not have parameters.
 * @author Jennie Ju
 *
 */
public abstract class ZeroParamInstruction implements Instruction {

    private static final long serialVersionUID = -6504932620355712311L;

    @Override
    public int getNumParams () {
        return 0;
    }

    @Override
    public void addParam (Instruction param) {
    }
}
