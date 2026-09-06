public class MaximumPathInAMatrix {
    
    public static int find(int i , int j , int n , int m , int [][] matrix , int dp[][]){

		if(j < 0 || j >= m) return (int)(-1e9);
		if(i == 0) return matrix[0][j];

		if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

		int u = matrix[i][j] + find(i - 1 , j , n , m , matrix , dp);
		int ld = matrix[i][j] + find(i - 1 , j - 1 , n , m , matrix , dp);
		int rd = matrix[i][j] + find(i - 1 , j + 1 , n , m , matrix , dp);

		dp[i][j] = Math.max(u , Math.max(ld , rd));

		return dp[i][j];

	}

	public static int getMaxPathSum(int[][] matrix) {
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		int dp [][] = new int [n][m];

		// for(int i=0;i<n;i++){
		// 	Arrays.fill(dp[i] , Integer.MIN_VALUE);
		// }

		// int maxi = (int)(-1e9);

		// for(int j=0;j<m;j++){
		// 	maxi = Math.max(maxi , find(n - 1 , j , n , m , matrix , dp));
		// }

		// return maxi;

		for(int j =0;j<m;j++){
			dp[0][j] = matrix[0][j];
		}

		for(int i=1;i<n;i++){
			for(int j=0;j<m;j++){

				int u = matrix[i][j] + dp[i - 1][j];
				int ld = matrix[i][j];
				if(j - 1 >= 0) ld = ld + dp[i - 1][j - 1];
				else ld = ld + (int)(-1e9);

				int rd = matrix[i][j];
				if(j + 1 < m) rd = rd + dp[i - 1][j + 1];
				else rd = rd + (int)(-1e9);

				dp[i][j] = Math.max(u , Math.max(ld , rd));
			
			}
		}

		int maxi = (int)(-1e9);

		for(int j=0;j<m;j++){
			maxi = Math.max(maxi , dp[n - 1][j]);
		}

		return maxi;

	}
    
}
