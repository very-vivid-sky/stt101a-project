
/**
 * The driver.
 * TO COMPILE:	javac -classpath .;commons-math3-3.6.1.jar *.java
 * TO RUN:		java -classpath .;commons-math3-3.6.1.jar Driver.java
 * IF YOU DO NOT COMPILE AND RUN WITH THE CLASSPATH IT WILL CRASH. this is a library containing erf()
 */
public class Driver {
	Population pop1;
	Population pop2;

	public static void main(String args[]) {
		// run in object
		new Driver().oneSample();
	}

	public void oneSample() {
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
		pop1.computeDistributionMean();

		System.out.println("Population mean: " + pop1.getMean());
		System.out.println("Sampling distribution mean: " + pop1.getSDMean());
		// 
	}
}
