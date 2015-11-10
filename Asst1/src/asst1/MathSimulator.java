package asst1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 * Simulates the user interface
 */
public class MathSimulator {
	/**
	 * The workspace to use
	 */
	MathWorkspace workspace = new MathWorkspace();
	/**
	 * The choice made by the user
	 */
	int menuChoice;
	/**
	 * the name entered by the user
	 */
	String vName;
	/**
	 * For inputs
	 */
	Scanner menuChoiceScan = new Scanner(System.in);
	/**
	 * Default constructor
	 */
	public MathSimulator() {
		
		try{
		workspace = deserialize();
		} catch (MathException m){
			System.out.println("Initial Run");			
		}
		
		while (true) {
			System.out.println("1) Define scalar variable");
			System.out.println("2) Define matrix variable");
			System.out.println("3) Set value");
			System.out.println("4) Print value");
			System.out.println("5) Perform multiplication");
			System.out.println("6) List all variables");
			System.out.println("7) Clear all variables");
			System.out.println("8) Quit\n");
			System.out.println("Select your choice:");
			
			menuChoice = menuChoiceScan.nextInt();	
			
			if (menuChoice == 1) {
				choice1();
			}
			else if (menuChoice == 2) {
				choice2();
			}
			else if (menuChoice == 3) {
				choice3();
			}
			else if (menuChoice == 4) {
				choice4();
			}
			else if (menuChoice == 5) {
				choice5();
			}
			else if (menuChoice == 6) {
				choice6();
			}
			else if (menuChoice == 7) {
				choice7();
			}
			else {
				break;
			}
			System.out.println();
		} // end while
		
		serialize(workspace);
		
	} // end constructor
	/**
	 * Choice 1: Define scalar variable	
	 */
	private void choice1() {
		System.out.println("%%%Menu item 1: Define scalar variable");
		System.out.print("Enter variable name: ");
		vName = menuChoiceScan.next();
		MathVariable varCreated = new MathVariable();

		varCreated.varName = vName;
		MathScalar mathScal = new MathScalar();
		varCreated.mathObj = mathScal; 
		if (workspace.search(varCreated))
			System.out.println("Cannot create variable " + vName + ". A variable with the same name already exists!");
		else {
			workspace.insert(varCreated);
			System.out.println("Your scalar " + vName + " is now defined");
		}

	}
	/**
	 * Choice 2: Define matrix variable
	 */
	private void choice2() {
		System.out.println("%%%Menu item 2: Define matrix variable");
		System.out.print("Enter matrix name: ");
		vName = menuChoiceScan.next();
		MathVariable varCreated = new MathVariable();

		varCreated.varName = vName;
		if (workspace.search(varCreated)) {
			System.out.println("Cannot create variable " + vName + ". A variable with the same name already exists!");
			return;
		}
		
		System.out.print("Enter the dimensions of your matrix: ");
		int a,b;
		a = menuChoiceScan.nextInt();
		b = menuChoiceScan.nextInt();
		
		double [][] mat = new double [a][b];
		MathMatrix mathMat = new MathMatrix(mat);
		varCreated.mathObj = mathMat;
		
		workspace.insert(varCreated);
		System.out.println("Your scalar " + vName + " is now defined");
	}
	/**
	 * Choice 3: Set value
	 */
	private void choice3() {
		System.out.println("%%%Menu item 3: Set value");
		System.out.print("Enter variable name: ");
		vName = menuChoiceScan.next();
		MathVariable varCreated = new MathVariable();

		varCreated.varName = vName;
		
		if (workspace.getValue(varCreated).mathObj instanceof MathScalar) {
			System.out.print("Enter the scalar value: ");
			double scal = menuChoiceScan.nextDouble();
			MathScalar mathScal = new MathScalar(scal);
			
			varCreated.mathObj = mathScal;
			workspace.replaceValue(varCreated);
			System.out.println("The value of "+ vName +" is now set to "+ scal);
		}
		else {
			varCreated = workspace.getValue(varCreated);
			MathMatrix mathMat = (MathMatrix)varCreated.mathObj;
			int rows = mathMat.getRows();
			int cols = mathMat.getColumns();
			System.out.print("Enter the values in "+ vName +"("+ rows +"x"+ cols +"): ");
			double [][] mat = new double [rows][cols];
			
			for (int i=0; i<rows; i++)
				for (int j=0; j<cols; j++) {
					mat[i][j] = menuChoiceScan.nextDouble();
				}
			
			mathMat.matrixArray = mat;
			varCreated.mathObj = mathMat;
			workspace.replaceValue(varCreated);
			System.out.println("Variable "+ vName +" is now set to:");
			System.out.println(mathMat);
		}
				
	}
	/**
	 * Choice 4: Print value
	 */
	private void choice4() {
		System.out.println("%%%Menu item 4: Print value");
		System.out.print("Enter variable name: ");
		vName = menuChoiceScan.next();
		MathVariable varCreated = new MathVariable();
		
		varCreated.varName = vName;
		varCreated = workspace.getValue(varCreated);
		System.out.println("The value of "+vName+" is "+varCreated.mathObj);
		
	}
	/**
	 * Choice 5: Perform multiplication
	 */
	private void choice5() {
		System.out.println("%%%Menu item 5: Perform multiplication");
		System.out.print("Enter left variable name: ");
		String lVar = menuChoiceScan.next();
		
		MathVariable varCreated = new MathVariable();
		varCreated.varName = lVar;
		varCreated = workspace.getValue(varCreated);
		
		System.out.print("Enter right variable name: ");
		String rVar = menuChoiceScan.next();
		MathVariable varCreated2 = new MathVariable();
		varCreated2.varName = rVar;
		varCreated2 = workspace.getValue(varCreated2);
		
		System.out.print("Enter variable name where you want to store the result: ");
		vName = menuChoiceScan.next();
		MathVariable varToStore = new MathVariable();
		varToStore.varName = vName;
		
		try {
			varToStore.mathObj = MathOp.multiply(varCreated.mathObj, varCreated2.mathObj);
		} catch (MathException e) {
			System.out.println("Error: incompatible dimensions");
			return;
		} catch (Exception e) {
			System.out.println("Error: incompatible parameters");
			return;
		}
		
		workspace.replaceValue(varToStore);
		System.out.println("Stored");
	}
	/**
	 * Choice 6: List variables
	 */
	private void choice6() {
		System.out.println("%%%Menu item 6: List Variables");
		System.out.println("Variable list:");
		workspace.listValues();		
	}
	
	private void choice7() {
		System.out.println("%%%Menu item 7: Clear Variables");
		workspace.clearValues();
	}
	/**
	 * Serialization
	 * @param wrkspc the MathWorkspace that contains the Hashtable
	 */
	private void serialize(MathWorkspace wrkspc) {
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("/tmp/workspace.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(wrkspc);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/workspace.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	/**
	 * Deserialization
	 * @return MathWorkspace that contains the Hashtable
	 * @throws MathException if the class in not found
	 */
	private MathWorkspace deserialize() throws MathException{
		try
	      {
	         FileInputStream fileIn = new FileInputStream("/tmp/workspace.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         MathWorkspace wrkspc = (MathWorkspace) in.readObject();
	         in.close();
	         fileIn.close();
	         return wrkspc;
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Workspace class not found");
	         c.printStackTrace();
	         throw new MathException();
	      }
	}
}
