public class MinimumSunOfSquaredDifference {
    
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int n = nums1.length;
        int maxDiff = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxDiff = Math.max(maxDiff , Math.abs(nums1[i] - nums2[i]));
        }

        int freq [] = new int [maxDiff + 1];

        for(int i=0;i<n;i++){
            int diff = Math.abs(nums1[i] - nums2[i]);;
            freq[diff]++;
        }

        int k = k1 + k2;

        for(int i=maxDiff;i>0 && k>0;i--){

            int countOps = Math.min(freq[i] , k);
            freq[i] = freq[i] - countOps;
            freq[i - 1] = freq[i - 1] + countOps;
            k = k - countOps;

        }

        long ans = 0;

        for(int i=1;i<=maxDiff;i++){

            ans = ans + (long)freq[i] * i * i;

        }

        return ans;

    }

}
