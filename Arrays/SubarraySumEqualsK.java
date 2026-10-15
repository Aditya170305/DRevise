import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    
    public int subarraySum(int[] nums, int k) {
        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();
        mpp.put(0 , 1);
        int count = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];

            int rem = sum - k;
            if(mpp.containsKey(rem)){
                count = count + mpp.get(rem);
            }

            if(mpp.containsKey(sum)){
                mpp.put(sum , mpp.get(sum) + 1);
            }
            else{
                mpp.put(sum , 1);
            }
            
        }
        return count;
    }
    
}
