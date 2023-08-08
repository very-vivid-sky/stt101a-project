import java.util.Scanner;
import java.util.ArrayList;

public class Input {
	// static scanner
	private static Scanner sc;

	public static Scanner getScanner() {
		if (sc == null) {
			Input.sc = new Scanner(System.in);
		}
		return sc;
	}

	/**
	 * Gets a double value as a string. Ends when "cancel" or "continue" are inputted.
	 * If value is not a valid double, "cancel", or "continue", continues loop.
	 * @return		A string that can either be converted to a double or is "cancel" or "continue"
	 */
	public static String getDoubleInput() {
		String input = null;

		// loop until valid value set to input
		while (input == null) {
			input = sc.nextLine();
			try {
				switch(input.toLowerCase()) {
					case "cancel":
					case "continue":
						break;
					default: // double conversion
						Double.parseDouble(input); // value not used, check if it's compatible
						break;
				}
			} catch(Exception e) {
				input = null; // back to the loop
			}
		}
		return input;
	}

	public static ArrayList<Double> getDoubleArray() {
		ArrayList<Double> res = new ArrayList<Double>();
		String input = "";

		// loop inputs
		do {
			input = getDoubleInput();
			switch(input) {
				case "cancel":
					// new array
					res = new ArrayList<Double>();
				case "continue":
					break;
				default:
					// this value /will/ be a convertable double
					res.add(Double.parseDouble(input));
			}
		// continue until finished by the user
		} while (!(input.equals("continue")));
		return res;
	}

	public static void main(String args[]) {
		getScanner();
		ArrayList<Double> res = getDoubleArray();
		for (double d : res) {
			System.out.println(d + " ");
		}
	}

}