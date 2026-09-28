public class MaximumAverageSubarrayI {
    
    public double findMaxAverage(int[] nums, int k) {
        
        double avg = Double.NEGATIVE_INFINITY;

        int n = nums.length;

        int l = 0 , r = 0;

        int sum = 0;

        while(r < n){

            sum = sum + nums[r];

            if((r - l + 1) > k){
                sum = sum - nums[l];
                l++;
            }

            if((r - l + 1) == k){
                double temp = (double)sum / k;
                avg = Math.max(temp , avg);
            }

            r++;

        }

        return avg;

    }
    
}
