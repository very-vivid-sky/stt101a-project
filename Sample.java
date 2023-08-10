import java.util.ArrayList;

public class Sample {
	private ArrayList<Double> values;
	private double mean;
	private double variance;
	private double sampleProbability;

	public Sample(ArrayList<Double> values) {
		this.values = values;
		this.mean = Statistics.mean(values);
		this.variance = Statistics.var(values);
	}

	public void samplingDistributionProbability(double popMean, double popVar) {
		double error = Statistics.standardError(popVar, values.size());
		double z = Statistics.zScore(mean, popMean, error);
		this.sampleProbability = Statistics.snp(z);
	}

	public double getMean() { return mean; }
	public double getVar() { return variance; }
	public double getProb() { return sampleProbability; }
	public double getSize() { return values.size(); }
}