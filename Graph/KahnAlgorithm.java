import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {
    
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        
        int n = adj.size();
        
        int indegree [] = new int [n];
        
        for(int i=0;i<n;i++){
            
            for(int it : adj.get(i)){
                
                indegree[it]++;
                
            }
            
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++){
            
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
        
        return ans;
        
    }
    
}
