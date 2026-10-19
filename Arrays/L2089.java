import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2089 {
    
    public List<Integer> targetIndices(int[] nums, int target) {
        
        // Arrays.sort(nums);

        // int low = 0;
        // int high = nums.length - 1;

        // List<Integer> ans = new ArrayList<Integer>();

        // for(int i=0;i<nums.length;i++){
        //     if(nums[i] == target) ans.add(i);
        // }

        // return ans;

        int min_count = 0;
        int target_count = 0;

        for(int i=0;i<nums.length;i++){

            if(nums[i] < target) min_count++;
            if(nums[i] == target) target_count++;

        }

        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0;i<target_count;i++){
            
            ans.add(min_count);
            min_count++;

        }

        return ans;

    }

}
