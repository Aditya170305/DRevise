import java.util.Arrays;

public class L462 {
    
    public int minMoves2(int[] nums) {
        
        int n = nums.length;

        Arrays.sort(nums);

        int ans = 0;

        int mid_element = nums[n / 2];

        for(int i=0;i<n/2;i++){

            ans = ans + (mid_element - nums[i]);
            ans = ans + (nums[n - i - 1] - mid_element);

        }

        return ans;

    }
    
}
