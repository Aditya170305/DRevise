import java.util.ArrayList;

public class NoOfProvincesByDFS {
    
    void dfs(ArrayList<ArrayList<Integer>> adj , int node , int [] vis){
        
        vis[node] = 1;
        
        for(int it : adj.get(node)){
            
            if(vis[it] == 0) dfs(adj , it , vis);
            
        }
        
    }
    
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            
            adj.add(new ArrayList<>());
            
        }
        
        for(int i=0;i<edges.size();i++){
            
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            
        }
        
        int vis [] = new int [V];
        
        int ans = 0;
        
        for(int i=0;i<V;i++){
            
            if(vis[i] == 0){
                
                dfs(adj , i , vis);
                ans++;
                
            }
            
        }
        
        return ans;
        
    }
    
}
