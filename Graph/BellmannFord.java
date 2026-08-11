import java.util.ArrayList;
import java.util.Arrays;

public class BellmannFord {
    
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int dist [] = new int [V];
        
        Arrays.fill(dist , (int)(1e8));
        
        dist[src] = 0;
        
        for(int i=0;i<V-1;i++){
            
            for(int j=0;j<edges.length;j++){
                
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
                
            }
            
        }
        
        for(int i=0;i<edges.length;i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                ans.add(-1);
                return ans;
            }
        }
        
        
        for(int i=0;i<dist.length;i++){
            ans.add(dist[i]);
        }
        
        return ans;
        
    }
}
