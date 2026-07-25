
public class CountNoOfNiceSubarrays {
    public int calculate(int [] nums , int k){

        int l = 0 , r = 0 , count = 0 , sum = 0;

        if(k < 0) return 0;

        while(r < nums.length){

            sum = sum + nums[r] % 2;

            while(sum > k){

                sum = sum - nums[l] % 2;
                l++;

            }

            if(sum <= k){
                count = count + (r - l + 1);
            }

            r++;

        }

        return count;

    }
    public int numberOfSubarrays(int[] nums, int k) {
        
        return calculate(nums , k) - calculate(nums , k - 1);

    }
}
