import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithXORK {
    
    public long subarrayXor(int arr[], int k) {
        
        int n = arr.length;
        
        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();
        
        mpp.put(0 , 1);
        
        int ans = 0;
        
        int XOR = 0;
        
        for(int i=0;i<n;i++){
            
            XOR = XOR ^ arr[i];
            
            int x = XOR ^ k;
            
            if(mpp.containsKey(x)){
                
                ans = ans + mpp.get(x);
                
            }
            
            if(mpp.containsKey(XOR)){
                
                mpp.put(XOR , mpp.get(XOR) + 1);
                
            }
            
            else{
                
                mpp.put(XOR , 1);
                
            }
            
        }
        
        return ans;
        
    }
    
}
