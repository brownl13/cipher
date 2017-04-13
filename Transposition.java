//import java.util.Arrays;

// This function will take string input from the user
// along with a keyword. It will then put that input
//in a matrix and transpose columns in a certain order
//based on alphabetical order of the keyword.
public class Transposition {

	public static void main(String[] args) {		
		String input= "this is just a test";
		String keyword="joey";
		boolean encipher=true;
		transposition(input,keyword,encipher);
		
		String input2="IJATT ISEHS TSSUT";
		String keyword2="joey";
		boolean encipher2=false;
		transposition(input2,keyword2,encipher2);
		
		String input3 = "IJATT ISEHS TSSUT X";
		String keyword3 = "Joey";
		boolean encipher3=false;
		transposition(input3,keyword3,encipher3);
		
		String input4="joey is awesome";
		String keyword4="pizza";
		boolean encipher4=true;
		transposition(input4,keyword4,encipher4);
		

		String input5="ISXOA MJSOE WEYEX";
		String keyword5="pizza";
		boolean encipher5=false;
		transposition(input5,keyword5,encipher5);
		
		//test no input
		String input6="";
		String keyword6="joey";
		boolean encipher6=true;
		transposition(input6,keyword6,encipher6);
		
		//test no keyword
		String input7="Joey is awesome";
		String keyword7="8";
		boolean encipher7=false;
		transposition(input7,keyword7,encipher7);
	}//end main

	
	//Function starts here
	public static void transposition(String input,String keyword,boolean encipher){
		//removes spaces and special characters from input and keyword 
		input=input.replaceAll(" ","");
		input=input.toLowerCase();
		input=input.replaceAll("[^A-Za-z]+","");
		
		keyword=keyword.replaceAll(" ","");
		keyword=keyword.toLowerCase();
		keyword=keyword.replaceAll("[^A-Za-z]+","");
		
		//checks to make sure input and keyword is valid
		boolean validInput=true;
		if(input.equals("")){
			System.out.println("Enter text than can be enciphered or deciphered");
			validInput=false;
		}//ends if
		
		if(keyword.equals("")){
			System.out.println("Enter a keyword that can be used");
			validInput=false;
		}//ends if
		
		//if we are enciphering below runs
		if(encipher==true && validInput==true){
			
			//adds x to end of string if needed
			while(input.length()%keyword.length()!=0){
				input=input+"x";
			}//end while
		
			//creates matrix to put string into
			String[][] matrix = new String [input.length()/keyword.length()][keyword.length()];
			int i=0;
		
			//put text into matrix
			for(int r=0;r<input.length()/keyword.length();r++){
				for(int c=0;c<keyword.length();c++){
					matrix[r][c]=input.substring(i,i+1);
					i++;
				}//ends c for loop
			}//ends r for loop
	
			
			//create array to find order to transpose matrix
			int[] numarray=new int[keyword.length()];
			for(int j=0;j<keyword.length();j++){
				char letter=keyword.charAt(j);
				int letnum=letter-'a';
				numarray[j]=letnum;
			}//end for loop
		
			//find the column to take first and add to result
			String result="";
			int count=0;
			for(int j=0;j<keyword.length();j++){
				int min =27;
				int index=-1;
				for(int k=0;k<keyword.length();k++){
					if(numarray[k]<min){
						min=numarray[k];
						index=k;
					}//end if 
				}//end nested for loop
			
				numarray[index]=27;
			
				for(int m=0;m<input.length()/keyword.length();m++){
					if(count==5){
						result=result+" ";
						count=0;
					}//end if
					
					result=result+matrix[m][index];
					count=count+1;
				}//end for loop
			}//end for loop
		
			
			//print out result
			result=result.toUpperCase();
			System.out.println(result);
		}//end if statement
		
		
		//runs if decipher button is hit
		if(encipher==false && validInput==true){
			
			//checks to make sure it makes a complete square
			if(input.length()%keyword.length()!=0){
				System.out.println("Make sure the length of the input is divisible by the length of keyword.");
			}//end if
			
			//runs if we have a full matrix
			else{
				//creates matrix
				String[][] matrix = new String[input.length()/keyword.length()][keyword.length()];
				int i=0;
				int[] numarray=new int[keyword.length()];
				
				//takes keyword and converts to array to get order
				for(int j=0;j<keyword.length();j++){
					char letter=keyword.charAt(j);
					int letnum=letter-'a';
					numarray[j]=letnum;
				}//end for loop
				
				
				//finds the correct order of transpose
				//and puts text into array
				for(int k=0;k<keyword.length();k++){
					//reset index and min
					int index=-1;
					int min=27;
					
					//loop through to find the next column to add
					for(int j=0;j<keyword.length();j++){
						if(numarray[j]<min){
							min=numarray[j];
							index=j;
						}//end if
					}//end for
					
					//reset value
					numarray[index]=27;
					
					//put text in correct location in matrix
					for(int n=0;n<input.length()/keyword.length();n++){
						matrix[n][index]=input.substring(i,i+1);
						i++;
					}//end for
				}//end for
				
				//grab the string back out of the matrix
				String result="";
				int count =0;
				for(int p=0;p<input.length()/keyword.length();p++){//traverse rows
					for(int q=0;q<keyword.length();q++){//traverse columns
						if(count==5){
							result=result+ " ";
							count=0;
						}//end if
						
						result=result+matrix[p][q];
						count=count+1;
					}//end for loop
				}//end for loop
				
				//print the output
				System.out.println(result);
			}//end else
	
		}//end if encipher == false statement
		
	}//end method
	
}//end transposition class
