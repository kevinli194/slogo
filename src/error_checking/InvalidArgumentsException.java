package error_checking;

public class InvalidArgumentsException extends Exception{
    
    /**
     * 
     */
    private static final long serialVersionUID = -1655783914853853644L;
    
    public InvalidArgumentsException  (String error, String cause) {
        super(String.format(error, cause));
    }
}
