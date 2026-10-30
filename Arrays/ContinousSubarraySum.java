import java.util.HashMap;
import java.util.Map;

public class ContinousSubarraySum {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n = nums.length;

        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        int sum = 0;

        mpp.put(0 , -1);

        for(int i=0;i<n;i++){

            sum = sum + nums[i];

            int remainder = sum % k;

            if(mpp.containsKey(remainder)){

                if(i - mpp.get(remainder) >= 2) return true;
                
            }

            else{
                
                mpp.put(remainder , i);

            }

        }

        return false;

    }
    
}
