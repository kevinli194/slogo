package error_checking;

public class SlogoException extends RuntimeException {
	
    /**
     * Create an exception based on an issue in our code.
     */
//    public SlogoException (String format, Object ... args) {
//    	String message = String.format(format, args);
//        super(message);
//    }
    public SlogoException (String message) {
        super(message);
    }
}
