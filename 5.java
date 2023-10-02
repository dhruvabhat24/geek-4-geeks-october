import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}
class Solution
{
    String colName (long n)
    {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            char ch = (char) ('A' + (n % 26));
            result.insert(0, ch);
            n /= 26;
        }
        return result.toString();
    }
}
