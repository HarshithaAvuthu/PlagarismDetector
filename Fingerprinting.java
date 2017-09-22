import java.util.*;
import java.io.*;

class Finger{

	public String NoSpclChar(String s)
	{										//removing special characters
		int l=s.length();
		String r="";
		for (int i=0;i<s.length();++i ) {
			int a=(int)(s.charAt(i));
			if((a>47 && a<58)  || (a>96 && a<123) || a==95 || a==32){
				r=r+s.charAt(i);
				// System.out.println(r);
			}
			
		}
		// System.out.println(r);
		return r;
	}
	public double Hashingvalue(String s,int anagram){		// method for finding values
		int j=s.length();
		double sum=0;
		for (int i=0;i<s.length();i++)
		{
			int n=(int)(s.charAt(i));						// Calculating the ascii values of character in string
			sum=sum+(n*(Math.pow(2,j)-1));					//and finding the power of ascii by anagaram in
			j--;                           					// decreasing values
		}
		// System.out.println(sum);
		return sum;

	}
	public String Valuegenerator(String s,int anagram){
		String s2="";
		int i=0;
		while(i<(s.length()-anagram+1)){
			String s1=s.substring(i,i+anagram);				// Creating a substring from main string
			double n=Hashingvalue(s1,anagram);				 // Calling Hashingvalue function to find 
			s2=s2+" "+n;					 				// values of a given Files
			i++;
			s1="";
			}	
		// System.out.println(s2);
		return s2;
	}
	public double Percent(String[] s,String[] s1,int tl){			//method for finding the percent
		int count=0;
		for (int i=0;i<s.length;++i) {
			for (int j=0;j<s1.length;++j) {
				if(s[i].equals(s1[j])){	
					count++;
				}	
			}
		}
		double percent=((2.0*count)/tl)*100;
		return percent;
	}
}

public class Fingerprinting{								//class fingerprinting

	// Creating a  Static Function to open a file;
	public static String Fileopen(String str)throws FileNotFoundException{			//fileopening
		int c=0;
		File file = new File(str);
		String str1="";
		try                               					 // To catch error we use try catch method
		{
			Scanner v= new Scanner(file);
		    while(v.hasNextLine())
		    {
		      str1+=v.nextLine();
		      str1=str1.replace("\n"," "); 					// To read n lines in the given file
		      c=c+1;
		    }
		    v.close();
		}
		catch(Exception e)
		{
		    e.printStackTrace(); 
		}

		return str1;
  }

	public static void main(String[] args)throws FileNotFoundException {

		Finger f=new Finger();										// Creating object for the class

		Scanner s=new Scanner(System.in);								
		System.out.println("Enter the path");						// Enter the path which contains files in the folders

		String path=s.nextLine();
		File folder=new File(path);									// Creating folder to file path 
		int k=0;

		File[] listoffiles=folder.listFiles();  					//Creating a listoffile array and copy files
																	// it from folder
		String[] file_name=new String[listoffiles.length];
		for (int i=0;i<listoffiles.length ;++i ) {    
			File file=listoffiles[i];
			if(file.getName().endsWith(".txt")){ 					// condition to have only .txt files
				file_name[k]=file.getName();
				k++;
			}	
		}
		System.out.println("Enter anagram value");
		int anagram=Integer.parseInt(s.nextLine());					// Enter the weight value

		for (int i=0;i<k;++i ) {
			System.out.print("	 "+file_name[i]);					// For Matrix printing in columns
		}
		System.out.println("\n");

		
		for (int i=0;i<k;++i ) {
			System.out.print(file_name[i]);
			for (int j=0;j<k;++j) {
				String s1=Fileopen(listoffiles[i].toString()).toLowerCase();		// Reading inputs into to two different Files
				String s2=Fileopen(listoffiles[j].toString()).toLowerCase();
				
				s1=f.NoSpclChar(s1).replace(" ","");								// Calling NoSpclChar Function to remove 
				s2=f.NoSpclChar(s2).replace(" ","");								// special characters and replacing space by NUll

				String[] a=f.Valuegenerator(s1,anagram).trim().split(" ");				//Calling Valuegenerator Function
				String[] b=f.Valuegenerator(s2,anagram).trim().split(" ");				//and removing spaces and splitting them

				int tl=(a.length+b.length);
				
				double percentage=f.Percent(a,b,tl);									// calling Percent Function to
																						//calculate the percentage
				System.out.print("       "+Math.round(percentage)+"    ");
				
			}
			System.out.println("\n");
			
		}
	}
}