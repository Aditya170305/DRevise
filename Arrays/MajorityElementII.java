import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementII {
    
    public ArrayList<Integer> findMajority(int[] arr) {
        
        int n = arr.length;
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();
        
        for(int i=0;i<n;i++){
            
            if(mpp.containsKey(arr[i])){
                
                mpp.put(arr[i] , mpp.get(arr[i]) + 1);
                
            }
            
            else{
                
                mpp.put(arr[i] , 1);
                
            }
            
        }
        
        for(Map.Entry<Integer , Integer> en : mpp.entrySet()){
            
            int key = en.getKey();
            int val = en.getValue();
            
            if(val > (n / 3)) ans.add(key);
            
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }
    
}
