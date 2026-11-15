import java.util.List;

public class MinimumPositiveSumSubarrayByPrefixSum {
    
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        int n = nums.size();

        int preSum [] = new int [n];

        preSum[0] = nums.get(0);

        for(int i=1;i<n;i++){

            preSum[i] = preSum[i - 1] + nums.get(i);

        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            for(int len=l;len<=r && i + len - 1 < n;len++){

                int j = i + len - 1;

                int sum = 0;

                if(i == 0) sum = preSum[j];
                else sum = preSum[j] - preSum[i - 1];

                if(sum > 0) ans = Math.min(ans , sum);

            }

        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;

    }
    
}
