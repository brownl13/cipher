import java.util.ArrayList;

public class VigenereCipher {
	public static void main(String[] args) {
		String input = "letz";
		String indexInput = "qhd";
		
		ArrayList<Integer> index = getIndexArray(indexInput);
		String result = vigenere(input, index);
		System.out.println(result);
	}
	
	public static String vigenere(String input, ArrayList<Integer> index) {
		StringBuilder result = new StringBuilder();
		int arrayCounter = 0;
		int shiftIndex = 0;
		input = input.toLowerCase();
			
		for (int i = 0; i < input.length(); i++) {
			int charInt = (int)input.charAt(i);
			if (charInt >= 97 && charInt <= 122) {
				if (arrayCounter >= index.size()) {
					shiftIndex = index.get(arrayCounter % index.size());
				}
				else 
					shiftIndex = index.get(arrayCounter);
				
				if ((charInt + shiftIndex) > 122) {
					int tempIndex = charInt + shiftIndex - 123;
					result.append((char)(97 + tempIndex));
				}
				else {
					result.append((char)(charInt + shiftIndex));
				}
				arrayCounter++;
			}
			else {
				result.append(' ');
			}
		}
		return result.toString();
	}
	
	public static ArrayList<Integer> getIndexArray(String indexInput) {
		indexInput = indexInput.toLowerCase();
		ArrayList<Integer> indexArray = new ArrayList<>();
		
		for (int i = 0; i < indexInput.length(); i++) {
			int charInt = (int)indexInput.charAt(i);
			if (charInt >= 97 && charInt <= 122) {
				indexArray.add(charInt - 97);
			}
		}
		return indexArray;
	}
}