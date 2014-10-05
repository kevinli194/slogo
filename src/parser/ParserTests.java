package parser;

import java.util.Stack;

import Instructions.*;

public class ParserTests {

	public void testParse() {
		Parser p = new Parser();
		Stack<Instruction> test = p.parse("FORWARD 50");
		
		Stack<Instruction> expected = new Stack<Instruction>();
		
		Instruction instr1 = new ConstantInstruction(50);
		Instruction instr2 = new Forward();
		// Add parameter of 50 to the forward command
		instr2.addParam(50);
		expected.push(instr1);
		expected.push(instr2);
		
		assertEquals(expected, test);
		
	}

}
