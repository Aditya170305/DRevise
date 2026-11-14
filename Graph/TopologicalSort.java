import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    
    void dfs(int node , int [] vis , ArrayList<ArrayList<Integer>> adj , Stack<Integer> st){
        
        vis[node] = 1;
        
        for(int it : adj.get(node)){
            
            if(vis[it] == 0){
                
                dfs(it , vis , adj , st);
                
            }
            
        }
        
        st.add(node);
        
    }
    
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        
        int n = adj.size();
        
        Stack<Integer> st = new Stack<Integer>();
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int vis [] = new int [n];
        
        for(int i=0;i<n;i++){
            
            if(vis[i] == 0){
                
                dfs(i , vis , adj , st);
                
            }
            
        }
        
        while(!st.isEmpty()){
            
            ans.add(st.pop());
            
        }
        
        return ans;
        
    }
    
}
