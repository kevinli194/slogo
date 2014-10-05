package Instructions;

/**
 * This represents the super class for instructions with two parameters
 * 
 */
public abstract class BinaryInstruction extends ParameterInstruction{
	private double myParam1;
	private double myParam2;
	
	
    /**
     * 
     * @param parameterOne parameter of the binary instruction
     * @param parameterTwo parameter of the binary instruction
     */
    public BinaryInstruction (){
    }
    
    
    public void getParameterOne(){
    }
    
    public void getParameterTwo(){      
    }
    
    
}
