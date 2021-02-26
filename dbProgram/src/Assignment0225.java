import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Assignment0225 {
	public static void main(String[] args) throws IOException,FileNotFoundException {
		File f = new File("assets/scannerexample.txt");
		f.createNewFile();
		Scanner scan = new Scanner(f);
		
		try {
		System.out.println(scan.next());
		} catch(NoSuchElementException e) {
			System.out.println("There is nothing more in the file!");
		}
		
		scan.close();
		
		Example2();
		
		Example3();
	}
	
	public static void Example2() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int x = scan.nextInt();
		System.out.print("Enter a string: ");
		String y = scan.nextLine();
		System.out.println("You entered " + x + " and " + y + ".");
		scan.close();
	}
	
	public static void Example3() {
		System.out.printf("\n%3c",'a'); 		
		System.out.printf("\n%5s","abc");	
		System.out.printf("\n%5d",10);		
		System.out.printf("\n%.1f",5.73);	
		System.out.printf("\n%.4f",5.73);	
		System.out.printf("\n%10.2f",5.73);	
		System.out.printf("\n%010.2f",5.73);
		System.out.printf("\n%010.5f",5.73);
		System.out.printf("\n%010.2e",5.73);
		System.out.printf("\n%10e",5.73);
	}
}
