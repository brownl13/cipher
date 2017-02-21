
public class MultiplicativeCipher {
	public static void main(String[] args) {
		String input = "abc";
		int[] indexInput = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};		//these numbers should be in a drop down and the user selects one
		String output = multiplicative(input, indexInput[1]);
		System.out.println(output);
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
}
