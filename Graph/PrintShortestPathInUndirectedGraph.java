import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Pair{
    
    int dist;
    int node;
    
    public Pair(int dist , int node){
        
        this.dist = dist;
        this.node = node;
        
    }
    
}

public class PrintShortestPathInUndirectedGraph {
    
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<=V;i++){
            
            adj.add(new ArrayList<>());
            
        }
        
        for(int i=0;i<edges.length;i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(u).add(new Pair(wt , v));
            adj.get(v).add(new Pair(wt , u));
            
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(( x , y ) -> x.dist - y.dist);
        
        int dist [] = new int [V + 1];
        int parent [] = new int [V + 1];
        
        for(int i=1;i<=V;i++){
            
            dist[i] = (int)(1e9);
            parent[i] = i;
            
        }
        
        dist[src] = 0;
        pq.offer(new Pair(0 , src));
        
        while(!pq.isEmpty()){
            
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.dist;
            
            for(Pair it : adj.get(node)){
                
                int adjNode = it.node;
                int adjD = it.dist;
                
                if(dis + adjD < dist[adjNode]){
                    
                    dist[adjNode] = dis + adjD;
                    pq.offer(new Pair(dis + adjD , adjNode));
                    parent[adjNode] = node;
                    
                }
                
            }
            
        }
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        
        if(dist[dest] == (int)(1e9)){
            
            path.add(-1);
            return path;
            
        }
        
        int node = dest;
        
        while(parent[node] != node){
            
            path.add(node);
            node = parent[node];
            
        }
        
        path.add(src);
        Collections.reverse(path);
        return path;
        
    }

}
