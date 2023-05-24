public class PermuteExample2 {
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
	    System.out.println(s +"      " + chosen);
		
		if (s.length() == 0) {
	        // base case: no choices left to be made
	        System.out.println(chosen);
	    } else {
	        // recursive case: choose each possible next letter
	        for (int i = 0; i < s.length(); i++) {
	            String ch = s.substring(i, i + 1);  // choose

	            String rest = s.substring(0, i) +   // remove
	                          s.substring(i + 1);

	            permute(rest, chosen + ch);         // explore
	        }
	    }       // (don't need to "un-choose" because
	}           //  we used temp variables)

}
