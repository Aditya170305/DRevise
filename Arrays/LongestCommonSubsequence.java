import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {
    
    public int longestConsecutive(int[] arr) {
        
        int n = arr.length;
        
        if(n == 0) return 0;
        
        Set<Integer> st = new HashSet<Integer>();
        
        for(int num : arr){
            
            st.add(num);
            
        }
        
        int largest = 1;
        
        for(int num : st){
            
            if(!st.contains(num - 1)){
                
                int count = 1;
                int x = num;
                
                while(st.contains(x + 1)){
                    
                    x++;
                    count++;
                    
                }
                
                largest = Math.max(largest , count);
                
            }
            
        }
        
        return largest;
        
    }
    
}
