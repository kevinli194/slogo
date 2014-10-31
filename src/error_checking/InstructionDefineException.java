package error_checking;

/**
 * This exception is for errors in the creation of instrcutions in the parser.
 * 
 * @author Sandy Lee
 *
 */
public class InstructionDefineException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * creates the exception.
     * 
     * @param message for error
     */
    public InstructionDefineException (String error, Object ... cause) {
        super(String.format(error, cause));
    }
}
