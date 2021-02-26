import java.util.Scanner;
import java.util.InputMismatchException;

// Exception Examples
public class Assignment0205 {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter two integers to divide: ");
	    
	    int x = 0, y = 0;
	    
	    // InputMismatchException
        try {
           x = scan.nextInt();
           y = scan.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Hey, you can't do that!");
        }
        // then, keep going
        System.out.println("x = " + x);

        // Arithmetic Exception
        try {
            System.out.println("The quotient is " + x/y + ".");
        } catch(ArithmeticException e) {
            System.out.println("Can't divide by zero!");
        }

        scan.close();
	}
}
