package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InstructionsOnView {
	private SimpleStringProperty instructions;
//	private StringProperty instructions;
//	public void setInstruction(String value) { instructionProperty().set(value); }
//	public String getInstruction() { return instructionProperty().get(); }
//	public StringProperty instructionProperty() { 
//		if (instructions == null) instructions = new SimpleStringProperty(this, "instructions");
//		return instructions; 
//	}
	
	private SimpleStringProperty deleteButton;
	public InstructionsOnView(String instr, String delete){
		this.instructions=new SimpleStringProperty(instr);
		this.deleteButton=new SimpleStringProperty(delete);
	}

}
