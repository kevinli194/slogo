package model;

public class ObservableData {
    private Turtle myTurtle;
    private History myHistory;
    private InstructionList myInstructions;
    private Variables myVariables;

    public ObservableData () {
        myTurtle = new Turtle();
        myHistory = new History();
        myInstructions = new InstructionList();
        myVariables = new Variables();
    }


}
