package instructions.commands;

import instructions.Instruction;
import instructions.ZeroParamInstruction;
import model.ObservableData;
import model.Turtle;


public class Heading extends ZeroParamInstruction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7360594989540018283L;

	@Override
    public double execute (ObservableData data){
        // TODO Auto-generated method stub
        Turtle myTurtle = data.getTurtle();

        return myTurtle.getAngle();
    }

    @Override
    public int getNumParams () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addParam (Instruction param) {
        // TODO Auto-generated method stub

    }

}
