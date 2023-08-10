import java.util.ArrayList;
import org.apache.commons.math3.special.Erf;

/**
 * Generic statistics formulas
 * TO RUN: java -classpath commons-math3-3.6.1.jar Statistics.java
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

	/**
	 * Calculates the standard error.
	 * @param popVariance	population variance
	 * @param size			sample size
	 * @return				standard error
	 */
	public static double standardError(double popVariance, int size) {
		return Math.sqrt(popVariance/size);
	}
	
	/**
	 * Calculates the z-score.
	 * @param sampMean		the sample mean
	 * @param popMean		the population mean
	 * @param error			the standard error
	 * @return				the z-score
	 */
	public static double zScore(double sampMean, double popMean, double error) {
		return (sampMean-popMean)/error;
	}

	public static double snp(double z) {
		return 0.5 * (1+ Erf.erf(z/Math.sqrt(2)));
	}

	public static void main(String args[]) {
		System.out.println(Erf.erf(1.96));
	}
}
