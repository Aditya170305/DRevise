import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2089 {
    
    public List<Integer> targetIndices(int[] nums, int target) {
        
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;

        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] == target) ans.add(i);
        }

        return ans;

    }
    
}
