public class RunTheAlphabet {
	public static void main(String[] args) {
		String input = "abc!@#$DEFLIHDDL jsabd ";
		runTheAlphabet(input);
	}
	
	public static void runTheAlphabet(String input) {
		for (int j = 0; j <= 25; j++) {
			StringBuilder output = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				int charInt = (int)input.charAt(i);
				if ((charInt >= 97 && charInt <= 122)) {
					if ((charInt + j) > 122) {
						int tempIndex = charInt + j - 123;
						output.append((char)(97 + tempIndex));
					}
					else 
						output.append((char)(charInt + j));
				}
				else if ((charInt >= 65 && charInt <= 90)) {
					if ((charInt + j) > 90) {
						int tempIndex = charInt + j - 91;
						output.append((char)(65 + tempIndex));	
					}
					else
						output.append((char)(charInt + j));
				}
				else {
					output.append(' ');
				}
			}
			System.out.println(output.toString());
		}
		
	}
}
