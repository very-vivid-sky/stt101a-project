import java.util.ArrayList;

/**
 * Generic statistics formulas
 */
public class Statistics {
	/**
	 * Calculates the mean.
	 * @param input			arraylist of doubles
	 * @return				resulting mean
	 */
	public static double mean(ArrayList<Double> input) {
		double res = 0;
		for (double d : input) {
			res += d;
		}
		res /= input.size();

		return res;
	}


	/**
	 * Calculates the variance.
	 * @param input			arraylist of doubles
	 * @return				resulting variance
	 */
	public static double var(ArrayList<Double> input) {
		double res = 0;
		double mean = mean(input);

		for (double d : input) {
			res += Math.pow(d-mean, 2);
		}
		res /= input.size();

		return res;
	}

	/**
	 * Calculates the standard deviation.
	 * @param input			arraylist of doubles
	 * @return				resulting variance
	 */
	public static double stdev(ArrayList<Double> input) {
		return Math.sqrt(var(input));
	}



	public static void main(String args[]) {
		
	}
}
