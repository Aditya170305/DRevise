public class LongestSubstringWithoutRepeatingCharacters {
    
    public static int maxPoints(int []arr , int K){
        
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;

        for(int i=0;i<K;i++){
            lsum = lsum + arr[i];
        }
        
        maxSum = lsum;

        int rightIndex = arr.length - 1;

        for(int i=K-1;i>=0;i--){
            lsum = lsum - arr[i];
            rsum = rsum + arr[rightIndex];
            rightIndex--;

            maxSum = Math.max(maxSum , lsum + rsum);

        }

        return maxSum;
    }
}
