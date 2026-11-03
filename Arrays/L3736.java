public class L3736 {
    
    public int minMoves(int[] nums) {
        
        int maxi = Integer.MIN_VALUE;
        
        for(int num : nums){

            maxi = Math.max(maxi , num);

        }

        int ans = 0;

        for(int num : nums){

            ans = ans + (maxi - num);

        }

        return ans;

    }
    
}
