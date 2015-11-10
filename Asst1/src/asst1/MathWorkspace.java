package asst1;

import java.util.Enumeration;
import java.util.Hashtable;
/**
 * Contains the Hashtable and functions of the Hashtable
 */
public class MathWorkspace implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Hashtable containing MathVariables
	 */
	private Hashtable <MathVariable, MathVariable> list = new Hashtable<MathVariable, MathVariable>();
	/**
	 * Add element to the Hashtable
	 * @param varToPut MathVariable to add
	 */
	public void insert(MathVariable varToPut) {
		list.put(varToPut, varToPut);
	}
	/**
	 * Search the Hashtable for a specific MathVariable by its name
	 * @param varToSearch MathVariable to search
	 * @return true if the MathVariable is found; <p>false otherwise
	 */
	public boolean search(MathVariable varToSearch){
		return list.containsKey(varToSearch);
	}
	/**
	 * Retrieve MathVariable from Hashtable
	 * @param varToGet MathVariable with name of MathVariable to return
	 * @return MathVariable with the same name as the parameter
	 */
	public MathVariable getValue(MathVariable varToGet){
		return list.get(varToGet);
		
	}
	/**
	 * Print the elements in the Hashtable
	 * <p>Will print the names of the MathVariables
	 * @return false if the Hashtable is empty; <p>true otherwise
	 */
	public boolean listValues(){
		if (list.isEmpty())
			return false;
		else
		{
			Enumeration<MathVariable> items = list.keys();
			while(items.hasMoreElements())
				     System.out.println(items.nextElement());
			return true;
		}
	}
	/**
	 * Delete specific element in the Hashtable
	 * @param varToDelete MathVariable with name of MathVariable to delete
	 * @return false if Hashtable doesn't contain the element to delete;
	 * <p>true if Hashtable contains element
	 */
	public boolean deleteValue(MathVariable varToDelete) {
		if (!list.containsKey(varToDelete))
			return false;
		else
		{
			list.remove(varToDelete);
			return true;
		}
		
	}
	/**
	 * Replace MathVariable in the Hashtable with same name as the MathVariable parameter
	 * @param varToReplace MathVariable which will replace the one in the Hashtable
	 */
	public void replaceValue(MathVariable varToReplace) {
		list.replace(varToReplace, varToReplace);
	}
	/**
	 * Clear all elements in the Hashtable
	 */
	public void clearValues() {
		list.clear();
	}
}
