package Instructions;

/**
 * Interface of all the intstructions
 *
 */
public interface Instruction {

	/**
	 * execute the instructions on model
	 * @param model : simulation of all the GUI elements
	 * @return the integer of the instruction value
	 */
	public int execute(Model model);
}
