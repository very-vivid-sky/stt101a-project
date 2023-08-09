import java.util.ArrayList;

/**
 * A population distribution. Loads lazily.
 */
public class Population {
	private ArrayList<Double> values;
	private ArrayList<Sample> samples = new ArrayList<>();
	
	public Population() {
		this.values = Input.getDoubleArray();
	}
	public Population(ArrayList<Double> values) {
		this.values = values;
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
				if (i == -1) {
					running = false;
					break;
				}

				currValue = combinationCtr.get(i);
				if (currValue+(size-i) < valSize) {
					combinationCtr.set(i, currValue+1);
					// reset everything above
					for (int j = i+1; j < size; j++) {
						combinationCtr.set(j, combinationCtr.get(j-1)+1);
					}
					break;
				}
			}
		}
	}

	public static void main(String args[]) {
		new Population().createSamples(3);
	}
}