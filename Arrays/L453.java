public class L453 {
    
    public int minMoves(int[] nums) {
        
        int n = nums.length;

        int mini = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0;i<n;i++){

            mini = Math.min(mini , nums[i]);
            sum = sum + nums[i];

        }

        return sum - n * mini;

    }
    
}
