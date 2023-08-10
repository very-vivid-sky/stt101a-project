
/**
 * The driver.
 * TO COMPILE:	javac -classpath .;commons-math3-3.6.1.jar *.java
 * TO RUN:		java -classpath .;commons-math3-3.6.1.jar Driver.java
 * IF YOU DO NOT COMPILE AND RUN WITH THE CLASSPATH IT WILL CRASH. this is a library containing erf()
 */
public class Driver {

	public static void main(String args[]) {
		// run in object
		new Driver().oneSample();
	}

	public void oneSample() {
		Population pop1;
		
        // Step A: Get population and compute mean and variance
		// (done automatically inside Population)
		System.out.println();
		System.out.println("Input population values:");
		System.out.println("End by typing continue");
		System.out.println("Reset by typing reset");
		pop1 = new Population();

		if (pop1.getSize() < 1) {
			System.out.println("Too little items in population. Ending program.");
			return;
		}
        // Step B: Input sample size
        // Step C: Generate all possible samples and compute sample means
		System.out.println();
		System.out.println("Input sample size:");
		pop1.createSamples();

        // Step D: Compute probabilities for each sample mean
		pop1.computeSampleProbs();
		
        // Step E: Compute the mean of the sampling distribution of X-bar
        // Step F: Compute the variance of the sampling distribution of X-bar
		pop1.computeDistributionMV();

		System.out.println("Population mean: " + pop1.getMean());
		System.out.println("Sampling distribution mean: " + pop1.getSDMean());
		System.out.println();

		System.out.println("Population variance: " + pop1.getVar());
		System.out.println("Sampling distribution variance: " + pop1.getSDVar());
		double temp = (pop1.getVar()/pop1.getSampleSize()) * (pop1.getSize() - pop1.getSampleSize())/(pop1.getSize() - 1);
		System.out.println("Expected value: " + temp);
	}

	public void twoSample() {
		Population pop1;
		Population pop2;
		TwoPopulations tp;

        // Step A: Get population and compute mean and variance
		System.out.println();
		System.out.println("Input population 1 values:");
		System.out.println("End by typing continue");
		System.out.println("Reset by typing reset");
		pop1 = new Population();
		System.out.println("Input population 2 values:");
		pop2 = new Population();

        // Step B: Input sample size
        // Step C: Generate all possible samples and compute sample means
		System.out.println();
		System.out.println("Input sample size for population 1:");
		pop1.createSamples();
		System.out.println("Input sample size for population 2:");
		pop2.createSamples();

		tp = new TwoPopulations(pop1, pop2);
		tp.createCombinations();

	}
}
