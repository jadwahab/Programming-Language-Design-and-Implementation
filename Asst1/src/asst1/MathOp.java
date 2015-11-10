 package asst1;
/**
 * For math operations
 */
public class MathOp extends MathObject {
	/**
	 * Multiply two MathObjects
	 * @param obj1 First MathObject to be multiplied
	 * @param obj2 Second MathObject to be multiplied
	 * @return Product of the two MathObjects
	 * @throws Exception if the two parameters are not either two MathScalars
	 * or two MathMatrices or a MathScalar and a MathMatrix
	 * @see MathScalar multiply, {@link MathScalar#multiply(MathScalar)}
	 * @see MathMatrix multiply(MathScalar), {@link MathMatrix#multiply(MathScalar)}
	 * @see MathMatrix multiply(MathMatrix), {@link MathMatrix#multiply(MathMatrix)}
	 */
	public static MathObject multiply(MathObject obj1, MathObject obj2) throws Exception {
		
		if (obj1 instanceof MathScalar) {
			if (obj2 instanceof MathScalar) {
				return ((MathScalar) obj1).multiply((MathScalar)obj2);
			}
			if (obj2 instanceof MathMatrix) {
				return ((MathMatrix) obj2).multiply((MathScalar)obj1);
			}
		}
		
		else if (obj1 instanceof MathMatrix) {
			if (obj2 instanceof MathScalar) {
				return ((MathMatrix) obj1).multiply((MathScalar)obj2);
			}
			if (obj2 instanceof MathMatrix) {
				return ((MathMatrix) obj1).multiply((MathMatrix)obj2);
			}
		}
		else {
			throw new Exception("Wrong parameters");
		}
		
		return null;
	}



}
