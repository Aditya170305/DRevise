import java.util.HashMap;
import java.util.Map;

public class AnyDuplicatesWithinKDistance {
    
    public boolean checkWithinK(int[] arr, int k) {
        
        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();
        
        for(int i=0;i<arr.length;i++){
            
            int ele = arr[i];
            
            if(mpp.containsKey(ele)){
                
                int value = mpp.get(ele);
                
                if((i - value) <= k) return true;
                
                mpp.put(ele , i);
                
            }
            
            else{
                
                mpp.put(ele , i);
                
            }
            
        }
        
        return false;
        
    }
    
}
