package view;

import java.util.List;

import model.VariablesList;

/**
 * Part of DataView which shows all the User-defined variables
 * @author Mengen Huang
 * @author Kevin Li
 *
 */
public class VariablesView extends DataViewComponents {
/**
 * @param input InputView
 * @param width width of super class ScrollView
 * @param height height of super class ScrollView
 */
	public VariablesView(InputView input, double width, double height) {
		super(input, width, height);
	}

	/**
	 * Update as part of Observer. Update when the Observable data changes
	 * @param variablesList list of variables stored in model
	 */
	public void update(VariablesList variablesList) {
		myView.getChildren().clear();
		List<String> variables = variablesList.generate();
		for (String s : variables) {
			addTextBoxWithDeleteButton(s, variablesList);
		}

	}
}
