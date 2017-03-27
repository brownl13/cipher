public class KeywordCipher {
	public static void main(String[] args) {
		String input = "hello";
		String keyword = "java";
		String letter = "c";
		int letterIndex = getIndex(letter);
		if (letterIndex >= 0) {
			char[] finishedAlphabet = setUpAlphabet(keyword, letterIndex);
			String output = getOutput(input, finishedAlphabet);
			System.out.println(output);
		}
	}
	
	public static char[] setUpAlphabet(String keyword, int letter) {
		int letterCounter = 0;
		char[] alphabet = new char[26];
		boolean[] usedLetters = new boolean[26];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = '0';
		}
		
		keyword = keyword.toLowerCase();
		
		for (int i = 0; i < keyword.length(); i++) {
			int charInt = (int)keyword.charAt(i);
			
			if (charInt >= 97 && charInt <= 122) {
				int indexOfLetter = charInt - 97;
				
				if (usedLetters[indexOfLetter] == false) {
					alphabet[letter] = (char)keyword.charAt(i);
					usedLetters[indexOfLetter] = true;
					letter++;
					letterCounter++;
				}
			}
		}
		
		for (int i = 0; i < (alphabet.length - letterCounter); i++) {
			for (int j = 0; j < usedLetters.length; j++) {
				if (usedLetters[j] == false) {
					alphabet[letter % 26] = (char)(j + 97);
					letter++;
					usedLetters[j] = true;
					break;
				}
			}
		}
		
		return alphabet;
	}
	
	public static String getOutput(String input, char[] alphabet) {
		String output = "";
		input = input.toLowerCase();
		
		for (int i = 0; i < input.length(); i++) {
			int charInt = (int)input.charAt(i);
			
			if (charInt >= 97 && charInt <= 122) {
				int indexOfLetter = charInt - 97;
				output += alphabet[indexOfLetter];
			}
		}
		
		return output;
	}

	public static int getIndex(String letterInput) {
		if (isInteger(letterInput)) {
			int index = Integer.parseInt(letterInput);
			if (index < 0)
				return -1;
			else if (index >= 0 && index <= 25)
				return index;
			else
				return (index % 26);
		}
		else {
			if (letterInput.length() == 1) {
				letterInput = letterInput.toLowerCase();
				int charInt = (int)letterInput.charAt(0);
				if (charInt >= 97 && charInt <= 122)
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
}