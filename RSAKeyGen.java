//The imports below will be needed
import java.math.BigInteger;
import java.util.Random;

//Can remove the main method was only used to call function
public class RSAKeyGen {
	public static void main(String[] args){
		RSAKeyGen();
	}//end main

	
	//This program doesn't need anything in the text box and
	//should return 6 different values to the user
	//each will be randomly generated but they all have special
	//requirements and it generates numbers until the requirements are
	//met. Testing might be a little different for this one
	
	public static void RSAKeyGen(){
		//define variables that are used in while loop below
		boolean prime1=false;
		boolean prime2=false;
		boolean noPrimeInt=false;
		boolean noPrimeInt2=false;
		long p1=0;
		long p2=0;
		
		//runs until two primes are generated between 10 mil and 20 mil
		while(prime1==false || prime2== false){
			Random rand = new Random();
			Random rand2 = new Random();
			
			//once we have prime number stop running this part
			if(prime1==false){
				//generate random number
				p1=rand.nextInt(10000000)+10000000;
				noPrimeInt=false;
				
				//loop through possible factors to check if prime
				for(int i=2;i<=Math.sqrt(p1)+1;i++){
					if(p1%i==0){
						noPrimeInt=true;
					}//end if
				}//end for
				
				//change prime boolean if prime number
				if(noPrimeInt==false){
					prime1=true;
				}//ends if
				
				else{
					prime1=false;
				}//ends else
			}//end if
		
			//once we have prime number 2 stop running this part
			if(prime2==false){
				//generate random number
				p2=rand2.nextInt(10000000)+10000000;
				noPrimeInt2=false;
				
				//check to see if random number is prime
				for(int i=2;i<=Math.sqrt(p2)+1;i++){
					if(p2%i==0){
						noPrimeInt2=true;
					}//end if
				}//end for
				
				//change prime boolean if prime number
				if(noPrimeInt2==false){
					prime2=true;
				}//end if
				
				else{
					prime2=false;
				}//end else
			}//end if
		}//end while
		
		
		//create modulus and phi
		//these numbers are based on the two prime numbers generated above
		Long mod=p1*p2;
		Long phi =(p1-1)*(p2-1);
		
		//define variables to be used in while loop below
		//had to convert some numbers we had before from long to BigInteger
		BigInteger phi2=BigInteger.valueOf(phi);
		long encryption=0;
		BigInteger encrypt=BigInteger.valueOf(encryption);
		BigInteger gcd=encrypt;
		BigInteger one=BigInteger.valueOf(Long.valueOf(1));
		Random rand3= new Random();
		boolean relprime=false;
		boolean noPrimeInt3=false;
		boolean prime3=false;
		
		//gets encryption exponent
		while(relprime==false){
			while(prime3==false){
				encryption=rand3.nextInt(1000000);
				encrypt=BigInteger.valueOf(encryption);
				noPrimeInt3=false;
				for(int i=2;i<=Math.sqrt(encryption);i++){
					if(encryption%i==0){
						noPrimeInt3=true;
					}//end if
				}//end for loop
				if(noPrimeInt3==false){
					prime3=true;
				}
				else{
					prime3=false;
				}
			}//end nested while
			
			gcd=phi2.gcd(encrypt);
			if(gcd.equals(one)){
				relprime=true;
			}//end if
			
		}//end while
		
		
		//get decryption exponent
		long decryption=gcdExtended(phi,encryption);
		if(decryption<0){
			decryption=phi+decryption;
		}
		decryption=decryption%phi;
		
		String result="";
		result=result+"First large prime "+p1+ "\n";
		result=result+"Second large prime " +p2+"\n";
		result=result+"Modulus " +mod+"\n";
		result=result+"Phi is "+phi2+"\n";
		result=result+"Encryption exponent is " + encryption+"\n";
		result=result+"Decryption exponent is " + decryption+"\n"; 
		
		Output.setText(result);
	}//end RSAKeyGen
	
	//function to get gcdExtended
	public static long gcdExtended(long a,long b){
		long x=0;
		long y=1;
		long lastx=1;
		long lasty=0;
		long temp;
		
		while(b!=0){
			long q=a/b;
			long r=a%b;
			
			a=b;
			b=r;
			
			temp=x;
			x=lastx-q*x;
			lastx=temp;
			
			temp=y;
			y=lasty-q*y;
			lasty=temp;
		}
		return lasty;
	}//end gcdExtended
	
}//end class
