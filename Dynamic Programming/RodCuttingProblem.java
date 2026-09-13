public class RodCuttingProblem {
    
    public static int find(int index , int n , int [][] dp , int [] price){

		if(index == 0){
			return n * price[0];
		}

		if(dp[index][n] != -1) return dp[index][n];

		int not_take = 0 + find(index - 1 , n , dp , price);
		int take = Integer.MIN_VALUE;

		int rodLength = index + 1;

		if(rodLength <= n) take = price[index] + find(index , n - rodLength , dp , price);

		dp[index][n] = Math.max(take , not_take);

		return dp[index][n];

	}
	 
	public static int cutRod(int price[], int n) {
		
		int dp [][] = new int [n][n + 1];

		// for(int i=0;i<n;i++){
		// 	Arrays.fill(dp[i] , -1);
		// }

		// return find(n - 1 , n , dp , price);

		for(int N=0;N<=n;N++){
			dp[0][N] = N * price[0];
		}

		for(int index=1;index<n;index++){
			for(int N=0;N<=n;N++){

				int not_take = 0 + dp[index - 1][N];
				int take = Integer.MIN_VALUE;

				int rodLength = index + 1;
				if(rodLength <= N) take = price[index] + dp[index][N - rodLength];

				dp[index][N] = Math.max(take , not_take);

			}

		}

		return dp[n - 1][n];

	}
    
}
