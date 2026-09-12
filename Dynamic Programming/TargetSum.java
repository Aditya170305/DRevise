import java.util.Arrays;

public class TargetSum {
    
    public int find(int index , int sum , int dp [][] , int nums []){

        if(index == 0){
            if(sum == 0 && nums[0] == 0) return 2;
            if(sum == 0 || nums[0] == sum) return 1;
            return 0;
        }

        if(dp[index][sum] != -1) return dp[index][sum];

        int not_take = find(index - 1 , sum , dp , nums);
        int take = 0;

        if(sum >= nums[index]) take = find(index - 1 , sum - nums[index] , dp , nums);

        dp[index][sum] = take + not_take;

        return dp[index][sum];

    }

    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;

        int totalSum = 0;

        for(int i=0;i<n;i++){
            totalSum = totalSum + nums[i];
        }

        if(totalSum - target < 0 || (totalSum - target) % 2 == 1) return 0;

        int sum = (totalSum - target) / 2;

        int dp [][] = new int [n][sum + 1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i] , -1);
        }

        return find(n - 1 , sum , dp , nums);

    }
    
}
