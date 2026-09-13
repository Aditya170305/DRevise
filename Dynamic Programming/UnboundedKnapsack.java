public class UnboundedKnapsack {
    
    public static int find(int index , int w , int [][] dp , int [] profit , int [] weight){

        if(index == 0){

            return (w / weight[0]) * profit[0];

        }

        if(dp[index][w] != -1) return dp[index][w];

        int not_take = 0 + find(index - 1 , w , dp , profit , weight);
        int take = Integer.MIN_VALUE;

        if(w >= weight[index]) take = profit[index] + find(index , w - weight[index] , dp , profit , weight);

        dp[index][w] = Math.max(take , not_take);

        return dp[index][w];

    }
    
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        
        int dp [][] = new int [n][w + 1];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i] , -1);
        // }

        // return find(n - 1 , w , dp , profit , weight);

        for(int i=weight[0];i<=w;i++){
            dp[0][i] = (i / weight[0]) * profit[0];
        }

        for(int index=1;index<n;index++){
            for(int wt=0;wt<=w;wt++){

                int not_take = 0 + dp[index - 1][wt];
                int take = Integer.MIN_VALUE;

                if(wt >= weight[index]) take = profit[index] + dp[index][wt - weight[index]];

                dp[index][wt] = Math.max(take , not_take);

            }

        }

        return dp[n - 1][w];

    }
    
}
