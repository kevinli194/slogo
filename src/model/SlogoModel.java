package model;

import java.util.List;
import java.util.Observable;

import javafx.scene.Group;

public class SlogoModel extends Observable {
	private Environment myEnvironment;

	public SlogoModel() {
		myEnvironment = new Environment();
	}

	public void executeCommands(List<Instructions> ParsedInstructions) {
		for (Instructions s : ParsedInstructions) {
			s.execute();
		}
		setChanged();
		notifyObservers(myEnvironment);
	}
}
