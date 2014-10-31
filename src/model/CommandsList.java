package model;

import instructions.Instruction;
import instructions.UserDefinedCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import error_checking.ErrorDialog;

/**
 * CommandsList class. Contains the list of pre-defined and user-defined
 * commands. Class is to be accessed by the commands AND by the instruction
 * factory.
 * @author slogo_team02 a.k.a. TEAM ROCKET
 * @author Mengen Huang
 * @author Kevin Li
 * @author Jennie Ju
 * @author Sandy Lee
 *
 */
public class CommandsList implements Feature {

	private static final long serialVersionUID = -4687405266966458965L;
	private static final String DEFAULT_LANGUAGE_PACKAGE = 
												"resources.languages/";
	private static final String PRE_DEFINED_COMMANDS_RESOURCE = 
									"resources.parsing/PreDefinedCommands";
	private ResourceBundle languageBundle;
	private ResourceBundle commandsBundle;

	private Map<String, String> preDefCommandTypes;
	private Map<String, String> preDefCommandSyntaxes;
	private Map<String, UserDefinedCommand> userDefCommands;

	/**
	 * Pre-difined and user-defined lists of commands stored in map.
	 * @param locale language and locale of the window
	 */
	public CommandsList(Locale locale) {
		languageBundle = ResourceBundle.getBundle(
				DEFAULT_LANGUAGE_PACKAGE + "Commands", locale);
		commandsBundle = loadResourceBundle(
				PRE_DEFINED_COMMANDS_RESOURCE);
		preDefCommandTypes = initCommandsMap(
				commandsBundle.keySet(), commandsBundle);
		preDefCommandSyntaxes = initCommandsMap(
				preDefCommandTypes.keySet(), languageBundle);
		userDefCommands = new HashMap<String, UserDefinedCommand>();
	}

	/**
	 * Get the ResourceBundle according to file path.
	 * @param filepath path to get the resource
	 * @return ResourceBundle
	 */
	private ResourceBundle loadResourceBundle(String filepath) {
		return ResourceBundle.getBundle(filepath);
	}

	/**
	 * Create the commands map according to the information.
	 * stored in ResourceBundle.
	 * @param keys ResourceBundle keySet
	 * @param bundle ResrouceBundle to load
	 * @return map where all the values in ResourceBundle as keys
	 * and KeySet of ResourceBundle as values
	 */
	private Map<String, String> initCommandsMap(Set<String> keys,
										ResourceBundle bundle) {
		Map<String, String> map = new HashMap<String, String>();
		for (String type : keys) {
			String value = bundle.getString(type);
			String[] commands = value.split(",");
			for (String command : commands) {
				map.put(command, type);
			}
		}
		return map;
	}


	/**
	 * Add in new user-defined commands into UserDefined commands map.
	 * @param commandSyntax name of the user-defined command
	 * @param userDefinedCom The commands to do after calling the name
	 */
	public void add(String commandSyntax, UserDefinedCommand userDefinedCom) {
		userDefCommands.put(commandSyntax, userDefinedCom);

	}

	/**
	 * Delete the user-defined command from the user-defiend commands map.
	 * @param commandSyntax the name of the user-defined command to be deleted
	 */
	public void delete(String commandSyntax) {
		if (!userDefCommands.containsKey(commandSyntax)) {
			new ErrorDialog("Command %s does not exist.", commandSyntax);
			System.out.println("USER DEFINED COMMAND NOT FOUND.");
		}
		userDefCommands.remove(commandSyntax);
	}

	/**
	 * Get the instruction which matches the name of the user-defined command.
	 * @param commandSyntax name of the user-defined command
	 * @return instruction which matches the name of the user-defined command
	 */
	public Instruction get(String commandSyntax) {
		try {
			Class<?> commandClass = Class.forName("instructions.commands." 
								+ preDefCommandSyntaxes.get(commandSyntax));
			return (Instruction) commandClass.newInstance();
		} catch (Exception e) {
			if (userDefCommands.containsKey(commandSyntax)) {
				return new UserDefinedCommand(userDefCommands.get(commandSyntax));
			} else {
				return new UserDefinedCommand(commandSyntax);
			}
		}
	}


	/**
	 * Check if either predefined commands map or user-defined commands map.
	 * contains the command
	 * @param commandSyntax name of the command to be checked
	 * @return if the command is contained in either commands map
	 */
	public boolean contains(String commandSyntax) {
		return (userDefCommands.containsKey(commandSyntax) 
				|| preDefCommandSyntaxes.containsKey(commandSyntax));
	}

	/**
	 * Allows switching of language.
	 * @param language string of language to change to
	 */
	public void changeLanguage(String language) {
		languageBundle = loadResourceBundle(DEFAULT_LANGUAGE_PACKAGE + language);
	}

	/**
	 * Get all the names of predefined commands and user-defined commands.
	 * @return names of commands in a list
	 */
	public List<String> getCommandSyntaxes() {
		List<String> commands = new ArrayList<String>();
		commands.addAll(preDefCommandSyntaxes.keySet());
		commands.addAll(userDefCommands.keySet());
		return commands;
	}

	/**
	 * Clear the user-defined commands map.
	 */
	@Override
	public void clear() {
		userDefCommands.clear();
	}

	/**
	 * Remove a user-defined command from the map. Indicate when the
	 * required command name is not found in the map.
	 */
	@Override
	public void remove(Object commandSyntax) {
		if (!userDefCommands.containsKey(commandSyntax)) {
			System.out.println("USER DEFINED COMMAND NOT FOUND.");
		}
		userDefCommands.remove(commandSyntax);
	}

	/**
	 * Generate a list of two string arrays to pass to the front-end view package.
	 * @return a list of two string arrays: predefined commands name array
	 * and user-defined commands name array
	 */
	public List<String[]> generate(){
		List<String[]> instructionList = new ArrayList<String[]>();
		List<String> commandsList = makeCommandsList();
		instructionList.add(commandsList.toArray(new String[commandsList.size()]));
		instructionList.add(userDefCommands.keySet().toArray(
				new String[userDefCommands.keySet().size()]));

		return instructionList;
	}

	/**
	 * Make a list of predefined commands which group commands of same function.
	 * together. Fix the random distribution of commands in the map.
	 * @return a list of sorted commands according to their functions
	 */
	private List<String> makeCommandsList() {
		List<String> sortedCommandsList = new ArrayList<String>();
		for (String instr:commandsBundle.keySet()){
			String[] oneTypeCommands = commandsBundle.getString(instr).split(",");
			for (String command:oneTypeCommands){
				String[] oneInstruction = languageBundle.getString(command).split(",");
				for (String expression:oneInstruction){
					sortedCommandsList.add(expression);
				}
			}
		}
		return sortedCommandsList;
	}

}
