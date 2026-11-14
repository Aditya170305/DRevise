import java.util.ArrayList;

public class FindEventualSafeStates {
    
    public boolean dfs(int node , ArrayList<ArrayList<Integer>> adj , int [] vis , int [] pathVis , int [] check){
        
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int it : adj.get(node)){
            
            if(vis[it] == 0){
                
                if(dfs(it , adj , vis , pathVis , check)) return true;
                
            }
            
            else if(pathVis[it] == 1){
                
                return true;
                
            }
            
        }
        
        check[node] = 1;
        pathVis[node] = 0;
        return false;
        
    }
    
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            
            adj.add(new ArrayList<>());
            
        }
        
        for(int i=0;i<edges.length;i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            
        }
        
        int vis [] = new int [V];
        int pathVis [] = new int [V];
        int check [] = new int [V];
        
        for(int i=0;i<V;i++){
            
            if(vis[i] == 0){
                
                dfs(i , adj , vis , pathVis , check);
                
            }
            
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<V;i++){
            
            if(check[i] == 1) ans.add(i);
            
        }
        
        return ans;
        
    }
    
}
