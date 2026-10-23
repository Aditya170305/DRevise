import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentInArray {
    
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        
        int n = arr.length;
        
        Map<Integer , Integer> mpp = new TreeMap<Integer , Integer>(Collections.reverseOrder());
        
        for(int num : arr){
            
            if(mpp.containsKey(num)){
                mpp.put(num , mpp.get(num) + 1);
            }
            
            else{
                mpp.put(num , 1);
            }
            
        }
        
        ArrayList<Integer> bucket [] = new ArrayList [n + 1];
        
        for(Map.Entry<Integer , Integer> en : mpp.entrySet()){
            
            int key = en.getKey();
            int freq = en.getValue();
            
            if(bucket[freq] == null) bucket[freq] = new ArrayList<Integer>();
            bucket[freq].add(key);
            
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=n;i>=0;i--){
            
            if(k == 0) break;
            
            if(bucket[i] == null || bucket[i].size() == 0) continue;
            
            for(Integer str : bucket[i]){
                
                if(k == 0) break;
                ans.add(str);
                k--;
                
            }
            
        }
        
        return ans;
        
    }
    
}
