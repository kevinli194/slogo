package parser;

import instructions.ConstantInstruction;
import instructions.Instruction;
import instructions.UserDefinedCommand;
import instructions.VariableInstruction;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;

import model.CommandsList;
import model.ObservableData;

/**
 * Factory design pattern for creating instances of different instructions
 *
 */
public class InstructionFactory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2129488091762474882L;
	private static final String CONSTANT_REGEX = "-?[0-9]+\\.?[0-9]*";
	private static final String VARIABLE_REGEX = ":[a-zA-z]+";
	private static final String COMMAND_REGEX = "[a-zA-z_]+(\\?)?";
	public static final String CHINESE_REGEX ="[\u4e00-\u9fa5]+(\\?)?";

	// private ResourceBundle languageBundle;
	private Map<String, String> languageMap;
	// DON'T KEEP THIS IN THIS MANNER (DISORGANIZED)
	private ObservableData myData;

	/**
	 * Takes a string type of instruction and instantiates the class based on
	 * the type
	 * 
	 * @param type
	 *            String name of type of instruction
	 * @return Instruction class of that type
	 */

	public InstructionFactory(ObservableData data) {
		ResourceBundle languageBundle = loadResourceBundle("resources.languages/English");
		languageMap = createLanguageMap(languageBundle);
		myData = data;

	}

	private ResourceBundle loadResourceBundle(String filepath) {
		return ResourceBundle.getBundle(filepath);
	}

	private Map<String, String> createLanguageMap(ResourceBundle bundle) {
		Map<String, String> map = new HashMap<String, String>();
		Set<String> languageKeys = bundle.keySet();
		for (String key : languageKeys) {
			String value = bundle.getString(key);
			String[] commands = value.split(",");
			for (String s : commands) {
				map.put(s, key);
			}
		}
		return map;
	}

	public Instruction makeInstruction(String type) {
		type = type.toLowerCase();

		if (type.matches(CONSTANT_REGEX)) {
			double value = Double.parseDouble(type);
			return new ConstantInstruction(value);
		} else if (type.matches(VARIABLE_REGEX)) {
			return new VariableInstruction(type);
		} else if (type.matches(COMMAND_REGEX) || type.matches(CHINESE_REGEX)) {
			// TODO: LOOK UP TRY CATCHES
			try {
				Class<?> comClass = Class.forName("instructions.commands."
						+ languageMap.get(type));
//				System.out.println(type);
//				System.out.println(languageMap.get(type));
				Constructor<?> comConstructor = comClass.getConstructor();
				return (Instruction) comConstructor.newInstance();
			} catch (ClassNotFoundException | NoSuchMethodException
					| SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				System.out.println("d");
				CommandsList allCommands = (CommandsList) myData
						.get("CommandsList");
				if (allCommands.contains(type)) {
					return new UserDefinedCommand(allCommands.get(type));
				} else {
					return new UserDefinedCommand(type);
				}
			}

			// System.out.println(type + " IS NOT A VALID COMMAND.");
			// Need to add error checking
		}

		return null;
	}

}
