//package iiii;

public class PermuteExample {
	static int counter1 = 0;
	static int counter2 = 0;
	public static void main(String[] args) {
		permute("MARTY");
	}

	// Outputs all permutations of the given string.
	public static void permute(String s) {
		permute(s, "");
	}

// Outputs all strings starting with chosen and ending with a permutation of s.
	private static void permute(String s, String chosen) {
		System.out.println(s + "       " + chosen);
		
		
		if (s.length() == 0) {
			// base case: no choices left to be made
			
		} else {
			// recursive case: choose each possible next letter
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i); // choose
				s = s.substring(0, i) + s.substring(i + 1); // remove from s
				chosen += c; // adding to chosen

				permute(s, chosen); // explore
				s = s.substring(0, i) + c + s.substring(i);
				chosen = chosen.substring(0, chosen.length() - 1);
			} // un-choose
		}
	}
}
