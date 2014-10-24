package instructions.commands;

import instructions.UnaryInstruction;
import model.ObservableData;


public class Random extends UnaryInstruction {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5427849732298158737L;
	private java.util.Random myRand;

    @Override
    public double execute (ObservableData data) {
        // TODO Auto-generated method stub
        myRand = new java.util.Random();


        int max = (int) myParams.get(0).execute(data);
        return (double) myRand.nextInt(max);


    }
}
