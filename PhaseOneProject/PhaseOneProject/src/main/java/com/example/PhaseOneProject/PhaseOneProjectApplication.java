package com.example.PhaseOneProject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhaseOneProjectApplication {

	public static void main(String args[]) throws IOException {

		// Enter user name
		Scanner userScanner = new Scanner(System.in);
		String userName = "Toppar";

		System.out.println("Welcome to Company Lockers prototype application");
		System.out.println("Developer: Toppar Bourmaf");
		System.out.println("Developed April 2021");
		System.out.println("Please create the following default directory: C:\\CompanyLockers");
		System.out.print("\nEnter your username: ");
		String userEntry = userScanner.next();

		while (!userEntry.equals(userName)) {
			System.out.println("\nIncorrect username. Try again.");
			System.out.print("Enter your username: ");
			userEntry = userScanner.next();
		}

		System.out.println("\nUsername accepted.");

		// Enter locker number
		Scanner lockerScanner = new Scanner(System.in);
		int lockerNumber = 12345;

		System.out.print("Enter your locker number: ");
		int lockerEntry = lockerScanner.nextInt();

		while (lockerEntry != lockerNumber) {
			System.out.println("\nIncorrect locker number. Try again.");
			System.out.print("Enter your locker number: ");
			lockerEntry = lockerScanner.nextInt();
		}

		System.out.println("\nLocker number accepted.");
		System.out.println("You can now create, delete, read, search, and update user specified files.");

		System.out.println("\n");

		// Search current directory
		Scanner scanCurrentDirectory = new Scanner(System.in);
		System.out.print("Press any key to view current files in default directory");
		scanCurrentDirectory.nextLine();
		File f = new File("C:\\CompanyLockers");
		File[] files = f.listFiles();
		System.out.println("Current files in default directory:");
		for (File file1 : files) {
			if (file1.isDirectory()) {
				System.out.println("Directory: ");
			} else {
				System.out.print("     File:");
			}
			System.out.println(file1.getName());
		}

		System.out.println("\n");

		// Manually enter desired path to view files in ascending order
		Scanner scanManualDirectory = new Scanner(System.in);
		System.out.print("Press any key to view files in desired directory manually");
		scanManualDirectory.nextLine();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Manually enter desired path to view files in ascending order: ");
		String dirPath = scanner.nextLine();

		File folder = new File(dirPath);
		if (folder.isDirectory()) {
			File[] fileList = folder.listFiles();

			Arrays.sort(fileList);

			System.out.println("Total number of files present in ascending order: " + fileList.length);

			// Prints the files in file name ascending order
			for (File file : fileList) {
				System.out.println(file.getName());
			}

		}

		System.out.println("\n");

		// Create file with user input manually
		Scanner scanManualCreation = new Scanner(System.in);
		System.out.print("Press any key to manually create file");
		scanManualCreation.nextLine();
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter file name with specific location to create file: ");
			String name = sc.nextLine(); // variable name to store the file name
			FileOutputStream fos = new FileOutputStream(name, true);
			// true for append mode
			System.out.print("Enter file content: ");
			String str = sc.nextLine() + "\n";
			// str stores the string entered
			byte[] b = str.getBytes(); // converts string into bytes
			fos.write(b); // writes bytes into file
			fos.close(); // closes file
			System.out.println("The file has been saved on the given path.");
		} catch (Exception e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}

		System.out.println("\n");

		// Create file automatically
		Scanner scanFileCreation = new Scanner(System.in);
		System.out.print("Press any key to create file automatically");
		scanFileCreation.nextLine();
		File file = new File("C:\\CompanyLockers\\UserSpecifiedFile.txt");
		if (file.createNewFile()) {
			System.out.println(
					"File (C:\\CompanyLockers\\UserSpecifiedFile.txt) has been automatically created in default directory successfully.");
		} else {
			System.out.println("File already exists.");
		}
		FileWriter writer = new FileWriter(file);
		writer.write("User specified file has been created successfully today.");
		writer.close();

		// Read file automatically
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get("C:\\CompanyLockers\\UserSpecifiedFile.txt"), StandardCharsets.UTF_8);
			System.out.println("Contents of created file: " + lines.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n");

		// Search current directory
		Scanner scanCurrentDirectory1 = new Scanner(System.in);
		System.out.print("Press any key to view current files in default directory");
		scanCurrentDirectory1.nextLine();
		File f1 = new File("C:\\CompanyLockers");
		File[] files1 = f1.listFiles();
		System.out.println("Current files in directory:");
		for (File file1 : files1) {
			if (file1.isDirectory()) {
				System.out.println("Directory: ");
			} else {
				System.out.print("     File:");
			}
			System.out.println(file1.getCanonicalPath());
		}

		System.out.println("\n");

		// Update file automatically
		Scanner scanUpdateFile = new Scanner(System.in);
		System.out.print("Press any key to update file automatically");
		scanUpdateFile.nextLine();
		File fileToBeModified = new File("C:\\CompanyLockers\\UserSpecifiedFile.txt");
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer2 = null;
		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));
			String line = reader.readLine();
			System.out.print("Contents of file to be updated: " + line);
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();
				System.out.print("\nOld contents of file: " + oldContent);
				line = reader.readLine();
				// System.out.println("line=" + line);
			}
			String newContent = oldContent.replaceAll("today", "tomorrow");
			System.out.print("Updated contents of file: " + newContent);
			writer2 = new FileWriter(fileToBeModified);
			writer2.write(newContent);
			System.out.println("File has been automatically updated succesfully.");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\n");

		// Read file to be deleted
		Scanner scanDelete = new Scanner(System.in);
		System.out.print("Press any key to delete file in default directory automatically ");
		scanDelete.nextLine();
		List<String> lines2 = Collections.emptyList();
		try {
			lines2 = Files.readAllLines(Paths.get("C:\\CompanyLockers\\UserSpecifiedFile.txt"), StandardCharsets.UTF_8);
			System.out.println("Contents of file to be deleted: " + lines2.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Delete file
		try {
			Files.deleteIfExists(Paths.get("C:\\CompanyLockers\\UserSpecifiedFile.txt"));
		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}
		System.out.println("Automatic deletion of file successful.");

		System.out.println("\n");

		// Search current directory
		Scanner scanCurrentDirectory11 = new Scanner(System.in);
		System.out.print("Press any key to view current files in default directory");
		scanCurrentDirectory11.nextLine();
		File f11 = new File("C:\\CompanyLockers");
		File[] files11 = f11.listFiles();
		System.out.println("Current files in directory:");
		for (File file1 : files11) {
			if (file1.isDirectory()) {
				System.out.println("Directory: ");
			} else {
				System.out.print("     File:");
			}
			System.out.println(file1.getCanonicalPath());
		}

		System.out.println("\n");

		// Terminate application
		Scanner scanTerminate = new Scanner(System.in);
		System.out.print("Press any key to terminate application");
		scanTerminate.nextLine();
		System.out.print("Application terminated. Goodbye.");
		System.exit(0);
	}
}