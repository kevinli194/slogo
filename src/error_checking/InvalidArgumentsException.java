package error_checking;

/**
 * Exception for incorrect arguments for instructions.
 *
 * @author Sandy Lee
 *
 */
public class InvalidArgumentsException extends Exception {

    private static final long serialVersionUID = -1655783914853853644L;

    /**
     * Creates an InvalidArgumentsException from error and caus strings.
     *
     * @param error message
     * @param cause of the error
     */
    public InvalidArgumentsException (String error, Object ... cause) {
        super(String.format(error, cause));
    }
    
}
