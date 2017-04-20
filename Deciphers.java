public class Deciphers {
	public static String caesarDecipher(String input, int index) {
		return caesar(input, 26-index);
	}
	
	public static String groupChars(String input) {
		input = input.replaceAll(" ", "");
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			if (i % 5 == 0 && i != 0)
				output += input.charAt(i) + " ";
			else 
				output += input.charAt(i);
		}
		return output;
	}
	
	public static String multiplicativeDecipher(String input, int arrayIndex) {
		int[] reverseIndex = {1, 9, 21, 15, 3, 19, 7, 23, 11, 5, 17, 25};
		return multiplicative(input, reverseIndex[arrayIndex]);
	}
}
