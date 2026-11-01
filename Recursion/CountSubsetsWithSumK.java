public class CountSubsetsWithSumK {
    
    static int find(int index , int sum , int [] arr , int [][] dp){
        
        if(index == 0){
            
            if(sum == 0 && arr[0] == 0) return 2;
            if(sum == 0 || arr[0] == sum) return 1;
            return 0;
            
        }
        
        if(dp[index][sum] != -1){
            return dp[index][sum];
        }
        
        int take = 0;
        
        if(sum >= arr[index]) take = find(index - 1 , sum - arr[index] , arr , dp);
        
        int not_take = 0;
        
        not_take = find(index - 1 , sum , arr , dp);
        
        dp[index][sum] = take + not_take;
        
        return dp[index][sum];
        
    }
    
    static int perfectSum(int[] arr, int target) {
        
        int n = arr.length;
        
        int dp [][] = new int [n][target + 1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<target+1;j++){
                
                dp[i][j] = -1;
                
            }
            
        }
        
        return find(n - 1 , target , arr , dp);
        
    }
    
}
