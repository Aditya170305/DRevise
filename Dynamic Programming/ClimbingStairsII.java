public class ClimbingStairsII {
    
    public int find(int i , int [] dp , int n , int [] costs){

        if(i == n) return 0;

        if(dp[i] != -1){

            return dp[i];

        }

        int ans = Integer.MAX_VALUE;

        for(int j=i+1;j<=Math.min(i + 3 , n);j++){

            int jumpCost = costs[j - 1] + (j - i) * (j - i);
            int remainingCost = find(j , dp , n , costs);
            ans = Math.min(ans , jumpCost + remainingCost);

            dp[i] = ans;

        }

        return ans;

    }

    public int climbStairs(int n, int[] costs) {

        // int dp [] = new int [n + 1];

        // for(int i=0;i<=n;i++){

        //     dp[i] = -1;

        // }
        
        // return find(0 , dp , n , costs);

        int dp [] = new int [n + 1];

        for(int i=n-1;i>=0;i--){

            int ans = Integer.MAX_VALUE;

            for(int j=i+1;j<=Math.min(i + 3 , n);j++){

                int jumpCost = costs[j - 1] + (j - i) * (j - i);
                int remainingCost = dp[j];
                ans = Math.min(ans , jumpCost + remainingCost);

                dp[i] = ans;

            }

        }

        return dp[0];

    }
    
}
