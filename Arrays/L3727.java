import java.util.Arrays;

public class L3727 {
    
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;

        long arr [] = new long [n];

        for(int i=0;i<n;i++){
            arr[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(arr);

        long largeValue = 0;

        for(int i=n/2;i<n;i++){
            largeValue = largeValue + arr[i];
        }

        long smallValue = 0;

        for(int i=0;i<n/2;i++){
            smallValue = smallValue + arr[i];
        }

        return largeValue - smallValue;

    }
    
}
