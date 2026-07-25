
public class BinarySubarraysWithSum {
    public static int calculate(int [] nums , int goal){

        int count = 0 ;
        int l = 0;
        int r = 0;
        int sum = 0;

        if(goal < 0) return 0;

        while(r < nums.length){

            sum = sum + nums[r];

            while(sum > goal){
                sum = sum - nums[l];
                l++;
            }

            if(sum <= goal){
                count = count + (r - l + 1);
            }

            r++;

        }

        return count;

    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        
        return calculate(nums , goal) - calculate(nums , goal - 1);

    }
}
