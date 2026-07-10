import java.util.ArrayList;

public class MColoringProblem {
    
    boolean isSafe(int node , ArrayList<ArrayList<Integer>> adj , int [] color , int V , int col){
        
        for(int it : adj.get(node)){
            if(color[it] == col) return false;
        }
        
        return true;
    }
    
    boolean solve(int node , ArrayList<ArrayList<Integer>> adj , int [] color , int V , int m){
        
        if(node == V) return true;
        
        for(int i=1;i<=m;i++){
            if(isSafe(node , adj , color , V , i)){
                color[node] = i;
                if(solve(node + 1 , adj , color , V , m)) return true;
                color[node] = 0;
            }
        }
        
        return false;
    }
    
    boolean graphColoring(int V, int[][] edges, int m) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            
        }
        
        int [] color = new int [V];
        
        return solve(0 , adj , color ,  V , m);
        
    }
}
