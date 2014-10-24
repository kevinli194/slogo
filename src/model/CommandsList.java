package model;

import instructions.UserDefinedCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * CommandsList class.
 * Contains the list of pre-defined and user-defined commands.
 * Class is to be accessed by the commands AND by the instruction factory.
 * 
 * @author slogo_team02 a.k.a. TEAM ROCKET
 *
 */
public class CommandsList implements Feature {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4687405266966458965L;
	public static final String DEFAULT_LANGUAGE_PACKAGE = "resources.languages/";
	public static final String DEFAULT_LANGUAGE_BUNDLE = DEFAULT_LANGUAGE_PACKAGE + "English";
	private ResourceBundle languageBundle;
	
	private Map<String, String> PreDefinedCommands;
	private Map<String, UserDefinedCommand> UserDefinedCommands;

	/**
	 * 
	 */
	public CommandsList() {
		languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_BUNDLE);
		PreDefinedCommands = initPreDefinedCommands(languageBundle);
		UserDefinedCommands = new HashMap<String, UserDefinedCommand>();
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

	public void add(String commandSyntax, UserDefinedCommand instr) {
		if (PreDefinedCommands.containsKey(commandSyntax) ||
			UserDefinedCommands.containsKey(commandSyntax)) {
			System.out.println("COMMAND ALREADY DEFINED.");
		}
		UserDefinedCommands.put(commandSyntax, instr);
		
	}
	
	public void delete(String commandSyntax) {
		if (!UserDefinedCommands.containsKey(commandSyntax)) {
			System.out.println("USER DEFINED COMMAND NOT FOUND.");
		}
		UserDefinedCommands.remove(commandSyntax);
	}
	
	public UserDefinedCommand get(String commandSyntax) {
		if (!UserDefinedCommands.containsKey(commandSyntax)) {
			System.out.println("COMMAND DOES NOT EXIST.");
		}
		return UserDefinedCommands.get(commandSyntax);
		
	}
	
	public boolean contains(String commandSyntax) {
		return (UserDefinedCommands.containsKey(commandSyntax) ||
				PreDefinedCommands.containsKey(commandSyntax));
	}

	/**
	 * Allows switching of language
	 * @param language string of language to change to
	 */
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
	
	public List<String[]> generate(){
		List<String[]> instructionList=new ArrayList<String[]>();
		instructionList.add(PreDefinedCommands.keySet().toArray(new String[PreDefinedCommands.keySet().size()]));
		instructionList.add(UserDefinedCommands.keySet().toArray(new String[UserDefinedCommands.keySet().size()]));	
		return instructionList;
	}


}
