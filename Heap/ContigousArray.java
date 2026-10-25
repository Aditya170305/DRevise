import java.util.HashMap;
import java.util.Map;

public class ContigousArray {
    
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;

        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        mpp.put(0 , -1);

        int sum = 0;

        int maxi = 0;

        for(int i=0;i<n;i++){

            sum = sum + ((nums[i] == 1) ? 1 : -1);

            if(mpp.containsKey(sum)){
                maxi = Math.max(maxi , i - mpp.get(sum));
            }

            else{
                mpp.put(sum , i);
            }

        }

        return maxi;

    }
    
}
