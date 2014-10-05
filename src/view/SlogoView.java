package view;

import java.util.Observable;
import java.util.Observer;

import model.SlogoModel;
import model.Turtle;

public class SlogoView implements Observer {

	public SlogoView(String language, SlogoModel model) {
	}

	// Feeds the string read into the view into the model to be parsed and executed.
	public void readString(String s){
		
	}
	// Updates the display based on the changes that occurred in the
	// environment.
	@Override
	public void update(Observable o, Object arg) {
	}

}
