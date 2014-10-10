package parser;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;

import Instructions.ConstantInstruction;
import Instructions.Instruction;
import Instructions.TurtleCommand.Forward;

/**
 * Factory design pattern for creating 
 * instances of different instructions
 *
 */
public class InstructionFactory {
	private Map<String,String> languageMap;
	private Pattern constantPattern;
	private Pattern variablePattern;
	private Pattern commandPattern;
	private static final String CONSTANT_REGEX = "-?[0-9]+\\.?[0-9]*";
    private static final String VARIABLE_REGEX = ":[a-zA-z]+";
    private static final String COMMAND_REGEX = "[a-zA-z_]+(\\?)?";
    private static final String SPLIT_REGEX = "\\s+";

	/**
	 * Takes a string type of instruction and
	 * instantiates the class based on the type
	 * @param type String name of type of instruction
	 * @return Instruction class of that type
	 */

		public InstructionFactory() {
//			languageMap = createLanguageMap(bundle);
			
			
		}

	private Map<String, String> createLanguageMap(ResourceBundle bundle) {
		Map<String,String> map = new HashMap<String,String>();
		Set<String> languageKeys = bundle.keySet();
		for (String key : languageKeys) {
			String[] strings = bundle.getStringArray(key);
			for (String s : strings) {
				map.put(s,key);
			}
		}
		return map;
	}

	public Instruction makeInstruction(String type) {
		if (type.matches(CONSTANT_REGEX)) {
			double value = Double.parseDouble(type);
			new ConstantInstruction(value);
		}
		
		if (type.equals("forward")) {
			return new Forward();
		}
		return null;
	}

}
