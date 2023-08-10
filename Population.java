import java.util.ArrayList;

/**
 * A population distribution. Does not load all values instantly.
 */
public class Population {
	private ArrayList<Double> values;
	private ArrayList<Sample> samples = new ArrayList<>();
	private double mean;
	private double variance;
	private double sampleDistributionMean;
	
	public Population() {
		this(Input.getDoubleArray());
	}
	public Population(ArrayList<Double> values) {
		this.values = values;
		this.mean = Statistics.mean(values);
		this.variance = Statistics.var(values);
	}

	public double getMean() { return mean; }
	public double getVar() { return variance; }
	public double getSDMean() { return sampleDistributionMean; }
	public int getSize() { return values.size(); }

	public void createSamples() {
		this.createSamples(Input.getBoundedInt(2, this.values.size()));
	}

	public void createSamples(int size) {
		int valSize = this.values.size();
		// errors
		if (size < 0 || size > valSize) {
			throw new IndexOutOfBoundsException();
		}

		// start combination creating algorithm
		ArrayList<Integer> combinationCtr = new ArrayList<>();
		ArrayList<Double> currSample = new ArrayList<>();
		boolean running = true;

		int currValue;

		for (int i = 0; i < size; i++) {
			combinationCtr.add(i);
		}

		// 
		while (running) {
			// create sample data, create sample, move to samples
			currSample = new ArrayList<>();
			for (int i : combinationCtr) {
				currSample.add(this.values.get(i));
			}
			samples.add(new Sample(currSample));

			// continue algorithm
			// creates the next combination
			for (int i = size-1;; i--) {
				// manually break here to also end the big loop
				if (i == -1) {
					running = false;
					break;
				}

				currValue = combinationCtr.get(i);
				// checks if this one is at max size, if not increment and end
				// if it is at max, move over to previous value
				if (currValue+(size-i) < valSize) {
					combinationCtr.set(i, currValue+1);
					// reset everything after it
					for (int j = i+1; j < size; j++) {
						combinationCtr.set(j, combinationCtr.get(j-1)+1);
					}
					break;
				}
			}
		}
	}

	public void computeSampleProbs() {
		for (Sample s : samples) {
			s.samplingDistributionProbability(mean, variance);
		}
	}

	public void computeDistributionMean() {
		double res = 0;
		for (Sample s : samples) {
			res += s.getMean();
		}
		res /= samples.size();
		sampleDistributionMean = res;
	}

	public static void main(String args[]) {
		new Population().createSamples(3);
	}
}