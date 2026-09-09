import java.util.Arrays;

public class SubsetSumEqualsToK {
    
    static boolean find(int index , int sum , int [][] dp , int [] arr){
        
        if(sum == 0) return true;
        
        if(index == 0) return (arr[0] == sum);
        
        if(dp[index][sum] != -1){
            
            if(dp[index][sum] == 1) return true;
            return false;
            
        }
        
        boolean not_take = find(index - 1 , sum , dp , arr);
        
        boolean take = false;
        
        if(sum >= arr[index]) take = find(index - 1 , sum - arr[index] , dp , arr);
        
        dp[index][sum] = (take || not_take) ? 1 : 0;
        
        return take || not_take;
        
    }
    
    static boolean isSubsetSum(int arr[], int sum) {
        
        // int dp [][] = new int [201][10001];
        
        // for(int i=0;i<arr.length;i++){
        //     Arrays.fill(dp[i] , -1);
        // }
        
        // return find(arr.length - 1 , sum , dp , arr);

        int n = arr.length;
        int k = sum;

        boolean dp [][] = new boolean [n][k + 1];

        for(int i=0;i<n;i++) dp[i][0] = true;

        if(arr[0] <= k) dp[0][arr[0]] = true;

        for(int index=1;index<n;index++){

            for(int target=1;target<=k;target++){

                boolean not_take = dp[index - 1][target];

                boolean take = false;

                if(target >= arr[index]) take = dp[index - 1][target - arr[index]];

                dp[index][target] = not_take || take;

            }

        }

        return dp[n - 1][k];
        
    }
    
}
