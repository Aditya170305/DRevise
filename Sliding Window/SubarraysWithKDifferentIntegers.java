import java.util.Map;
import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    public int calculate(int [] nums , int k){

        int l = 0 , r = 0 , count = 0;
        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        while(r < nums.length){

            if(mpp.containsKey(nums[r])){
                mpp.put(nums[r] , mpp.get(nums[r]) + 1);
            }

            else{
                mpp.put(nums[r] , 1);
            }

            while(mpp.size() > k){

                mpp.put(nums[l] , mpp.get(nums[l]) - 1);

                if(mpp.get(nums[l]) == 0){
                    mpp.remove(nums[l]);
                }

                l++;

            }

            count = count + (r - l + 1);
            r++;

        }

        return count;
        
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return calculate(nums , k) - calculate(nums , k - 1);

    }
}
