public class MathScalar extends MathObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Value of the scalar
	 */
	protected double scalarValue;
	/**
	 * Default constructor
	 */
	public MathScalar() {
		this.scalarValue = 0;		
	}
	/**
	 * Constructor to specify scalar value
	 * @param val Value of scalar
	 */
	public MathScalar(double val) {
		this.scalarValue = val;		
	}
	/**
	 * Multiply two MathScalars
	 * @param scal The MathScalar to multiply
	 * @return Product of the two MathScalars
	 */
	public MathScalar multiply(MathScalar scal) {
		MathScalar retScal = new MathScalar(this.scalarValue*scal.scalarValue);
		return retScal;
	}
	
	public MathScalar add(MathScalar scal) {
		MathScalar retScal = new MathScalar(this.scalarValue+scal.scalarValue);
		return retScal;
	}
	/**
	 * equals method overridden for MathScalars
	 * @param o the reference object with which to compare
	 * @return true if the two MathScalars are equal; <p>false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof MathScalar) {
			MathScalar scal = (MathScalar)o;
			return (this.scalarValue == scal.scalarValue);
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
		return "\t" + Double.toString(scalarValue);
	}
	
	public double getScal() {
		return this.scalarValue;
	}
}