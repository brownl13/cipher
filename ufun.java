import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ufun{
	
	public final ArrayList<Integer> uZcon(String c){
		c = c.toLowerCase(); //to lower
		ArrayList n = new ArrayList<Integer>();
		char[] cArray = c.toCharArray(); // to char array

		//loop through char array and convert letters into #
		for(int i = 0; i < cArray.length; i++){
			//conversion equation and add to arraylist
			n.add((int)cArray[i] - (int)'a' + 1);
		}
		return n;
		

	}
	
	public final ArrayList<Integer> uOcon(String c){
		c = c.toLowerCase(); //to lower
		ArrayList n = new ArrayList<Integer>();
		char[] cArray = c.toCharArray(); // to char array

		//loop through char array and convert letters into #
		for(int i = 0; i < cArray.length; i++){
			//conversion equation and add to arraylist
			n.add((int)cArray[i] - (int)'a');
		}
		return n;
	}

	
}

