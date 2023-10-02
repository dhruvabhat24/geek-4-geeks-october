import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
class Solution {
    int distinctSubsequences(String S) {
        int n = S.length();
    long[] dp = new long[n + 1];
    dp[0] = 1;
    int[] prev = new int[26];
    Arrays.fill(prev, -1);
    for (int i = 1; i <= n; i++) {
        char currentChar = S.charAt(i - 1);
        int index = currentChar - 'a';
        if (prev[index] != -1) {
            dp[i] = (2 * dp[i - 1] - dp[prev[index]] + 1000000007) % 1000000007;
        } else {
            dp[i] = 2 * dp[i - 1] % 1000000007;
        }
        prev[index] = i - 1;
    }
    return (int) (dp[n] < 0 ? dp[n] + 1000000007 : dp[n]);
}
}
