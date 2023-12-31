import java.util.ArrayList;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.distribution.TDistribution;

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
		res /= (input.size());

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
	public static double standardError(double var, int size) {
		return Math.sqrt(var/size);
	}
	public static double standardErrorSq(double var, int size) {
		return var/size;
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

	/**
	 * Calculates p
	 * @param t				t-score
	 * @param dof			degrees of freedom
	 * @return				p-value
	 */
	public static double tTest(double t, int dof) {
		TDistribution dist = new TDistribution(dof);
		return dist.cumulativeProbability(t);
	}

	public static double snp(double z) {
		return 0.5 * (1+ Erf.erf(z/Math.sqrt(2)));
	}

	public static void main(String args[]) {
		ArrayList<Double> test = new ArrayList<>();
		test.add(1.0);
		test.add(2.0);
		test.add(3.0);
		test.add(4.0);
		test.add(5.0);
		System.out.println(var(test));
	}
}
