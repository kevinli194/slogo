package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import error_checking.ErrorDialog;
import error_checking.InvalidArgumentsException;


/**
 * VariablesList class. Maps variables to values and error checks for those
 * variables. This class is to be accessed by the commands.
 * @author slogo_team02 a.k.a. TEAM ROCKET 
 *		   a.k.a. Mengen Huang, Kevin Li, Jennie Ju, Sandy Lee
 *
 */

public class VariablesList implements Feature {
    private Map<String, Double> myVariables;
    private Stack<Map<String, Double>> myScope;
    
    private static final long serialVersionUID = 3790539722809452079L;

    /**
     * Instantiate the variable list.
     */
    public VariablesList() {
        myVariables = new HashMap<String, Double>();
        myScope = new Stack<Map<String, Double>>();
    }

    /**
     * Add variable name and value into variable list.
     * @param variableName name of the variable
     * @param value value of the variable
     */
    public void add(String variableName, double value) {
        myVariables.put(variableName, value);
    }

    /**
     * Add in scope.
     */
    public void addScope() {
        myScope.push(myVariables);
        myVariables = new HashMap<String, Double>(myVariables);
    }

    /**
     * Remove the variable from the list.
     */
    @Override
    public void remove(Object variableName) throws InvalidArgumentsException {
    	try {
    		if (!myVariables.containsKey(variableName)) {
    			new ErrorDialog("Variable %s does not exist.", variableName);
    			throw new InvalidArgumentsException(
    					"Variable %s does not exist.", variableName.toString());

    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	myVariables.remove(variableName);
    }

    /**
     * Remove the variable from the scope.
     */
    public void removeScope() {
        myVariables = myScope.pop();
    }

    /**
     * Get the variable according to the name of the variable.
     * @param variableName the name of the variable
     * @return Return the value of the variable
     * @throws InvalidArgumentsException throw the exception when the variable name
     * does not exist
     */
    public double get(String variableName) throws InvalidArgumentsException {
        if (!myVariables.containsKey(variableName)) {
            new ErrorDialog("Variable %s does not exist.", variableName);
            throw new InvalidArgumentsException(
            		"Variable %s does not exist.", variableName);
        }
        return myVariables.get(variableName);
    }

    /**
     * Generate the list of the variable name and value.
     * to pass to the front-end view package.
     * @return list of the string representing variable name and value
     */
    public List<String> generate() {
        List<String> variableList = new ArrayList<String>();
        for (String s : myVariables.keySet()) {
            System.out.println(s);
            String element = s.trim().substring(1) + " : " + myVariables.get(s);
            variableList.add(element);
        }
        return variableList;
    }

    /**
     * Clears list of variables.
     */

    @Override
    public void clear() {
        myVariables.clear();
    }

}
