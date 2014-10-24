package model;

import instructions.Instruction;
import instructions.UserDefinedCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import error_checking.ErrorDialog;
//TODO: NEED TO PUT STRINGS INTO RESOURCES
/**
 * CommandsList class.
 * Contains the list of pre-defined and user-defined commands.
 * Class is to be accessed by the commands AND by the instruction factory.
 * 
 * @author slogo_team02 a.k.a. TEAM ROCKET
 *
 */
public class CommandsList implements Feature {
	public static final String DEFAULT_LANGUAGE_BASENAME = "resources.languages/";
	public static final String DEFAULT_LANGUAGE_LOCALE = DEFAULT_LANGUAGE_BASENAME + "English";
	public static final String PRE_DEFINED_COMMANDS_RESOURCE = "resources.parsing/PreDefinedCommands";
	
	private ResourceBundle languageBundle;
	private Map<String, String> PreDefinedCommands;
	private Map<String, UserDefinedCommand> UserDefinedCommands;

	/**
	 * 
	 */
	public CommandsList() {
		languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_LOCALE);
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

	public void add(String commandSyntax, UserDefinedCommand userDefinedCom) {
		if (PreDefinedCommands.containsKey(commandSyntax) ||
			UserDefinedCommands.containsKey(commandSyntax)) {
			new ErrorDialog("Command %s already defined.", commandSyntax);
			System.out.println("COMMAND ALREADY DEFINED.");
		}
		UserDefinedCommands.put(commandSyntax, userDefinedCom);
		
	}
	
	public void delete(String commandSyntax) {
		if (!UserDefinedCommands.containsKey(commandSyntax)) {
			new ErrorDialog("Command %s does not exist.", commandSyntax);
			System.out.println("USER DEFINED COMMAND NOT FOUND.");
		}
		UserDefinedCommands.remove(commandSyntax);
	}
	
	public UserDefinedCommand get(String commandSyntax) {
		if (!UserDefinedCommands.containsKey(commandSyntax)) {
			new ErrorDialog("Command %s does not exist.", commandSyntax);
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
		languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_BASENAME + language);
		PreDefinedCommands = initPreDefinedCommands(languageBundle);
	}
	
	public List<String> getCommandSyntaxes() {
		List<String> commands = new ArrayList<String>();
		commands.addAll(PreDefinedCommands.keySet());
		commands.addAll(UserDefinedCommands.keySet());
		return commands;
	}

	@Override
	public void clear() {
		UserDefinedCommands.clear();
	}
	
	
	@Override
	public void remove(Object commandSyntax) {
		if (!UserDefinedCommands.containsKey(commandSyntax)) {
			System.out.println("USER DEFINED COMMAND NOT FOUND.");
		}
		UserDefinedCommands.remove(commandSyntax);
	}
	
	public List<String[]> generate(){
		List<String[]> instructionList=new ArrayList<String[]>();
		instructionList.add(PreDefinedCommands.keySet().toArray(new String[PreDefinedCommands.keySet().size()]));
		instructionList.add(UserDefinedCommands.keySet().toArray(new String[UserDefinedCommands.keySet().size()]));	
		return instructionList;
	}



}
