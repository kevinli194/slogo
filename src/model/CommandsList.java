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
 * CommandsList class. Contains the list of pre-defined and user-defined
 * commands. Class is to be accessed by the commands AND by the instruction
 * factory.
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
	public static final String DEFAULT_LANGUAGE_RESOURCE = DEFAULT_LANGUAGE_PACKAGE + "English";
	public static final String PRE_DEFINED_COMMANDS_RESOURCE = "resources.parsing/PreDefinedCommands";
	private ResourceBundle languageBundle;
	private ResourceBundle commandsBundle;

	private Map<String, String> preDefCommandTypes;
	private Map<String, String> preDefCommandSyntaxes;
	private Map<String, UserDefinedCommand> userDefCommands;

	/**
	 * 
	 */
	public CommandsList() {
		languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_RESOURCE);
		commandsBundle = loadResourceBundle(PRE_DEFINED_COMMANDS_RESOURCE);
		preDefCommandTypes = initCommandsMap(commandsBundle.keySet(), commandsBundle);
		preDefCommandSyntaxes = initCommandsMap(preDefCommandTypes.keySet(), languageBundle);
		userDefCommands = new HashMap<String, UserDefinedCommand>();
	}

	private ResourceBundle loadResourceBundle(String filepath) {
		return ResourceBundle.getBundle(filepath);
	}

	private Map<String,String> initCommandsMap(Set<String> keys, ResourceBundle bundle) {
		Map<String,String> map = new HashMap<String,String>();
		for (String type : keys) {
			String value = bundle.getString(type);
			String[] commands = value.split(",");
			for (String command : commands) {
				map.put(command,type);
			}
		}
		return map;
	}


	public void add(String commandSyntax, UserDefinedCommand userDefinedCom) {
//		if (preDefCommandSyntaxes.containsKey(commandSyntax) ||
//				userDefCommands.containsKey(commandSyntax)) {
//			new ErrorDialog("Command %s already defined.", commandSyntax);
//			System.out.println("COMMAND ALREADY DEFINED.");
//		}
		userDefCommands.put(commandSyntax, userDefinedCom);

	}

	public void delete(String commandSyntax) {
		if (!userDefCommands.containsKey(commandSyntax)) {
			new ErrorDialog("Command %s does not exist.", commandSyntax);
			System.out.println("USER DEFINED COMMAND NOT FOUND.");
		}
		userDefCommands.remove(commandSyntax);
	}

	public Instruction get(String commandSyntax) {
		try {
			Class<?> commandClass = Class.forName("instructions.commands." + preDefCommandSyntaxes.get(commandSyntax));
			return (Instruction) commandClass.newInstance();
		} catch (Exception e) {
			if (userDefCommands.containsKey(commandSyntax)) {
				return new UserDefinedCommand(userDefCommands.get(commandSyntax));
			} else {
				return new UserDefinedCommand(commandSyntax);
			}
		}
	}

	//		if (!userDefCommands.containsKey(commandSyntax)) {
	//			new ErrorDialog("Command %s does not exist.", commandSyntax);
	//			System.out.println("COMMAND DOES NOT EXIST.");
	//		}
	//		return userDefCommands.get(commandSyntax);


	public boolean contains(String commandSyntax) {
		return (userDefCommands.containsKey(commandSyntax) ||
				preDefCommandSyntaxes.containsKey(commandSyntax));
	}

	/**
	 * Allows switching of language
	 * 
	 * @param language
	 *            string of language to change to
	 */
	public void changeLanguage(String language) {
		languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_PACKAGE + language);
		//		preDefCommandSyntaxes = initCommandsMap(commandsBundle, languageBundle);
		//=======
		//		ResourceBundle languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_PACKAGE
		//				+ language);
		//		PreDefinedCommands = initPreDefinedCommands(languageBundle);
		//>>>>>>> 95894f688e535b8c8ecb818ce1b850c9cffb6a6a
	}

	public List<String> getCommandSyntaxes() {
		List<String> commands = new ArrayList<String>();
		commands.addAll(preDefCommandSyntaxes.keySet());
		commands.addAll(userDefCommands.keySet());
		return commands;
	}

	@Override
	public void clear() {
		userDefCommands.clear();
	}

	@Override
	public void remove(Object commandSyntax) {
		if (!userDefCommands.containsKey(commandSyntax)) {
			System.out.println("USER DEFINED COMMAND NOT FOUND.");
		}
		userDefCommands.remove(commandSyntax);
	}

	public List<String[]> generate(){
		List<String[]> instructionList=new ArrayList<String[]>();
		instructionList.add(preDefCommandSyntaxes.keySet().toArray(new String[preDefCommandSyntaxes.keySet().size()]));
		instructionList.add(userDefCommands.keySet().toArray(new String[userDefCommands.keySet().size()]));	

		//	public List<String[]> generate() {
		//		List<String[]> instructionList = new ArrayList<String[]>();
		//		instructionList.add(PreDefinedCommands.keySet().toArray(
		//				new String[PreDefinedCommands.keySet().size()]));
		//		instructionList.add(UserDefinedCommands.keySet().toArray(
		//				new String[UserDefinedCommands.keySet().size()]));

		return instructionList;
	}

}
