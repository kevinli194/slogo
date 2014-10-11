package parser;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;
import Instructions.ConstantInstruction;
import Instructions.Instruction;
import Instructions.TurtleCommand.Back;
import Instructions.TurtleCommand.Forward;
import Instructions.TurtleCommand.If;
import Instructions.TurtleCommand.Left;
import Instructions.TurtleCommand.Less;
import Instructions.TurtleCommand.Repeat;
import Instructions.TurtleCommand.Right;
import Instructions.TurtleCommand.SetHeading;
import Instructions.TurtleCommand.Sum;
import Instructions.TurtleCommand.Towards;

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
			return new ConstantInstruction(value);
		}
		else if (type.equals("forward")) {
			System.out.println("forward!");
			return new Forward();
		}
		else if (type.equals("back")) {
                    System.out.println("back!");
                    return new Back();
            }
		else if (type.equals("repeat")) {
                    System.out.println("repeat!");
                    return new Repeat();
            }
		else if (type.equals("if")) {
                    System.out.println("if!");
                    return new If();
		}
		else if (type.equals("sum")) {
                    System.out.println("sum!");
                    return new Sum();
                }
		else if (type.equals("right")) {
                    System.out.println("right!");
                    return new Right();
                }
		else if (type.equals("left")) {
                    System.out.println("left!");
                    return new Left();
                }
		else if (type.equals("sum")) {
                    System.out.println("sum!");
                    return new Sum();
                }
		else if (type.equals("less")) {
                    System.out.println("less!");
                    return new Less();
                }
		else if (type.equals("setheading")) {
                    System.out.println("setheading!");
                    return new SetHeading();
                }
		else if (type.equals("towards")) {
                    System.out.println("Towards!");
                    return new Towards();
                }
		else {
			return null;
		}
	}

}
