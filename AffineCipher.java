public class AffineCipher {
	public static void main(String[] args) {
		String input = "XyZ";
		String caesarIndex = "14";
		String output = "";
		int[] indexInput = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};		//these numbers should be in a drop down and the user selects one
		if (getIndex(caesarIndex) != -1) 
			output = affine(input, indexInput[3], getIndex(caesarIndex));
		System.out.println(output);
	}
	
	public static String affine(String input, int multiplicativeIndex, int caesarIndex) {
		String output = "";
		
		input = input.toLowerCase();
		output = multiplicative(input, multiplicativeIndex);
		output = caesar(output, caesarIndex);
		
		return output;
	}
	
	
	public static String multiplicative(String input, int index) {
		StringBuilder output = new StringBuilder();
		input = input.toLowerCase();
		
		for (int i = 0; i < input.length(); i++) {
			int charInt = (int)input.charAt(i);
			if ((charInt >= 97 && charInt <= 122)) {
				charInt -= 96;
				charInt *= index;
				charInt %= 26;
				if (charInt == 0)
					charInt = 122;
				else
					charInt += 96;
				output.append((char)charInt);
			}
			else {
				output.append(' ');
			}
		}
		return output.toString();
	}
	
	public static int getIndex(String input) {
		if (isInteger(input)) {
			int index = Integer.parseInt(input);
			if (index < 0)
				return -1;
			else if (index >= 0 && index <= 25)
				return index;
			else
				return (index % 26);
		}
		else {
			if (input.length() == 1) {
				int charInt = (int)input.charAt(0);
				if (charInt >= 65 && charInt <= 90)
					return (charInt - 65);
				else if (charInt >= 97 && charInt <= 122)
					return (charInt - 97);
				else 
					return -1;
			}
			else 
				return -1;
		}
	}
	
	private static boolean isInteger(String str) {
		return str.matches("^-?\\d+$");
	}
	
	public static String caesar(String input, int index) {
		StringBuilder output = new StringBuilder();
		input = input.toLowerCase();
		
		for (int i = 0; i < input.length(); i++) {
			int charInt = (int)input.charAt(i);
			if ((charInt >= 97 && charInt <= 122)) {
				if ((charInt + index) > 122) {
					int tempIndex = charInt + index - 123;
					output.append((char)(97 + tempIndex));
				}
				else 
					output.append((char)(charInt + index));
			}
			else {
				output.append(' ');
			}
		}
		return output.toString();
	}
}
