import java.util.Scanner;
import java.util.ArrayList;

public class Input {
	// static scanner
	private static Scanner sc;

	private static void loadScanner() {
		if (sc == null) {
			Input.sc = new Scanner(System.in);
		}
	}

	public static Scanner getScanner() {
		loadScanner();
		return sc;
	}

	/**
	 * Gets a double value as a string. Ends when "cancel" or "continue" are inputted.
	 * If value is not a valid double, "cancel", or "continue", continues loop.
	 * @return		A string that can either be converted to a double or is "cancel" or "continue"
	 */
	public static String getDoubleInput() {
		loadScanner();
		String input = null;

		// loop until valid value set to input
		while (input == null) {
			input = sc.nextLine();
			try {
				switch(input.toLowerCase()) {
					case "reset":
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
				case "reset":
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

	public static int getBoundedInt(int lb, int ub) {
		loadScanner();
		int res = 0;
		String input = null;

		// loop inputs
		do {
			try {
				input = sc.nextLine();
				res = Integer.parseInt(input);
				if (lb > res || res > ub) {
					input = null;
				}
			} catch(Exception e) {
				input = null;
			}
			
		} while (input == null);

		return res;
	}

	public static void main(String args[]) {
		getScanner();
		getBoundedInt(1, 5);
	}

}