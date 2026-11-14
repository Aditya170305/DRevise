import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
    
    public String findOrder(String[] words) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<26;i++){
            
            adj.add(new ArrayList<>());
            
        }
        
        Set<Integer> st = new HashSet<Integer>();
        
        int indegree [] = new int [26];
        
        for(String word : words){
            
            for(int i=0;i<word.length();i++){
                
                st.add(word.charAt(i) - 'a');
                
            }
            
        }
        
        for(int i=0;i<words.length-1;i++){
            
            String s1 = words[i];
            String s2 = words[i + 1];
            
            for(int j=0;j<Math.min(s1.length() , s2.length());j++){
                
                if(s1.charAt(j) != s2.charAt(j)){
                
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';
                
                    adj.get(u).add(v);
                    
                    indegree[v]++;
                    break;
                    
                }
                
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        ArrayList<Integer> topo = new ArrayList<Integer>();
        
        for(int x : st){
            
            if(indegree[x] == 0) q.offer(x);
            
        }
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            topo.add(node);
            
            for(int it : adj.get(node)){
                
                indegree[it]--;
                
                if(indegree[it] == 0){
                    
                    q.offer(it);
                    
                }
                
            }
            
        }
        
        if(topo.size() != st.size()) return "";
        
        StringBuilder ans = new StringBuilder();
        
        for(int it : topo){
            
            ans.append((char)(it + (int)'a'));
            
        }
        
        return ans.toString();
        
    }
}
