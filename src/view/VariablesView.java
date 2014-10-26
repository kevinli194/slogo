package view;

import java.util.List;

import model.VariablesList;

public class VariablesView extends DataViewComponents {

	public VariablesView(InputView input, double width, double height) {
		super(input, width, height);
		// TODO Auto-generated constructor stub
	}

	public void update(VariablesList variablesList) {
		myView.getChildren().clear();
		addLable("Variables:");
		List<String> variables = variablesList.generate();
		for (String s : variables) {
			addTextBoxWithDeleteButton(s, variablesList);
		}

	}
}
