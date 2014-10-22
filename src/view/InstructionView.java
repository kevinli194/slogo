package view;

import instructions.Instruction;

import java.util.List;
import java.util.Map;

public class InstructionView extends SideView {

	public InstructionView(InputView input) {
		super(input);
	}

	public void update(List<Map<String, Instruction>> instructions) {
		myView.getChildren().clear();
		for (String s : instructions.get(0).keySet()) {
			addTextBox(s);
		}
	}
}
