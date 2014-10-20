//This class does not function. It is for testing the extensibility of the program.
package model;

import instructions.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class CommandsList implements Feature {
	public static final String DEFAULT_LANGUAGE_PACKAGE = "resources.languages/";
	public static final String DEFAULT_LANGUAGE_BUNDLE = DEFAULT_LANGUAGE_PACKAGE + "English";
	private ResourceBundle languageBundle;
	
	private Map<String, String> PreDefinedCommands;
	private Map<String, Instruction> UserDefinedCommands;

	/**
	 * 
	 */
	public CommandsList() {
		languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_BUNDLE);
		PreDefinedCommands = initPreDefinedCommands(languageBundle);
		UserDefinedCommands = new HashMap<String, Instruction>();
	}
	
	private ResourceBundle loadResourceBundle(String filepath) {
		return ResourceBundle.getBundle(filepath);
	}

	private Map<String,String> initPreDefinedCommands(ResourceBundle bundle) {
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

	public void addCommand(String commandSyntax, Instruction instr) {
		UserDefinedCommands.put(commandSyntax, instr);
		
	}

	public void deleteCommand(String command) {
		//Error Check for command
		UserDefinedCommands.remove(command);
	}

	public void changeLanguage(String language) {
		languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_PACKAGE + language);
		PreDefinedCommands = initPreDefinedCommands(languageBundle);
	}

	public List<String> getCommandSyntaxes() {
		List<String> commands = new ArrayList<String>();
		commands.addAll(PreDefinedCommands.keySet());
		commands.addAll(UserDefinedCommands.keySet());
		return commands;
	}

	public void clear() {
		UserDefinedCommands.clear();
	}


}
