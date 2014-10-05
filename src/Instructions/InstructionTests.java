package Instructions;

import parser.Forward;

public class InstructionTests {

	@Test
	public void testGetNumParams() {
		Instruction f = new Forward();
		assertEquals(1, f.getNumParams());
		
		Instruction constant = new ConstantInstruction(5.3);
		assertEquals(0, constant.getNumParams());
	}
	
	@Test
	public void testAddParams() {
		ParameterInstruction f = new Forward();
		f.addParam(50);
		assertEquals(1, f.myParams.size());
		assertEquals(50, f.myParams.get(0));
	}
	
	@Test
	public void testEvaluate() {
		Instruction f = new Forward();
		f.addParam(50);
		assertEquals(50, f.evaluate());
		
		Instruction sum = new Sum();
		sum.addParam(3);
		sum.addParam(4);
		assertEquals(3+4, sum.evaluate());
	}
}

