public class Knapsack01Problem {
    
    static int find(int index , int maxWeight , int [] weight , int [] value , int [][] dp){

        if(index == 0){

            return (weight[0] <= maxWeight) ? value[0] : 0;

        }

        if(dp[index][maxWeight] != -1) return dp[index][maxWeight];

        int not_take = 0 + find(index - 1 , maxWeight , weight , value , dp);
        int take = Integer.MIN_VALUE;

        if(weight[index] <= maxWeight) take = value[index] + find(index - 1 , maxWeight - weight[index] , weight , value , dp);

        dp[index][maxWeight] = Math.max(take , not_take);

        return dp[index][maxWeight];

    }
    
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            int dp [][] = new int [n][maxWeight + 1];

            // for(int i=0;i<n;i++){
            //     Arrays.fill(dp[i] , -1);
            // }

            // return find(n - 1 , maxWeight , weight , value , dp);

            for(int wt=weight[0];wt<=maxWeight;wt++){
                dp[0][wt] = value[0];
            }

            for(int index=1;index<n;index++){
                for(int wt=0;wt<=maxWeight;wt++){

                    int not_take = 0 + dp[index - 1][wt];
                    int take = Integer.MIN_VALUE;

                    if(weight[index] <= wt) take = value[index] + dp[index - 1][wt - weight[index]];

                    dp[index][wt] = Math.max(take , not_take);

                }
            }

            return dp[n - 1][maxWeight];

    }

}
