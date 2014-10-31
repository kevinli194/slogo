package view;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import model.CommandsList;
import model.SlogoModel;

import org.junit.Test;

public class BasicCommandViewTester {
	@Test
	public void updateTest() {
		// Instantiate a new BasicCommandView
		Locale myLocale = new Locale("en", "US");
		SlogoModel model = new SlogoModel(myLocale);
		InputView input = new InputView(model, 50, 50, myLocale);
		BasicCommandsView bcview = new BasicCommandsView(input, 50, 50);
		UDCommandsView udview = new UDCommandsView(input, 50, 50);
		
		// Update the basic command view with information from the model.
		bcview.update((CommandsList) model.getMyData().get("CommandsList"));
		assertEquals(
				"The number of elements should be the same as the number of commands in the properties file.",
				88, bcview.countElements());
	}
}
