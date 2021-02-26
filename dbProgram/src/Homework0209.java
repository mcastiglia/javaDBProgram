import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework0209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Get input.
		String f = "";

		// encase all of this in a while loop
		while (true) {
			// try to get input on f
			// use f.equalsIgnoreCase("sin"), etc.
			// if it's NOT "sin", "cos", "tan", "cot", "sec", "csc"
			// throw an IllegalArgumentException
			try {
				System.out.print("Enter the trigonometric function to solve: ");
				f = sc.next();
				if (!(f.equalsIgnoreCase("sin") || f.equalsIgnoreCase("cos") || f.equalsIgnoreCase("tan")
						|| f.equalsIgnoreCase("cot") || f.equalsIgnoreCase("sec") || f.equalsIgnoreCase("csc"))) {
					throw new IllegalArgumentException("Please try again");
				} else {
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Please try again");
			}
			// catch that IllegalArgumentException right here
			// handle it by having the user try again

		}

		double theta = 0.0f;
		boolean tryAgain = true;

		while (tryAgain) {
			try {
				System.out.print("Enter the angle: ");
				theta = sc.nextDouble();
				tryAgain = false;
			} catch (InputMismatchException ime) {
				System.out.println("Angle must be numeric. Try again.");
			}
		}

		sc.close();

		// Calculate the function.
		double value = 0.0f;

		switch (f) {
			case "sin": {
				value = sin(theta);
				break;
			}
			case "cos": {
				value = cos(theta);
				break;
			}
			case "tan": {
				try {
					// try to get tan(theta)
					value = tan(theta);
					// catch any IllegalArgumentException that is thrown
					// handle it by printing undefined
					// then use System.exit(0);
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("Undefined.");
					System.exit(0);
				}

				// repeat for cot, sec, and csc
			}
			case "cot": {
				try {
					// try to get tan(theta)
					value = cot(theta);
					// catch any IllegalArgumentException that is thrown
					// handle it by printing undefined
					// then use System.exit(0);
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("Undefined.");
					System.exit(0);
				}
			}
			case "sec": {
				try {
					// try to get tan(theta)
					value = sec(theta);
					// catch any IllegalArgumentException that is thrown
					// handle it by printing undefined
					// then use System.exit(0);
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("Undefined.");
					System.exit(0);
				}
			}
			case "csc": {
				try {
					// try to get tan(theta)
					value = csc(theta);
					// catch any IllegalArgumentException that is thrown
					// handle it by printing undefined
					// then use System.exit(0);
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("Undefined.");
					System.exit(0);
				}
			}
		}

		System.out.println(f + "(" + theta + ") = " + value);
	}

	// Calculations
	public static double sin(double theta) {
		return Math.sin(Math.toRadians(theta));
	}

	public static double cos(double theta) {
		return Math.cos(Math.toRadians(theta));
	}

	public static double tan(double theta) throws IllegalArgumentException {

		if ((theta % 360 == 90) || (theta % 360 == 270)) {
			throw new IllegalArgumentException("Undefined.");
		}
		return Math.tan(Math.toRadians(theta));

		// repeat for cot, sec, and csc
	}

	public static double cot(double theta) throws IllegalArgumentException {
		if ((theta % 360 == 0) || (theta % 360 == 180)) {
			throw new IllegalArgumentException("Undefined.");
		}
		return 1.0f / Math.tan(Math.toRadians(theta));
	}

	public static double sec(double theta) throws IllegalArgumentException {
		if ((theta % 360 == 90) || (theta % 360 == 270)) {
			throw new IllegalArgumentException("Undefined.");
		}
		return 1.0f / Math.cos(Math.toRadians(theta));
	}

	public static double csc(double theta) throws IllegalArgumentException {
		if ((theta % 360 == 0) || (theta % 360 == 180)) {
			throw new IllegalArgumentException("Undefined.");
		}
		return 1.0f / Math.sin(Math.toRadians(theta));
	}
}