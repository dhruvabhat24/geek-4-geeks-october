//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class DisjointSet{
    int[] parent;
    int[] size;
    DisjointSet(int n){
        parent=new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    public int findParent(int node){
        if(parent[node]==node) return node;
        
        return parent[node]=findParent(parent[node]);
    }
    
    public void unionBySize(int u,int v){
        int up=findParent(u);
        int vp=findParent(v);
        
        if(up==vp) return;
        
        if(size[up]>size[vp]){
            parent[vp]=up;
            size[up]+=size[vp];
        }else{
            parent[up]=vp;
            size[vp]+=size[up];
        }
    }
}

class Solution{
    public int largestIsland(int N,int[][] grid) 
    {
        // code here
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        
        DisjointSet ds = new DisjointSet(N*N);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==0) continue;
                
                for(int k=0;k<4;k++){
                    int newr=i+dr[k];
                    int newc=j+dc[k];
                    
                    if(newr>=0&&newr<N&&newc>=0&&newc<N&&grid[newr][newc]==1){
                        ds.unionBySize(N*i+j,N*newr+newc);
                    }
                }
            }
        }
        
        int max=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==1) continue;
                
                HashSet<Integer>set = new HashSet<>();
                for(int k=0;k<4;k++){
                    int newr=i+dr[k];
                    int newc=j+dc[k];
                    
                    if(newr>=0&&newr<N&&newc>=0&&newc<N&&grid[newr][newc]==1){
                        set.add(ds.findParent(newr*N+newc));
                    }
                    int count=0;
                    for(int m:set){
                        count+=ds.size[m];
                    }
                    max=Math.max(max,count+1);
                }

            }
        }

        for(int i=0;i<=N*N;i++){
            max=Math.max(max,ds.size[ds.findParent(i)]);
        }
        return max;
    }
}

