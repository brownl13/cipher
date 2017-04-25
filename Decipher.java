	public static String keywordDecipher(String input, char[] alphabet) {
		String output = "";
		
		input = input.toLowerCase();
		
		for (int i = 0; i < input.length(); i++) {
			char inputChar = input.charAt(i);
			int letterIndex = 0;
			
			for (int j = 0; j < alphabet.length; j++) {
				if (alphabet[j] == inputChar) {
					letterIndex = j;
					break;
				}
			}
			
			output += (char)(letterIndex + 97);
		}
		
		return output;
	}