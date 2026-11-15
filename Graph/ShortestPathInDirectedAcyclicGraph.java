import java.util.ArrayList;
import java.util.Stack;

class Pair {
    
    public int first;
    public int second;
    
    public Pair(int first , int second){
        
        this.first = first;
        this.second = second;
        
    }
    
}

public class ShortestPathInDirectedAcyclicGraph {
    
    public void topoSort(int node , ArrayList<ArrayList<Pair>> adj , int [] vis , Stack<Integer> st){
        
        vis[node] = 1;
        
        for(Pair it : adj.get(node)){
            
            int v = it.first;
            
            if(vis[v] == 0) topoSort(v , adj , vis , st);
            
        }
        
        st.push(node);
        
    }
    
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            
            adj.add(new ArrayList<>());
            
        }
        
        for(int i=0;i<edges.length;i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(u).add(new Pair(v , wt));
            
        }
        
        int vis [] = new int [V];
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0;i<V;i++){
            
            if(vis[i] == 0) topoSort(i , adj , vis , st);
            
        }
        
        ArrayList<Integer> dist = new ArrayList<Integer>();
        
        for(int i=0;i<V;i++){
            
            dist.add((int)(1e9));
            
        }
        
        dist.set(0 , 0);
        
        while(!st.isEmpty()){
            
            int node = st.pop();
            
            for(Pair it : adj.get(node)){
                
                int v = it.first;
                int wt = it.second;
                
                if(dist.get(node) != (int)(1e9) && dist.get(node) + wt < dist.get(v)){
                    
                    dist.set(v , dist.get(node) + wt);
                    
                }
                
            }
            
        }
        
        for(int i=0;i<V;i++){
            
            if(dist.get(i) == (int)1e9){
                
                dist.set(i , -1);
                
            }
            
        }
        
        return dist;
        
    }
    
}
