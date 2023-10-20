//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(a[i]);

            Solution ob = new Solution();
            System.out.println(ob.isPossible(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int isPossible(int N, int arr[]) {
        
        int sum=0;
        
        for(int i:arr){
            while(i>0){
                int rem=i%10;
                i/=10;
                sum+=rem;
            }
        }
        return sum%3==0?1:0;
    }
}
