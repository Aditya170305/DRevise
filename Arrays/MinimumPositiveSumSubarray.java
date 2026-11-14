import java.util.List;

public class MinimumPositiveSumSubarray {
    
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        int n = nums.size();

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            int sum = 0;

            for(int j=i;j<n;j++){

                sum = sum + nums.get(j);

                int size = j - i + 1;

                if(l <= size && size <= r){

                    if(sum > 0) ans = Math.min(ans , sum);

                }

            }

        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    
    }
    
}
