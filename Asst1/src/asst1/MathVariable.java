package asst1;

public class MathVariable implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * MathObject field
	 */
	protected MathObject mathObj;
	/**
	 * Name of the MathObject
	 */
	protected String varName;
	/**
	 * Default constructor
	 */
	public MathVariable() {
		this.varName = "Undefined";
	}
	/**
	 * Constructor to specify the MathObject and the name
	 * @param mObj MathObject to store
	 * @param vName Name to store
	 */
	public MathVariable(MathObject mObj, String vName) {
		this.mathObj = mObj;
		this.varName = vName;
	}
	/**
	 * equals method overridden for MathVariables
	 * @param o the reference object with which to compare
	 * @return true if the two MathVariables are equal; <p>false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof MathVariable) {
			MathVariable val = (MathVariable)o;
			return (this.varName.equals(val.varName));
		}
		else
			return false;
	}
	/**
	 * toString method overridden for MathScalar
	 * <p>Used for printing
	 * @return Value of the scalar
	 */
	@Override
	public String toString() {
		return varName;
	}
	/**
	 * hashCode method overridden in order to use a Hashtable
	 * with MathVariables in it
	 * @return Pseudo-randomly generated hash integer
	 */
	@Override
	public int hashCode() {
		int hash = 11;
		hash = 7*hash + this.varName.hashCode();	
		hash = 7*hash + this.varName.hashCode();
		return hash;
	}
	
}
