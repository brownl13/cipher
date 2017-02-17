


public class Freq {
	public static void main(String[] args){
		String input="joey is awesome";
		freq(input);
		
		String input2="joey IS A @ baller From the n$4atti";
		freq(input2);
	}//end main
	
	
	//this function returns the frequency for each letter in the 
	//text. It should only have to read in the string and output
	//should look like A = 2 = II for each letter
	//The main above is just some test cases so only worry about below
	//it is storing the output in a string called result so at the end
	//we need to print that string
	public static void freq(String input){
		//remove spaces and special characters from string
		input=input.replaceAll(" ","");
		input=input.toLowerCase();
		input=input.replaceAll("[^A-Za-z]+","");
		
		int array[]=new int[26];
		//look through each letter in string and update count in the correct spot
		//index 0 in array is a and index 25 is z
		for(int i=0;i<input.length();i++){
			char letter=input.charAt(i);
			int position= letter-'a';
			array[position]=array[position]+1;	
		}//end for loop
		
		String result="";
		//loop through array and put the results into a single string
		for(int i=0;i<26;i++){
			
			String l=String.valueOf((char)(65+i));
			
			String I="";
			for(int j=0;j<array[i];j++){
				I=I.concat("I");
			}//end for
			result=result + l + " = " + array[i] + " = " + I + "\n";			
		}//end for
		output.setText(result);
	}//end freq
	
}//end class
