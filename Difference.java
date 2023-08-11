public class Difference {
	private Sample s1;
	private Sample s2;
	private double meandiff;
	private double vardiff;
	private double error;
	private double sampleProbability;

	public Difference(Sample s1, Sample s2, double pvar1, double pvar2) {
		this.s1 = s1;
		this.s2 = s2;
		this.meandiff = s1.getMean() - s2.getMean();
		this.vardiff = this.var();
		this.error = Math.sqrt(Statistics.standardErrorSq(pvar1, s1.getSize()) + Statistics.standardErrorSq(pvar2, s2.getSize()));
		//System.out.println("Mean of " + s1.getMean() + " and " + s2.getMean() + " : " + this.meandiff);
	}

	public double getMeanDiff() { return this.meandiff; }
	public double getVarDiff() { return this.vardiff; }
	public double getError() { return this.error; }
	public double getProb() { return this.sampleProbability; }
	public Sample getS1() { return s1; }
	public Sample getS2() { return s2; }

	public void samplingDistributionProbability(double popMean, double popVar) {
		if (s1.getSize() < 30 || s2.getSize() < 30) {
			int df;
			double t = meandiff / Math.sqrt(vardiff);
			if (s1.getSize() < s2.getSize()) { df = s1.getSize() - 1; }
			else { df = s2.getSize() - 1; }
			this.sampleProbability = Statistics.tTest(t, df);
		} else {
			double z = Statistics.zScore(meandiff, popMean, error);
			this.sampleProbability = Statistics.snp(z);
		}
	}

	public double var() {
		return (s1.getVar() / s1.getSize()) + (s2.getVar() / s2.getSize());
	}

}