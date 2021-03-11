package me.mvcastiglia.jdbp.misc;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Assignment0223 {

	public static void main(String[] args) throws IOException {
		File f = new File("assets/thefile.txt");
		try {
			f.createNewFile();
		} catch(IOException e) {
			System.out.println("Oh, no. There was an IOException: " + e.getMessage());
		}
		System.out.println(f.exists());
		
		System.out.println("exists: " + f.exists());
		System.out.println("readable: " + f.canRead());
		System.out.println("writable: " + f.canWrite());
		System.out.println("is directory: " + f.isDirectory());
		System.out.println("is file: " + f.isFile());
		System.out.println("is hidden: " + f.isHidden());
		System.out.println("Path: " + f.getPath());
		System.out.println("Absolute path: " + f.getAbsolutePath());
		System.out.println("Canonical path: " + f.getCanonicalPath());
		System.out.println("File name: " + f.getName());
		System.out.println("Last modified: " + new Date(f.lastModified()));
		System.out.println("File size: " + f.length());
	}

}
