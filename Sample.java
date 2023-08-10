import java.util.ArrayList;

public class Sample {
	private ArrayList<Double> values;
	private double mean;
	private double variance;
	private double error;
	private double sampleProbability;

	public Sample(ArrayList<Double> values, double popVar) {
		this.values = values;
		this.mean = Statistics.mean(values);
		this.variance = this.var(); // Statistics.var(values); //Statistics.standardErrorSq(popVar, values.size());
		this.error = Statistics.standardErrorSq(popVar, values.size());
	}

	public void samplingDistributionProbability(double popMean, double popVar) {
		double z = Statistics.zScore(mean, popMean, error);
		this.sampleProbability = Statistics.snp(z);
	}

	public double getMean() { return mean; }
	public double getVar() { return variance; }
	public double getProb() { return sampleProbability; }
	public double getSize() { return values.size(); }
	public double getError() { return Math.sqrt(error); }

	public double var() {
		double res = 0;
		for (double d : values) {
			res += (Math.pow(d-mean, 2));
		}
		res /= values.size() - 1;
		return res;
	}
}