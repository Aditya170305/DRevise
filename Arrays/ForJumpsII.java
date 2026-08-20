public class ForJumpsII {
    
    int minCost(int[] height) {
        
        int n = height.length;
        
        // int dp [] = new int [n];
        
        // dp[0] = 0;
        
        if(n == 1) return 0;
        
        int prev = Math.abs(height[1] - height[0]);
        int prev2 = 0;
        
        for(int i=2;i<n;i++){
            
            // int first = dp[i - 1] + Math.abs(height[i] - height[i - 1])
            int first = prev + Math.abs(height[i] - height[i - 1]);
            int second = Integer.MAX_VALUE;
            // if(i > 1) second = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            if(i > 1) second = prev2 + Math.abs(height[i] - height[i - 2]);
            
            // dp[i] = Math.min(first , second);
            prev2 = prev;
            prev = Math.min(first , second);
            
        }
        
        // return dp[n - 1];
        return prev;
        
    }
}
