import java.util.Arrays;

public class HouseRobber {
    
    public int find(int index , int [] nums , int [] dp){

        if(index == 0) return nums[0];
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + find(index - 2 , nums , dp);
        int non_pick = 0 + find(index - 1 , nums , dp);

        dp[index] = Math.max(pick , non_pick);
        return dp[index];

    }

    public int rob(int[] nums) {
        
        int n = nums.length;

        int dp [] = new int [n];

        Arrays.fill(dp , -1);

        // return find(n - 1 , nums , dp);

        int prev = nums[0];
        int prev2 = 0;

        for(int i=1;i<n;i++){

            int take = nums[i] + prev2;
            int non_take = 0 + prev;

            int curi = Math.max(take , non_take);

            prev2 = prev;
            prev = curi;

        }

        return prev;

    }
}
