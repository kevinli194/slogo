// JUnit Tests
// Jennie Ju (jsj18)

package parser;

import static org.junit.Assert.*;
import static org.junit.Test.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import error_checking.InvalidArgumentsException;
import model.ObservableData;



public class FactoryParserTests {
	private static final String COMMANDS_RESOURCE_LOC = "resources.languages/Commands";
    private static final String DISPLAY_RESOURCE_LOC = "resources.languages/Display";
	private Locale engLocale = new Locale("en", "US");
	private ObservableData engData = new ObservableData(engLocale);

	// Note, tests are getting errors likely due to error dialogs and exceptions thrown while parsing.
	@Test
	public void testParserErrorCatching() {
		Locale engLocale = new Locale("en", "US");
		ObservableData engData = new ObservableData(engLocale);
		Parser engParser = new Parser(engData, engLocale);
		assertEquals(true, engParser.parse("fd :size").isEmpty());
		assertEquals(true, engParser.parse("[ fd 50 ] ] [ right 90 ]").isEmpty());
	}
	
	@Test
	public void testInstructionMaking() throws InvalidArgumentsException {
		Locale engLocale = new Locale("en", "US");
		ObservableData engData = new ObservableData(engLocale);
		ResourceBundle languageBundle = ResourceBundle.getBundle(COMMANDS_RESOURCE_LOC, engLocale);
		ResourceBundle displayBundle = ResourceBundle.getBundle(DISPLAY_RESOURCE_LOC, engLocale);
	
		InstructionFactory iFact = new InstructionFactory(engData,languageBundle,displayBundle);
		assertEquals("Forward", iFact.makeInstruction("fd").getClass().getSimpleName());
		
	}
	
}
