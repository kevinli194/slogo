package model;

public class ObservableData {
        private Turtle myTurtle;
        private History myHistory;
        private InstructionList myInstructions;
        private Variables myVariables;

        public ObservableData() {
                myTurtle = new Turtle();
                myHistory = new History();
                myInstructions = new InstructionList();
                myVariables = new Variables();
        }

        public Feature get(String id) {
                switch (id) {
                case "turtle":
                        return myTurtle;
                case "history":
                        return myHistory;
                case "instructions":
                        return myInstructions;
                case "variables":
                        return myVariables;
                default:
                        return null; // fix this later
                }
        }

        public void clear() {
                myTurtle.clear();
                myHistory.clear();
                myInstructions.clear();
                myVariables.clear();
        }
}