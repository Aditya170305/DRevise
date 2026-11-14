import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class FindEventualSafeStatesByTopoSort {
    
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            
            adj.add(new ArrayList<>());
            
        }
        
        int indegree [] = new int [V];
        
        for(int i=0;i<edges.length;i++){
            
            int u = edges[i][1];
            int v = edges[i][0];
            
            adj.get(u).add(v);
            indegree[v]++;
            
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<V;i++){
            
            if(indegree[i] == 0) q.offer(i);
            
        }
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            ans.add(node);
            
            for(int it : adj.get(node)){
                
                indegree[it]--;
                
                if(indegree[it] == 0){
                    
                    q.offer(it);
                    
                }
                
            }
            
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }
    
}
