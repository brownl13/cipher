
public class NewFreq {
	public static void main(String[] args){
		String input="joey is awesome";
		freq(input);
		
		String input2="joey IS A @ baller From the n$4atti";
		freq(input2);
		
		String input3="Northern Kentucky University made the NCAA tournament in it's first year of eligibility for the tournament";
		freq(input3);
		
		String input4="";
		freq(input4);
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
		
		
		
		//Expected English frequencies and if double letters appear will be coded below
		double frequency[] =new double[]{0.08167,0.01492,0.02782,0.04253,0.12702,//frequency for a-e
				0.02228,0.02015,0.06094,0.06966,0.00153,//frequency for f-j
				0.00772,0.04025,0.02406,0.06749,0.07507,//frequency for k-o
				0.01929,0.00095,0.05987,0.06327,0.09056,//frequency for p-t
				0.02758,0.00978,0.0236,0.0015,0.01974,0.00074};//frequency for u-z
		
		//title for the next part
		result=result+"\n\n\nExpected Frequencies of English\n\n\n";
		
		//loop through calculated the expected frequency of each letter and outputting that count
		for(int i=0;i<26;i++){
			String let=String.valueOf((char)(65+i));
			double expected = input.length()*frequency[i];
			String I="";
			
			for(int j=0;j<Math.round(expected);j++){
				I=I.concat("I");
			}//end for
			result=result + let +" = " + Math.round(expected) + " = "+ I +"\n";
		}//end for loop
		
		
		System.out.println(result);
	
	}//end freq
}
