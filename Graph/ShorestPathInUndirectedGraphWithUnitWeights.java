import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShorestPathInUndirectedGraphWithUnitWeights {
    
    public int shortestPath(ArrayList<ArrayList<Integer>> adj, int src, int dest) {
        
        int n = adj.size();
        
        int dist [] = new int [n];
        
        Arrays.fill(dist , (int)(1e9));
        
        dist[src] = 0;
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer(src);
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            
            for(int it : adj.get(node)){
                
                if(dist[node] + 1 < dist[it]){
                    
                    dist[it] = 1 + dist[node];
                    q.offer(it);
                    
                }
                
            }
            
        }
        
        return (dist[dest] == (int)(1e9)) ? -1 : dist[dest];
        
    }
    
}
