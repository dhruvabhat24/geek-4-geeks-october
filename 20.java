//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{   
    public class Graph{
        private int V;
        private ArrayList<ArrayList<Integer>> adj;
        public Graph(int V, ArrayList<ArrayList<Integer>> adj){
            this.V = V;
            this.adj = adj;
        }
        public int bfs(int X){
            boolean[]visited = new boolean[this.V];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            visited[0] = true;
            int level = -1;
            while(!queue.isEmpty()){
                level++;
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int u = queue.poll();
                    if(u == X){
                        return level;
                    }
                    for(int v : adj.get(u)){
                        if(!visited[v]){
                            visited[v] = true;
                            queue.add(v);
                        }
                    }
                }
            }
            return -1;
        }
    }
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Graph graph = new Graph(V, adj);
        return graph.bfs(X);
    }
}
