import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Homework0223 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the file manager.");

		try {
			while (true) {
				System.out.println("");
				System.out.println("What would you like to do?");
				System.out.println("(C)reate new file");
				System.out.println("(R)ename existing file");
				System.out.println("(D)elete existing file");
				System.out.println("E(X)it program");

				String s = sc.next();
				switch (s) {
				case "C":
					create(sc);
					break;
				case "R":
					rename(sc);
					break;
				case "D":
					delete(sc);
					break;
				case "X": {
					System.out.println("Goodbye.");
					System.exit(0);
				}
				default:
					System.out.println("Invalid input.");
				}
			}
		} catch (IOException ioe) {
			System.out.println("IOException caught.");
			System.exit(-1);
		} finally {
			sc.close();
		}

	}

	// Creates a new file with a user-input name.
	public static void create(Scanner sc) throws IOException {
		System.out.print("File Name: ");
		String s = sc.next();
		File f = new File(s);
		if(f.createNewFile()) {
			System.out.println("Success!");
		} else {
			System.out.println("There was an error...");
		}
	}

	// Renames a file specified by user input to a new user-input name.
	public static void rename(Scanner sc) throws IOException {
		System.out.print("Existing File Name: ");
		String s = sc.next();
		File existing = new File(s);
		System.out.print("New File Name: ");
		String n = sc.next();
		File newFile = new File(n);
		if(existing.renameTo(newFile)) {
			System.out.println("Success!");
		} else {
			System.out.println("There was an error...");
		}
	}

	// Deletes a file with a user-input name.
	public static void delete(Scanner sc) {
		System.out.print("File Name: ");
		String s = sc.next();
		File f = new File(s);
		if(f.delete()) {
			System.out.println("Success!");
		} else {
			System.out.println("There was an error...");
		}
	}
}