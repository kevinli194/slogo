package parser;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import Instructions.Instruction;

/**
 * Factory design pattern for creating 
 * instances of different instructions
 *
 */
public class InstructionFactory {
	ResourceBundle languageBundle;
	Map<String,String> languageMap;
	
	/**
	 * Takes a string type of instruction and
	 * instantiates the class based on the type
	 * @param type String name of type of instruction
	 * @return Instruction class of that type
	 */
	
	public InstructionFactory() {
		languageMap = createLanguageMap(languageBundle);
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
		return null;
	}

}
