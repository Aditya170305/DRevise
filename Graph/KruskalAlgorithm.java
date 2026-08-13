import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DisjointSet {
    
    static List<Integer> rank;
    static List<Integer> size;
    static List<Integer> parent;
    
    public DisjointSet(int n){
        
        rank = new ArrayList<Integer>();
        size = new ArrayList<Integer>();
        parent = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++){
            
            rank.add(0);
            size.add(1);
            parent.add(i);
            
        }
    }
    
    public int findUPar(int node){
        
        if(node == parent.get(node)){
            return node;
        }
        
        int ulp = findUPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
        
    }
    
    public void unionBySize(int u , int v){
        
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if(ulp_u == ulp_v) return;
        
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
        }
        
        else{
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }
        
    }
}

class Edge implements Comparable<Edge>{
  
  int src , dest , weight;
  Edge(int src , int dest , int weight){
      
      this.src = src;
      this.dest = dest;
      this.weight = weight;
      
  }
  
  public int compareTo(Edge compareEdge){
      
      return this.weight - compareEdge.weight;
      
  }
  
};


public class KruskalAlgorithm {
    
    static int kruskalsMST(int V, int[][] edges) {
        
        List<Edge> adj = new ArrayList<Edge>();
        
        for(int i=0;i<edges.length;i++){
            
            int node = edges[i][0];
            int adjNode = edges[i][1];
            int wt = edges[i][2];
            
            Edge temp = new Edge(node , adjNode , wt);
            adj.add(temp);
            
        }
        
        DisjointSet ds = new DisjointSet(V);
        
        Collections.sort(adj);
        
        int mstWt = 0;
        
        for(int i=0;i<adj.size();i++){
            
            int wt = adj.get(i).weight;
            int u = adj.get(i).src;
            int v = adj.get(i).dest;
            
            if(ds.findUPar(u) != ds.findUPar(v)){
                mstWt = mstWt + wt;
                ds.unionBySize(u , v);
            }
        }
        
        return mstWt;
        
    }
}
