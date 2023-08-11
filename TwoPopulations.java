import java.util.ArrayList;

public class TwoPopulations {
	private Population pop1;
	private Population pop2;
	private double meandiff;
	private double vardiff;
	private double twoPopMean;
	private double twoPopVar;
	ArrayList<Difference> combinations = new ArrayList<>();

	public TwoPopulations(Population pop1, Population pop2) {
		this.pop1 = pop1;
		this.pop2 = pop2;
		this.meandiff = pop1.getMean() - pop2.getMean();
		this.vardiff = (pop1.getVar()/pop1.getSize()) + (pop2.getVar()/pop2.getSize());
		//System.out.println(this.meandiff);
	}

	public void createCombinations() {
		ArrayList<Sample> samp1 = pop1.getSamples();
		ArrayList<Sample> samp2 = pop2.getSamples();
		
		for (Sample s1 : samp1) {
			for (Sample s2 : samp2) {
				combinations.add(new Difference(s1, s2, pop1.getVar(), pop2.getVar()));
			}
		}
	}

	public void computeSampleProbs() {
		for (Difference d : combinations) {
			d.samplingDistributionProbability(meandiff, Math.sqrt(vardiff));
		}
	}

	public void computeDistributionMV() {
		double dmean = 0;
		for (Difference d : combinations) {
			dmean += d.getMeanDiff();
		}
		dmean /= combinations.size();
		this.twoPopMean = dmean;

		double dvar = 0;
		for (Difference d : combinations) {
			dvar += (d.getS1().var() / pop1.getSize()) + (d.getS2().var() / pop2.getSize()); // (Math.pow(d.getMeanDiff()-meandiff, 2));
		}
		dvar /= combinations.size();

		this.twoPopVar = dvar;

		System.out.println(dmean + " " + meandiff);
		System.out.println(dvar + " " + vardiff);
	}
}