//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][]) {
        ArrayList<Integer>[] gr = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            gr[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] != 0 && i != j) {
                    gr[i].add(j);
                }
            }
        }

        boolean[] visited; // Initialize the visited array outside the loop

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            ArrayList<Integer> rl = new ArrayList<>();
            dfs(i, gr, visited);

            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    rl.add(1);
                } else {
                    rl.add(0);
                }
            }

            ans.add(rl);
        }

        return ans;
    }

    public static void dfs(int curr, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[curr] = true;

        for (int val : graph[curr]) {
            if (!visited[val]) {
                dfs(val, graph, visited);
            }
        }
    }
}
