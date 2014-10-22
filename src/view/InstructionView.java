package view;

import instructions.Instruction;

import java.util.List;
import java.util.Map;

public class InstructionView extends SideView {

	public InstructionView(InputView input, double width, double height) {
		super(input, width, height);
	}

	public void update(List<String[]> instructions) {
		myView.getChildren().clear();
		for (String s : instructions.get(0)) {
			addTextBox(s);
		}
		for (String s:instructions.get(1)){
			addTextBoxWithDeleteButton(s);
		}
	}

}
