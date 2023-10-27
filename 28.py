#User function Template for python3

class Solution:
    def minimumNumberOfDeletions(self, S):
        n = len(S)

        # Create a 2D table to store the length of the LPS for substrings
        dp = [[0] * n for _ in range(n)]

        # All substrings of length 1 are palindromes
        for i in range(n):
            dp[i][i] = 1

        # Fill the dp table for substrings of length 2 and above
        for cl in range(2, n + 1):
            for i in range(n - cl + 1):
                j = i + cl - 1
                if S[i] == S[j] and cl == 2:
                    dp[i][j] = 2
                elif S[i] == S[j]:
                    dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])

        # The length of the LPS for the entire string is stored in dp[0][n-1]
        # The minimum number of deletions is total length of the string - length of LPS
        return n - dp[0][n - 1]


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        
        S=input()

        ob = Solution()
        print(ob.minimumNumberOfDeletions(S))
# } Driver Code Ends
