public class L3105 {
    
    public int longestMonotonicSubarray(int[] nums) {
        
        int n = nums.length;

        int ans = 1;

        for(int i=0;i<n;i++){

            boolean s_inc = true;
            boolean s_dec = true;

            for(int j=i+1;j<n;j++){

                if(nums[j] > nums[j - 1] && s_inc){

                    ans = Math.max(ans , j - i + 1);

                }

                else{

                    s_inc = false;

                }

                if(nums[j] < nums[j - 1] && s_dec){

                    ans = Math.max(ans , j - i + 1);

                }

                else{

                    s_dec = false;

                }

                if(!s_inc && !s_dec) break;

            }

        }

        return ans;

    }
    
}
