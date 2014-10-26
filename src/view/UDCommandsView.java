package view;

import java.util.List;

import model.CommandsList;
/**
 * Part of DataView which shows User-Defined Commands
 * @author Mengen Huang
 * @author Kevin Li
 *
 */
public class UDCommandsView extends DataViewComponents {

	/**
	 * 
	 * @param input inputView
	 * @param width width of super class ScrollView
	 * @param height height of super class ScrollView
	 */
	public UDCommandsView(InputView input, double width, double height) {
		super(input, width, height);
	}

	/**
	 * Update as part of Observer. Update when the Observable data changes
	 * @param commandsList
	 */
	public void update(CommandsList commandsList) {
		myView.getChildren().clear();
		List<String[]> instructions = commandsList.generate();
		for (String s : instructions.get(1)) {
			addTextBoxWithDeleteButton(s, commandsList);
		}

	}

}
