import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class WordBreak {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> st = new HashSet<String>(wordDict);
        Queue<Integer> q = new LinkedList<Integer>();
        boolean visited [] = new boolean [s.length() + 1];

        q.offer(0);

        while(!q.isEmpty()){

            int i = q.poll();

            if(i == s.length()){
                return true;
            }

            for(int j=i+1;j<=s.length();j++){

                if(visited[j]){
                    continue;
                }

                if(st.contains(s.substring(i , j))){
                    q.offer(j);
                    visited[j] = true;
                }

            }

        }

        return false;

    }

}
