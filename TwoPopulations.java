import java.util.ArrayList;

public class TwoPopulations {
	Population pop1;
	Population pop2;
	ArrayList<TPCombination> combinations = new ArrayList<>();

	public TwoPopulations(Population pop1, Population pop2) {
		this.pop1 = pop1;
		this.pop2 = pop2;
	}

	public void createCombinations() {
		ArrayList<Sample> samp1 = pop1.getSamples();
		ArrayList<Sample> samp2 = pop2.getSamples();
		
		for (Sample s1 : samp1) {
			for (Sample s2 : samp2) {
				combinations.add(new TPCombination(s1, s2));
			}
		}
	}
}