/**
 * This programs job is to read a file
 * in this file there are words that will be searched for on the top half of the file
 * on the bottom half of the file there is a bunch of mixed up text that will be searched for the words at the top of the file
 * the top and the bottom of the file are separated by "***"
 */
import java.io.*;
import java.util.*;

public class LineSearch {

	private static int nCount = 0;// initializes nCount
	private static String needle[] = new String[6];// initializes needle
	private static int hCount = 0;// initializes hCount
	private static String haystack[] = new String[20];// Initializes haystack
	/**
	 * the main method of the program
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kobe = null; // Initializes scanner kobe

		// tries to open file and read each line of it
		try {
			boolean Paul = false;// declares boolean variable to be false
			kobe = new Scanner(new File("words.dat"));// puts scanner on the file

			while (kobe.hasNextLine()) {// keeps looping as long as there is another line
				String michael = kobe.nextLine();// string michael will be equal to the line that is currently passing
													// through the loop

				if (michael.contains("***")) {// if there are 3 stars then we start storing in the haystack array

					Paul = true;// boolean value now equals true
				}
				if (!Paul) {// if false it keeps storing in the needle array

					needle[nCount++] = michael;// stores michael into needle

				} else
					haystack[hCount++] = michael;// stores micahel into haystack
			}
		} catch (Exception john) {// catches if the file is not found
			System.out.println("Could not find a file to open");
		}

		Arrays.sort(needle);// sorts the needle array alphabetically
		System.out.println("|   word    |  row  |  column  |");
		System.out.println("| --------- | ----- | -------- |");
		for (String prince : needle) {// loops the string

			String george[] = checker(prince, haystack, hCount).split("_");// calls isPresent
			int row = Integer.parseInt(george[0]);// makes row equal to george at 0
			int column = Integer.parseInt(george[1]);// makes column equal to george at 1
			if (row != -1) {// this passes if the word was found in the jumble
				row -= 1;// puts it in the correct row
				System.out.printf("|%s", prince);
				for (int i = 1; i <= 11 - prince.length(); i++) {// gets correct spaces so the output is organized
					System.out.print(" ");
				}
				System.out.printf("|   %d   |     %d    |\n", row, column);
			}

			else {
				System.out.print("|" + prince);
				for (int i = 1; i <= 11 - prince.length(); i++) {
					System.out.print(" ");// gets correct spaces so the output is organized
				}
				System.out.print("|  -1   |    -1    |\n");
			}
		}
	}
	/**
	 * this class seraches for the a String within the array haystack
	 * @param prince
	 * @param haystack
	 * @param Ringo
	 * @return
	 */
	public static String checker(String prince, String[] haystack, int Ringo) {
		for (int i = 0; i < Ringo; i++) {
			if (haystack[i].contains(prince)) {// helps to see if row contains string prince
				return i + 1 + "_" + (haystack[i].indexOf(prince) + 1);// helps find the row and the column of where the
																		// word is
			}
		}
		return -1 + "_" + -1;// returns if the word cannot be found
	}
}
