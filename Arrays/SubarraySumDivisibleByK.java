import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    
    public int subarraysDivByK(int[] nums, int k) {
        
        int ans = 0;

        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();
        int sum = 0;
        mpp.put(0 , 1);

        for(int num : nums){

            sum = sum + num;

            int rem = sum % k;

            if(rem < 0) rem = rem + k;

            if(mpp.containsKey(rem)){
                ans = ans + mpp.get(rem);
                mpp.put(rem, mpp.get(rem) + 1);
            }

            // if(mpp.containsKey(rem)){
            //     mpp.put(rem , mpp.get(rem) + 1);
            // }

            else{
                mpp.put(rem , 1);
            }

        }

        return ans;

    }
    
}
