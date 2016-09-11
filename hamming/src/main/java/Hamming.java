public class Hamming {
	static int compute(String sequence, String sequence1) {
		int distance = 0;
		if (sequence.length() != sequence1.length()) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) != sequence1.charAt(i)) {
				distance++;
			}
		}
		return distance;
	}
}

