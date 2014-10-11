package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InstructionsOnView {
	private SimpleStringProperty instruction;
	private SimpleStringProperty deleteButton;

	public InstructionsOnView(String instruction,String UDI) {
		this.instruction = new SimpleStringProperty(instruction);
		this.deleteButton=new SimpleStringProperty(UDI);

	}

	public String getInstruction() {
		return instruction.get();
	}
	public void setInstruction(String instr) {
		instruction.set(instr);
	}

	public String getDeleteButton() {
		return deleteButton.get();
	}
	public void setEmail(String deleteB) {
		deleteButton.set(deleteB);
	}

}
