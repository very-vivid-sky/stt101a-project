public class TPCombination {
	Sample s1;
	Sample s2;
	double meandiff;

	public TPCombination(Sample s1, Sample s2) {
		this.s1 = s1;
		this.s2 = s2;
		this.meandiff = s1.getMean() - s2.getMean();
	}

}