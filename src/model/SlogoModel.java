package model;

import java.util.List;
import java.util.Observable;
//import Instructions.Instruction;

public class SlogoModel extends Observable {
	private ObservableData myObservableData;

	public SlogoModel() {
		myObservableData = new ObservableData();
	}

//	public void executeCommands(List<Instruction> ParsedInstructions) {
//		for (Instruction s : ParsedInstructions) {
//			s.execute(myObservableData);
//		}
//		setChanged();
//		notifyObservers(myObservableData);
//	}
}
