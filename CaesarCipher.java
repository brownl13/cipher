
public class CaesarCipher {
	public static void main(String[] args) {
		String input = "abc!@#$DEF";
		int inputIndexInt = 26;
		char inputIndexChar = 'a';
		String output = caesar(input, getIndex(inputIndexChar));
		System.out.println(output);
	}
	
	public static int getIndex(char input) {
		int charInt = (int)input;
		if (charInt >= 65 && charInt <= 90)
			return (charInt - 65);
		else if (charInt >= 97 && charInt <= 122)
			return (charInt - 97);
		else 
			return -1;		//invalid input character
	}
	
	public static int validateIndex(int index) {
		if (index >= 0 && index <= 25)
			return index;
		else if (index < 0)
			return -1;		//invalid input character
		else
			return (index % 26);
	}
	
	public static String caesar(String input, int index) {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			int charInt = (int)input.charAt(i);
			if ((charInt >= 97 && charInt <= 122) || (charInt >= 65 && charInt <= 90)) {
				output.append((char)(charInt + index));
			}
			else {
				output.append(' ');
			}
		}
		return output.toString();
	}
}
