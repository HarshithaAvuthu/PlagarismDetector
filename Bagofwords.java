/* FINDING THE PLAGARISM PERCENT FOR MULTIPLE FILES USING METHOD OF BAG OF WORDS */

import java.util.*;									
import java.io.*;									/* importing packages */	
import java.lang.String.*;
import java.lang.Math.*;
class Bow
{
	public static String file(File intput1)throws IOException
	{																				//function for file input reading
		try(BufferedReader br = new BufferedReader(new FileReader(intput1))) {
    	StringBuilder sb = new StringBuilder();
    	String line = br.readLine();

    	while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    	}
    	String everything =""+sb.toString();
    	return everything;
		}
	}
	public static void main(String[] args)throws IOException
	{																						// Main method
		File f = new File(args[0]).getAbsoluteFile();
		File[] list = f.listFiles();
		float ans[][]=new float[list.length][list.length];
		int n=list.length;
		for(int i=0;i<list.length;i++)
		{
        	for(int j=0;j<list.length;j++)
        	{
        		//System.out.println("\t 		");
				String str1=file(list[i]);
		    		// System.out.println(child1);
		    	String str2=file(list[j]);
				str1=str1.toLowerCase();									//converting to lowercase
				str2=str2.toLowerCase();
				// System.out.println(str1);
				String s1=str1.replaceAll("[^a-zA-Z0-9 ]","");				//replacing the special characters
				String s2=str2.replaceAll("[^a-zA-Z0-9 ]","");
				// System.out.println(s1);
				String[] words1=s1.split(" ");								//splitting with space
				String[] words2=s2.split(" ");
				// System.out.println(Arrays.toString(words1));
				// System.out.println(Arrays.toString(words2));


		//String[] words=removeduplicates(s1);
				HashMap <String,Integer> a=new HashMap<>();					//an empty hashmap
				Frequency(a,words1);										//finding frequncy
				int p=sqrt(a);
				float l1=(float) Math.pow(p,0.5);						
		    	// System.out.println(l1);


				HashMap <String,Integer> b=new HashMap<>();
				Frequency(b,words2);
				int q=sqrt(b);
				float l2=(float) Math.pow(q,0.5);
		    	// System.out.println(l2);
		   		
				int k=dotproduct(a,b);										//finding the dot product
				// System.out.println(k);
				if(i==j)
				{
					ans[i][j]=100;
				}
				else
				{
					float H=(k/(l1*l2))*100;
					ans[i][j]=ans[j][i]=H;
				}
				
				//System.out.print(H);
													//finding the percent
			}
		}
		display(n,ans,list);

	}
	static void display(int s,float[][] ans,File[] list)
	{
		System.out.print("\t ");
		for (int k=0;k<s;k++ )
		{
			System.out.print("\t 	"+list[k].getName());
			
		}
		System.out.print("\n");
		for (int l=0;l<s ;l++ )
		{
			System.out.print("\t "+list[l].getName());
			for (int n=0;n<s ;n++ )
			{
			System.out.printf("		%.2f ",ans[l][n]);	
			}
			System.out.print("\n");
		}
	}

	public static void Frequency(HashMap <String,Integer> hm, String[] a)
	{																			//Function for finding the frequency
    for(int i = 0; i < a.length; i++)
    {
            if(!hm.containsKey(a[i]))
            {
    		   // count+=1;

               hm.put(a[i], 1);									//if not in hashmap then put the string and
            }													//and put frequency as 1
            else
            {
    			// count+=1;

               hm.put(a[i], hm.get(a[i])+1);					//if already in the hashmap then add 1 to the frequency
            }
    // System.out.println(hm.get(a[i]));

    }   
    

	}
 
static int dotproduct(HashMap<String,Integer> hm1,HashMap<String,Integer> hm2)
{																					//function to find dot product
	int sum=0;
	
	for(Map.Entry<String,Integer> e1:hm1.entrySet())
	{
		String key=e1.getKey();														
		int values=e1.getValue();
		for(Map.Entry<String,Integer> e2:hm2.entrySet())
		{															//if key of first hashmap is equal to key of second hashmap
			String key1=e2.getKey();								//multiply the values of the keys and add
			int values1=e2.getValue();
			if(key.equals(key1))
				sum+=values*values1;
		}

	}																//return the values of the sum of product of values

	return sum;
	// System.out.println(sum);
}

static int sqrt(HashMap<String,Integer> hm)
{
	int sum=0;
	for(Map.Entry<String,Integer> e1:hm.entrySet())					//finding the square root of sum of squares 
	{
		String key=e1.getKey();
		int values=e1.getValue();												
		int sqr=values*values;
		// System.out.println(sqr);

		sum=sum+sqr;
		// System.out.println(sum);

	}	
		// float sqrt=(float) Math.pow(sum,0.5);
		//System.out.println(sqrt);
	return sum;													//return value of sum

}



}


