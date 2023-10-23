//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxSumIS(int arr[], int n)  
    {  
        //code here.
        int i, j, max = 0; 
        int sum[] = new int[n]; 
  
        
        for (i = 0; i < n; i++) 
            sum[i] = arr[i]; 
  
        
        for (i = 1; i < n; i++) 
            for (j = 0; j < i; j++) 
                if (arr[i] > arr[j] && sum[i] < sum[j] + arr[i]) 
                    sum[i] = sum[j] + arr[i]; 
  
        
        for (i = 0; i < n; i++) 
            if (max < sum[i]) 
                max = sum[i]; 
  
        return max; 
    
    }  
}
