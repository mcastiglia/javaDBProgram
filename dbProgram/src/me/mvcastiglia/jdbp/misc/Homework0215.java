package me.mvcastiglia.jdbp.misc;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework0215
{	
	/*
	 * Define any custom Exceptions here.
	 * In this assignment, you do not have to use a constructor if you don't want.
	 */
	public static class NotAnInverseTrigFunctionException extends Exception {}
	public static class ArcsineDomainOutOfBoundsException extends Exception {}
	public static class ArccosineDomainOutOfBoundsException extends Exception {}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String f = "";
		float[] x = {0.0f, 0.0f};

		while(true)
		{
			try {
			//Encase all of this in a try-catch block.
			f = getFunction(sc);
			/* 
			 * If f isn't one of asin, acos, or atan, 
			 * throw a NotAnInverseTrigFunctionException.
			 *
			 * Try to run the function specified by f and set x equal to the output. 
			 * Catch any Exceptions it might throw.
			 */
			if (f.equalsIgnoreCase("asin")) {
				asin(sc);
			} else if (f.equalsIgnoreCase("acos")) {
				acos(sc);
			} else if (f.equalsIgnoreCase("atan")) {
				atan(sc);
			} else {
				throw new NotAnInverseTrigFunctionException();
			}
			break;
			} catch(NotAnInverseTrigFunctionException e) {
				System.out.println("Enter a valid function");
				continue;
			} catch(ArcsineDomainOutOfBoundsException e) {
				System.out.println("Invalid value.");
				continue;
			} catch(ArccosineDomainOutOfBoundsException e) {
				System.out.println("Invalid value.");
				continue;
			} catch(InputMismatchException e) {
				System.out.println("Invalid value.");
				continue;
			}
		}
		
		sc.close();
		System.out.println(f + "(" + x[0] + ") = " + x[1]);
	}
	
	public static String getFunction(Scanner sc)
	{
		System.out.println("Enter the inverse trig function to solve: ");
		return sc.next();
	}
	
	/*
	 * Define asin and acos functions with behavior similar to the atan function below.
	 * The input for both should be a Scanner, and the output should be an array of two floats.
	 * 
	 * Construct asin so that it throws InputMismatchException and ArcsineDomainOutOfBoundsException.
	 * Construct acos so that it throws InputMismatchException and ArccosineDomainOutOfBoundsException.
	 * 
	 * In both functions, if the user inputs something more than 1, or less than -1, 
	 * throw the appropriate Exception.
	 */
	
	public static float[] atan(Scanner sc) throws InputMismatchException
	{
		System.out.println("Enter the tangent of the angle: ");
		float x = sc.nextFloat();
		
		float[] f = {x, (float)Math.toDegrees(Math.atan(x))};
		return f;
	}
	
	public static float[] asin(Scanner sc) throws InputMismatchException, ArcsineDomainOutOfBoundsException
	{
		System.out.println("Enter the sine of the angle: ");
		float x = sc.nextFloat();
		if (x < -1 && x > 1) {
			throw new ArcsineDomainOutOfBoundsException();
		}
		
		float[] f = {x, (float)Math.toDegrees(Math.asin(x))};
		return f;
	}	
	
	public static float[] acos(Scanner sc) throws InputMismatchException, ArccosineDomainOutOfBoundsException
	{
		System.out.println("Enter the cosine of the angle: ");
		float x = sc.nextFloat();
		if (x < -1 && x > 1) {
			throw new ArccosineDomainOutOfBoundsException();
		}
		
		float[] f = {x, (float)Math.toDegrees(Math.acos(x))};
		return f;
	}	
}