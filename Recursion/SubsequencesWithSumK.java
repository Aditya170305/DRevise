public class SubsequencesWithSumK {
    
    public boolean find(int index , int sum , int [] arr , int k , int [][] dp){
        
        if(sum == k) return true;
        
        if(index == arr.length || sum > k) return false;
        
        if(dp[index][sum] != -1){
            return dp[index][sum] == 1;
        }
        
        sum = sum + arr[index];
        
        boolean pick = false;
        boolean non_pick = false;
        
        if(find(index + 1 , sum , arr , k , dp)) pick = true;
        
        sum = sum - arr[index];
        
        if(find(index + 1 , sum , arr , k , dp)) non_pick = true;
        
        if(pick || non_pick) dp[index][sum] = 1;
        else dp[index][sum] = 0;
        
        return pick || non_pick;
        
    }
    
    public boolean checkSubsequenceSum(int[] arr, int k) {
        
        int n = arr.length;
        
        int dp [][] = new int [n][k + 1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<k+1;j++){
                
                dp[i][j] = -1;
                
            }
            
        }
        
        return find(0 , 0 , arr , k , dp);
        
    }
    
}
