package me.mvcastiglia.jdbp.misc;
import java.io.*;
import java.util.Scanner;

public class Homework0225 {
	public static void main(String[] args) {
		System.out.println("Welcome to the file editor.");
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				System.out.println("");
				System.out.println("What would you like to do?");
				System.out.println("(P)rint contents of file");
				System.out.println("(E)dit existing file");
				System.out.println("E(X)it program");

				String s = sc.next();
				switch (s) {
				case "P":
					printFile(sc);
					break;
				case "E":
					editFile(sc);
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
		}
	}

	public static void printFile(Scanner sc) throws IOException {
		System.out.print("Enter filename to read from: ");
		// Scan for user input.
		// Create a new File object using the user-input name.
		String x = sc.next();
		File f = new File(x);

		// Check if a file with the user-input name *doesn't* exist.
		if(!f.exists()) {

		// If it doesn't, print a new line stating that this file doesn't exist.
		// Then return.
			System.out.println("Error: This file does not exist.");
			return;
		}

		// Use a try-with-resources to create a new Scanner which will scan from the
		// file.
		try(Scanner scan = new Scanner(f)) {

		// while the file has a next line
			while(scan.hasNextLine()) {

		// print that next line
				System.out.println(scan.nextLine());
			}
			
		}

	}

	public static void editFile(Scanner sc) throws IOException {
		System.out.println("Enter filename to edit: ");
		// Scan for user input.
		// Create a new File object using the user-input name.
		String x = sc.next();
		File f = new File(x);

		// Check if a file with the user-input name *doesn't* exist.
		if(!f.exists()) {

		// If it doesn't, print a new line stating that this file doesn't exist.
		// Then print a new line asking if the user wants to create the file.
		// Scan for user input.
		// Check if the input is Y or y.
			System.out.println("This file does not exist. Would you like to create it (y/N): ");
			if(sc.next().equalsIgnoreCase("y")) {
				f.createNewFile();
			}
		// If it is, then create the file.
		// Otherwise, return.
			else {
				return;
			}
		}

		// Use Scanner.nextLine() here if there's any input bugs.
		// What do you mean by "any input bugs"?

		// Loop infinitely.
		while(true) {
			// Print a line asking if the user wants to append the file, or overwrite the
			// file.
			// Scan for user input.
			System.out.println("Append or overwrite file? (a,O): ");
			x = sc.next();

			// Use Scanner.nextLine() here if there's any input bugs.
			// What do you mean by "any input bugs"?

			// If the user wants to append, then go to appendFile using the Scanner and the
			// File.
			// Then return.
			if(x.equalsIgnoreCase("a")) {
				appendFile(sc,f);
				return;
			}
			// If the user wants to overwrite, then go to overwriteFile using the Scanner
			// and the File.
			// Then return.
			else if(x.equalsIgnoreCase("o")) {
				overwriteFile(sc,f);
				return;
			}

		}

		// Otherwise, loop around.
	}

	public static void appendFile(Scanner sc, File f) throws FileNotFoundException {
		// Use a try-with-resources to create a new PrintWriter which will write to the
		// file and set the append flag to true.
		try(PrintWriter pw = new PrintWriter(new FileOutputStream(f,true))) {
			// Print a line to the screen asking the user what text they want to put in the
			// file.
			// Scan for user input.
			// Then use the PrintWriter to print the user input into the file.
			System.out.println("Enter text to append: ");
			pw.println(sc.next());
		}
	}

	public static void overwriteFile(Scanner sc, File f) throws FileNotFoundException {
		// Use a try-with-resources to create a new PrintWriter which will write to the
		// file.
		try(PrintWriter pw = new PrintWriter(f)) {
			// Print a line to the screen asking the user what text they want to put in the
			// file.
			// Scan for user input.
			// Then use the PrintWriter to print the user input into the file.
			System.out.println("Enter text to write: ");
			pw.println(sc.next());
		}
	}
}