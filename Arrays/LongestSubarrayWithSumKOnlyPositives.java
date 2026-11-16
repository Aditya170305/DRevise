public class LongestSubarrayWithSumKOnlyPositives {
    
    public static int longestSubarrayWithSumK(int []a, long k) {
        
        int n = a.length;

        int max_len = 0;
        long sum = a[0];

        int l = 0;
        int r = 0;

        while(r < n){

            while(l <= r && sum > k){

                sum = sum - a[l];
                l++;

            }

            if(sum == k) max_len = Math.max(max_len , r - l + 1);

            r++;

            if(r < n) sum = sum + a[r];

        }

        return max_len;
        
    }
    
}
