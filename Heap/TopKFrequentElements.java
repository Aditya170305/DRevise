import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        for(int num : nums){

            if(mpp.containsKey(num)){
                mpp.put(num , mpp.get(num) + 1);
            }

            else{
                mpp.put(num , 1);
            }

        }

        List<Integer> bucket [] = new ArrayList[n + 1];

        for(Map.Entry<Integer , Integer> en : mpp.entrySet()){

            int val = en.getKey();
            int freq = en.getValue();

            if(bucket[freq] == null) bucket[freq] = new ArrayList<Integer>();
            bucket[freq].add(val);

        }

        int ans [] = new int [k];
        int index = 0;

        for(int i=n;i>=0;i--){

            if(bucket[i] == null) continue;
            if(bucket[i].size() == 0) continue;

            for(int j=0;j<bucket[i].size();j++){
                if(k == 0) break;
                ans[index++] = bucket[i].get(j);
                k--;
            }

        }

        return ans;

    }
    
}
