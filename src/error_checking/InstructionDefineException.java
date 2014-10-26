package error_checking;

public class InstructionDefineException extends RuntimeException {
	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create an exception based on an issue in our code.
     */
//    public SlogoException (String format, Object ... args) {
//    	String message = String.format(format, args);
//        super(message);
//    }
    public InstructionDefineException (String message) {
        super(String.format(message));
    }
}
