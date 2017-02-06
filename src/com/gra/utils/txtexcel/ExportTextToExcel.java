package com.gra.utils.txtexcel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gra.utils.txtexcel.domain.User;

/**
 * Read text input file that contains user details and has a specific format and
 * insert it into excel file
 * 
 * @author gabrielaradu
 *
 */
public class ExportTextToExcel {

	// Filepath for the document
	private static String filePath;

	public static void main(String[] args) throws FileNotFoundException {
		try {
			filePath = System.getProperty("user.dir") + "/";
			if (filePath != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter file name: ");
				String input = br.readLine();

				if (input != null && input.length() > 0) {
					createExcelFromInput(input, filePath);
				} else {
					System.out.println("Didn't catch that name. Try again:");
					String secondInput = br.readLine();
					createExcelFromInput(secondInput, filePath);
				}
			} else {
				System.out.println("Error retrieving file path of the current folder.");
			}
		} catch (Exception e) {
			System.out.print("Error on main thread: " + e.getMessage());
		}
	}

	private static void createExcelFromInput(String input, String filePath2) {
		try {
			filePath += input + ".txt";
			Path path = Paths.get(filePath);

			if (path.toFile().exists()) {
				List<User> users = getUserFromFile();
				if (!users.isEmpty()) {
					ExcelHelper.makeExcelFile(users, input);
				}
			} else {
				System.out.println("File was not found.");
			}

		} catch (Exception e) {
			System.out.println("Something went wrong in parsing the text file: " + e.getMessage());
		}
	}

	/**
	 * Retrieves all the users from the file
	 * @return
	 */
	private static List<User> getUserFromFile() {
		List<User> people = new ArrayList<User>();
		try {
			File f = new File(filePath);
			Scanner sc = new Scanner(f);
			sc.useDelimiter("--");

			while (sc.hasNext()) {
				String line = sc.next();
				String[] rows = line.split(":");

				String firstname = rows[1].split("\n")[0];
				String surname = rows[2].split("\n")[0];
				String hometown = rows[3].split("\n")[0];
				String telephone = rows[4].split("\n")[0];
				String email = rows[5].split("\n")[0];
				String course = rows[6].split("\n")[0];
				String url = rows[7].split("\n")[0];
				String source = rows[8].split("\n")[0];
				String promotion = rows[9].split("\n")[0];
				String optin = rows[10].split("\n")[0];

				User user = new User(firstname, surname, hometown, telephone, email, course, url, source, promotion,
						optin);
				if (user != null) {
					people.add(user);
				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return people;
	}
}