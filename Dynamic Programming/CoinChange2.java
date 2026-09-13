public class CoinChange2 {
    
    public int find(int index , int amount , int dp [][] , int coins []){

        if(index == 0){

            return (amount % coins[0] == 0) ? 1 : 0;

        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int not_take = find(index - 1 , amount , dp , coins);
        int take = 0;

        if(amount >= coins[index]) take = find(index , amount - coins[index] , dp , coins);

        dp[index][amount] = take + not_take;

        return dp[index][amount];

    }

    public int change(int amount, int[] coins) {
        
        int n = coins.length;

        int dp [][] = new int [n][amount + 1];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i] , -1);
        // }

        // return find(n - 1 , amount , dp , coins);

        for(int i=0;i<=amount;i++){
            dp[0][i] = (i % coins[0] == 0) ? 1 : 0;
        }

        for(int index=1;index<n;index++){
            for(int t=0;t<=amount;t++){

                int not_take = dp[index - 1][t];
                int take = 0;

                if(t >= coins[index]) take = dp[index][t - coins[index]];

                dp[index][t] = take + not_take;

            }
        }

        return dp[n - 1][amount];

    }
    
}
