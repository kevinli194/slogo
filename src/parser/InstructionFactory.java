package parser;

import Instructions.ConstantInstruction;
import Instructions.Instruction;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;




/**
 * Factory design pattern for creating 
 * instances of different instructions
 *
 */
public class InstructionFactory {
	private static final String CONSTANT_REGEX = "-?[0-9]+\\.?[0-9]*";
	private static final String VARIABLE_REGEX = ":[a-zA-z]+";
	private static final String COMMAND_REGEX = "[a-zA-z_]+(\\?)?";

	private ResourceBundle languageBundle;
	private Map<String,String> languageMap;

	/**
	 * Takes a string type of instruction and
	 * instantiates the class based on the type
	 * @param type String name of type of instruction
	 * @return Instruction class of that type
	 */

	public InstructionFactory() {
		languageBundle = loadResourceBundle("resources.languages/English");
		languageMap = createLanguageMap(languageBundle);

	}

	private ResourceBundle loadResourceBundle(String filepath) {
		return ResourceBundle.getBundle(filepath);
	}

	private Map<String, String> createLanguageMap(ResourceBundle bundle) {
		Map<String,String> map = new HashMap<String,String>();
		Set<String> languageKeys = bundle.keySet();
		for (String key : languageKeys) {
			String value = bundle.getString(key);
			String[] commands = value.split(",");
			for (String s : commands) {
				map.put(s,key);
			}
		}
		return map;
	}

	public Instruction makeInstruction(String type) {
		type = type.toLowerCase();

		if (type.matches(CONSTANT_REGEX)) {
			double value = Double.parseDouble(type);
			return new ConstantInstruction(value);
		}

		
		else if (type.matches(VARIABLE_REGEX)){
			return null;
		}
		else if (type.matches(COMMAND_REGEX)) {

			try {
				Class<?> comClass = Class.forName("instructions.commands." + languageMap.get(type));
				Constructor<?> comConstructor = comClass.getConstructor();
				return (Instruction) comConstructor.newInstance();
			}
			catch (ClassNotFoundException |
					NoSuchMethodException |
					SecurityException |
					InstantiationException |
					IllegalAccessException |
					IllegalArgumentException |
					InvocationTargetException e) {

				System.out.println("NOT A VALID COMMAND.");
				// Need to add error checking
			}
		}

		return null;
	}


}
