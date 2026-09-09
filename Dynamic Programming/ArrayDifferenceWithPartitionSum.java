public class ArrayDifferenceWithPartitionSum {
    
    public static int minSubsetSumDifference(int []arr, int n) {
        
        int sum = 0;

        for(int i=0;i<n;i++){
            sum = sum + arr[i];
        }

        boolean dp [][] = new boolean [n][sum + 1];

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        dp[0][arr[0]] = true;

        int k = sum;

        for(int index=1;index<n;index++){

            for(int target=1;target<=k;target++){

                boolean not_take = dp[index - 1][target];

                boolean take = false;

                if(target >= arr[index]) take = dp[index - 1][target - arr[index]];

                dp[index][target] = take || not_take;

            }
        }

        int mini = (int)(1e9);

        for(int s1=0;s1<=sum / 2;s1++){

            if(dp[n - 1][s1]) mini = Math.min(mini , Math.abs((sum - s1) - s1));

        }

        return mini;

    }
    
}
