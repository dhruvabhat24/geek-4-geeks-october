1//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends
class Solution{
    static long sumOfDivisors(int N){
        // code here
        long sum = 0;
        for(int i = 1; i <= N; i++){
            if(N == 0)
             return 0;
             sum += (N / i) * i;
        }
        return sum;
    }
}