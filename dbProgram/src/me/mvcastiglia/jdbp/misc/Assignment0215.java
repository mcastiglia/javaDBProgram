package me.mvcastiglia.jdbp.misc;
public class Assignment0215 {
	public static void main(String[] args) {
		// this always runs
		System.out.println("Before the try-catch.");
		try {
			// this always runs
			System.out.println("In the try block.");
			throw new RuntimeException();
		} catch (ArithmeticException ae) {
			// this runs only if the Exception is caught here
			System.out.println("In the catch block.");
		} finally {
			// this ALWAYS runs
			System.out.println("In the finally block.");
		}
		// this won't run if the Exception isn't handled properly
		System.out.println("After the try-catch.");
	}
}