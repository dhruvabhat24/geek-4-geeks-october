//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<Integer> safeNodes=new ArrayList<>();
        int[] state=new int[V];
        for(int i=0; i<V; i++) {
            if(isSafeNode(i, adj, state)) safeNodes.add(i);
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
    private boolean isSafeNode(int node, List<List<Integer>> adj, int[] state) {
        if(state[node]!=0) return state[node]==2;
        state[node]=1;
        for(int neighbour:adj.get(node)) {
            if(!isSafeNode(neighbour, adj, state)) return false;
        }
        state[node]=2;
        return true;
    }
}
