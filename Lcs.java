/* FINDING THE PLAGARISM PERCENT FOR MULTIPLE FILES USING THE METHOD OF LEAST COMMON SUBSTRING  */


import java.util.*;
import java.io.*;
class Lcs
{
    public static String file(File intput1)throws IOException
    {                                                                           //fILE input method and reading files line by line
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
	{                                                                      //main method
		File f = new File(args[0]).getAbsoluteFile();
         File[] list = f.listFiles();
       float ans[][]=new float[list.length][list.length];
        int n=list.length;
        for(int i=0;i<list.length;i++)
        {
            for(int j=0;j<list.length;j++)
            {
                String str1=file(list[i]);                           //storing the files into strings
                String str2=file(list[j]);
        		str1=str1.toLowerCase();                                 //  converting all the stringsn to lower case
        		str2=str2.toLowerCase();
        		// System.out.println(str1);
        		String s1=str1.replaceAll("[^a-zA-Z0-9]","");            // removing the special characters
        		String s2=str2.replaceAll("[^a-zA-Z0-9]","");
        		// System.out.println(s1);
        		int m=s1.length();
        			// System.out.println(m);                            // the lengthgth of string
        		int z=s2.length();
        			// System.out.println(n);
        		float p=lcs(s1,s2,m,z);                                  //calling the lcs method
          //       if(p==-1)
        		//   System.out.printf("%12.2f",0.0);
          //       else{
        		float tl=m+z;
        		// // System.out.println(tl);
        		// float percent=0;                                          // calculating the percent
        		float percent=((p*2)/tl)*100;
                if(i==j)
                {
                    ans[i][j]=100;
                }
                else
                {
                    ans[i][j]=percent;
                }
        		//System.out.printf("%12.2f",percent);
            }
        }
    display(n,ans,list);
	}

    static void display(int s,float[][] ans,File[] list)
    {
        System.out.print("\t ");
        for (int k=0;k<s;k++ )
        {
            System.out.print("\t   "+list[k].getName());
            
        }
        System.out.print("\n");
        for (int l=0;l<s ;l++ )
        {
            System.out.print("\t "+list[l].getName());
            for (int n=0;n<s ;n++ )
            {
            System.out.printf("     %.2f     ",ans[l][n]);  
            }
            System.out.print("\n");
        }
    }
    static int lcs(String X, String Y, int m, int n)
    {                                                               //lcs method
        
        int[][] L = new int[m + 1][n + 1];
        int length = 0;
        int row = 0, col = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
 
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                    if (length < L[i][j]) {
                        length = L[i][j];
                        row = i;
                        col = j;
                    }
                } else
                    L[i][j] = 0;
            }
        }
        if (length == 0) {
            return-1;
           // System.out.println("No Common Substring");
            // return;
        }
        String result = "";
        while (L[row][col] != 0) {
            result  = X.charAt(row - 1) + result; // or Y[col-1]
            --length;
            row--;
            col--;
        }
        // System.out.println(result);
        int l=result.length();
        // System.out.println(l);
        return l;
    }
}
