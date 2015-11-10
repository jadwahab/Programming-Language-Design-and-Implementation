import java.util.Vector;
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
	
	public static MathObject add(MathObject obj1, MathObject obj2) throws Exception {
		
		if (obj1 instanceof MathScalar) {
			if (obj2 instanceof MathScalar) {
				return ((MathScalar) obj1).add((MathScalar)obj2);
			}
			if (obj2 instanceof MathMatrix) {
				return ((MathMatrix) obj2).add((MathScalar)obj1);
			}
		}
		
		else if (obj1 instanceof MathMatrix) {
			if (obj2 instanceof MathScalar) {
				return ((MathMatrix) obj1).add((MathScalar)obj2);
			}
			if (obj2 instanceof MathMatrix) {
				return ((MathMatrix) obj1).add((MathMatrix)obj2);
			}
		}
		else {
			throw new Exception("Wrong parameters");
		}
		
		return null;
	}
	
	public static MathObject u_minus(MathObject obj) {
		MathScalar minus = new MathScalar(-1.0);

		if (obj instanceof MathMatrix)
			return ((MathMatrix) obj).multiply(minus);
		else
			return((MathScalar) obj).multiply(minus);
		
	}

	public static MathObject call(String func, Vector<MathObject> v) {
		
		if (func.equals("disp")) {
			System.out.println(v.firstElement());
			return v.firstElement();
		}
		
		if (func.equals("size")) {
			if (v.size()==1) {
				double [][] m = new double [1][2];
				m[0][0] = ((MathMatrix) v.firstElement()).getRows();
				m[0][1] = ((MathMatrix) v.firstElement()).getColumns();
				return new MathMatrix(m);
			}
			else //if size=2
				return new MathScalar(((MathMatrix)v.firstElement()).getCols( (int) ((MathScalar) v.get(1)).getScal()-1 ));
		}
		else
			return null;
	
	}
	
	public static MathMatrix createSequence(MathObject start, MathObject end) {
		double s = ((MathScalar) start).getScal();
		double e = ((MathScalar) end).getScal();
		int n = ((int)e)-((int)s);
		double [][] m = new double[1][n+1];
		 for (int i=0; i<=(e-s); i++)
			m[0][i] = s+i;
		 return new MathMatrix(m);
	}

}
