import java.util.ArrayList;

public class ArticulationPoint {
    
    static private int timer = 1;
    
    static void dfs(int node , int parent , int [] vis , int [] tin , int [] low , int [] mark , ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        
        int child = 0;
        
        for(Integer it : adj.get(node)){
            
            if(it == parent) continue;
            
            if(vis[it] == 0){
                
                dfs(it , node , vis , tin , low , mark , adj);
                low[node] = Math.min(low[node] , low[it]);
                
                if(low[it] >= tin[node] && parent != -1){
                    mark[node] = 1;
                }
                
                child++;
                
            }
            
            else{
                
                low[node] = Math.min(low[node] , tin[it]);
                
            }
            
        }
        
        if(child > 1 && parent == -1){
            
            mark[node] = 1;
            
        }
        
    }
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        
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
        
        int vis [] = new int [V];
        int tin [] = new int [V];
        int low [] = new int [V];
        int mark [] = new int [V];
        
        for(int i=0;i<V;i++){
            
            if(vis[i] == 0){
                
                dfs(i , -1 , vis , tin , low , mark , adj);
                
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<V;i++){
            
            if(mark[i] == 1) ans.add(i);
            
        }
        
        if(ans.size() == 0){
            
            ans.add(-1);
            
        }
        
        return ans;
        
    }
}
