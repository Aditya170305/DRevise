import java.util.HashMap;
import java.util.Map;

public class AlLeastKOccurences {
    
    public int firstElementKTime(int[] arr, int k) {
        
        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();
        
        int count = 0;
        int if_multiple = -1;
        
        for(int i=0;i<arr.length;i++){
            
            int ele = arr[i];
            
            if(mpp.containsKey(ele)){
                
                int value = mpp.get(ele);
                
                mpp.put(ele , value + 1);
                
                if(value + 1 == k){
                    
                    if(if_multiple == -1) if_multiple = ele;
                    count++;
                    
                }
                
            }
            
            else{
                
                mpp.put(ele , 1);
                
                if(k == 1){
                    
                    if(if_multiple == -1) if_multiple = ele;
                    count++;
                    
                }
                
            }
            
        }
        
        return count > 0 ? if_multiple : -1;
        
    }
    
}
