import java.util.ArrayList;

public class UndirectedGraphCycle {
    
    public boolean dfs(int node , int parent , ArrayList<ArrayList<Integer>> adj , int [] vis){
        
        vis[node] = 1;
        
        for(int adjNode : adj.get(node)){
            
            if(vis[adjNode] == 0){
                
                if(dfs(adjNode , node , adj , vis)) return true;
                
            }
            
            else if(parent != adjNode) return true;
            
        }
        
        return false;
        
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        
        int n = adj.size();
        
        int vis [] = new int [n];
        
        for(int i=0;i<n;i++){
            
            if(vis[i] == 0){
                
                if(dfs(i , -1 , adj , vis)){
                    
                    return true;
                    
                }
                
            }
        }
        
        return false;
        
    }
    
}
