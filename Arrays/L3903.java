public class L3903 {
    
    public int firstStableIndex(int[] nums, int k) {

        int maxi = -1;
        for(int i=0;i<nums.length;i++){

            maxi = Math.max(maxi , nums[i]);

            int mini = Integer.MAX_VALUE;

            for(int j=i;j<nums.length;j++){

                mini = Math.min(mini , nums[j]);

            }

            if(maxi - mini <= k) return i;

        }

        return -1;
        
    }
    
}
