import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithK {
    
    public int longestSubarray(int[] arr, int k) {
        
        int n = arr.length;
        
        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();
        
        int max_len = 0;
        
        int sum = 0;
        
        for(int i=0;i<n;i++){
            
            sum = sum + arr[i];
            
            if(sum == k){
                
                max_len = Math.max(max_len , i + 1);
                
            }
            
            int rem = sum - k;
            
            if(mpp.containsKey(rem)){
                
                int len = i - mpp.get(rem);
                max_len = Math.max(max_len , len);
                
            }
            
            if(!mpp.containsKey(sum)){
                
                mpp.put(sum , i);
                
            }
        }
        
        return max_len;
        
    }
    
}
