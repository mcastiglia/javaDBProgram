package me.mvcastiglia.jdbp.misc;
import java.util.InputMismatchException;
import java.util.Scanner;

// QuadraticSolver
public class Homework0205 {
    public static void main(String[] args) {
        int a,b,c = 0;
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Value for a: ");
            a = scan.nextInt();

            System.out.print("Value for b: ");
            b = scan.nextInt();

            System.out.print("Value for c: ");
            c = scan.nextInt();
            
            scan.close();

            int determinant = b * b - 4 * a * c;
            
            int root1 = (-b + (int) Math.sqrt(determinant)) / (2 * a);
            int root2 = (-b - (int) Math.sqrt(determinant)) / (2 * a);
            System.out.format("root1 = %.2f and root2 = %.2f", root1, root2);
        } catch(InputMismatchException e) {
            System.out.println("You entered an incorrect value");
            System.exit(1);
        } catch(ArithmeticException e) {
            System.out.println("You can't divide by zero");
            System.exit(2);
        }
    }
}
