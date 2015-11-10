/**
 * Implementation of part 1 of the assignment
 */
public class Implementation1 {
	public static void main(String[] args) {
		
//PART 1:
        System.out.println("Hello, World!");
        MathScalar a = new MathScalar(3.0);
        MathScalar b = new MathScalar(4.0);
        MathScalar c = a.multiply(b);
        System.out.println("c: " + c);
        double [][] m = {{1,0,1},{0,1,0},{1,1,0}};
        MathMatrix M1 = new MathMatrix(m);
        MathMatrix M2 = M1.multiply(a);
		
		System.out.println("M2: " + M2);
		
        try {
			MathMatrix M3 = M2.multiply(M1);
	        System.out.println("M3: " + M3);
		} catch (MathException e) {
			System.out.println("Wrong dimensions");
		}
        
		try {
			MathMatrix M4 = (MathMatrix) MathOp.multiply(a,M1);
			System.out.println("M4: " + M4);
		}catch (MathException e) {
			System.out.println("Wrong dimensions");
		} catch (Exception e) {
			System.out.println("Wrong parameters");
		}
        
	}

}