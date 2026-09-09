
import java.util.Arrays;

public class PartitionEqualSubsetSum {
    
    public boolean find(int index , int sum , int n , int dp [][] , int nums []){

        if(sum == 0) return true;

        if(index == 0) return (nums[0] == sum);

        if(dp[index][sum] != -1){

            if(dp[index][sum] == 1) return true;
            return false;

        }

        boolean not_take = find(index - 1 , sum , n , dp , nums);

        boolean take = false;

        if(sum >= nums[index]) take = find(index - 1 , sum - nums[index] , n , dp , nums);

        dp[index][sum] = (take || not_take) ? 1 : 0;

        return take || not_take;

    }

    public boolean canPartition(int[] nums) {
        
        int n = nums.length;

        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
        }

        if(sum % 2 == 1) return false;
        sum = sum / 2;

        int dp [][] = new int [n][sum + 1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i] , -1);
        }

        return find(n - 1 , sum , n , dp , nums);

    }
    
}
