public class CoinChange {
    
    public int find(int index , int amount , int dp [][] , int coins []){

        if(index == 0){

            return (amount % coins[0] == 0) ? amount / coins[0] : (int)(1e9);

        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int not_take = 0 + find(index - 1 , amount , dp , coins);
        int take = Integer.MAX_VALUE;

        if(amount >= coins[index]) take = 1 + find(index , amount - coins[index] , dp , coins);

        dp[index][amount] = Math.min(not_take , take);

        return dp[index][amount];

    }

    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;

        int dp [][] = new int [n][amount + 1];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i] , -1);
        // }

        // int ans = find(n - 1 , amount , dp , coins);

        // return (ans >= (int)(1e9)) ? -1 : ans;

        for(int i=0;i<=amount;i++){
            dp[0][i] = (i % coins[0] == 0) ? i / coins[0] : (int)(1e9); 
        }

        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){

                int not_take = 0 + dp[i - 1][t];
                int take = Integer.MAX_VALUE;

                if(t >= coins[i]) take = 1 + dp[i][t - coins[i]];

                dp[i][t] = Math.min(take , not_take);

            }
        }

        int ans = dp[n - 1][amount];

        return (ans >= (int)(1e9)) ? -1 : ans;

    }
    
}
