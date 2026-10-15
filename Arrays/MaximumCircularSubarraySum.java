public class MaximumCircularSubarraySum {

    public int maxSum(int [] nums){

        int sum = nums[0];
        int max_sum = nums[0];

        for(int i=1;i<nums.length;i++){

            sum = Math.max(sum + nums[i] , nums[i]);
            max_sum = Math.max(max_sum , sum);

        }

        return max_sum;

    }

    public int minSum(int [] nums){

        int sum = nums[0];
        int min_sum = nums[0];

        for(int i=1;i<nums.length;i++){

            sum = Math.min(sum + nums[i] , nums[i]);
            min_sum = Math.min(min_sum , sum);

        }

        return min_sum;

    }

    public int maxSubarraySumCircular(int[] nums) {
        
        int sum = nums[0];
        int minSum = nums[0];
        int maxSum = nums[0];
        int cur_min = nums[0];
        int cur_max = nums[0];

        for(int i=1;i<nums.length;i++){
            sum = sum + nums[i];
            cur_max = Math.max(cur_max + nums[i] , nums[i]);
            maxSum = Math.max(maxSum , cur_max);
            cur_min = Math.min(cur_min + nums[i] , nums[i]);
            minSum = Math.min(cur_min , minSum);
        }

        // int minSum = minSum(nums);
        // int maxSum = maxSum(nums);

        int circular_sum = sum - minSum;

        if(maxSum > 0) return Math.max(maxSum , circular_sum);
        return maxSum;

    }
    
}

