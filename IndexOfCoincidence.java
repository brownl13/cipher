

public class IndexOfCoincidence extends ufun {

	public static void main(String[] args) {
		String input="joey is awesome";
		IndexOfCoincidence(input);
		
		String input2="";
		IndexOfCoincidence(input2);
		
		String input3="a";
		IndexOfCoincidence(input3);
		
		String input4="Joey is a straight up baller";
		IndexOfCoincidence(input4);
		
		
	}//end main

	public static void IndexOfCoincidence(String input){
		
		//create array to store count in a=0,b=1...
		int array[]=new int[26];
		
		//take string and convert to lowercase and remove spaces
		input=input.replaceAll(" ","");
		input=input.toLowerCase();
		input=input.replaceAll("[^A-Za-z]+","");
		if(input.length()<=1){
			Output.setText("NA");
		}//end if
		
		else{
		
			//look through each letter in string and update count in the correct spot
			for(int i=0;i<input.length();i++){
				char letter=input.charAt(i);
				int position= letter-'a';
				array[position]=array[position]+1;	
			}//end for loop
		
			//loop through and get the numerator value
			int numerator=0;
			for(int i=0;i<array.length;i++){
				numerator=numerator+(array[i]*(array[i]-1));
			}//end for loop
		
			//create denominator value
			int denominator=input.length()*(input.length()-1);
		
			//convert integers to doubles and get Index
			double num=(double) numerator;
			double den=(double) denominator;
			double index = num/den;
			Output.setText(index);
		}//end else
	}//end IndexOfCoincidence
}
