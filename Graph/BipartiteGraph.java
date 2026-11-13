import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraph {
    
    public boolean dfs(int node , int col , int [] color , ArrayList<ArrayList<Integer>> adj){
        
        color[node] = col;
        
        for(int adjNode : adj.get(node)){
            
            if(color[adjNode] == -1){
                
                if(!dfs(adjNode , 1 - col , color , adj)) return false;
                
            }
            
            else if(color[adjNode] == col) return false;
            
        }
        
        return true;
        
    }
    
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj)  {
        
        int n = adj.size();
        
        int color [] = new int [n];
        
        Arrays.fill(color , -1);
        
        for(int i=0;i<n;i++){
            
            if(color[i] == -1){
                
                if(!dfs(i , 0 , color , adj)) return false;
                
            }
            
        }
        
        return true;
        
    }
    
}
