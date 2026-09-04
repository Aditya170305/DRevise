public class UniquePathsII {
    
    public int mod = (int)(2 * 1e9);

    public int find(int i , int j , int [][] dp , int [][] mat){

        if(i >= 0 && j >= 0 && mat[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int up = find(i - 1 , j , dp , mat);
        int left = find(i , j - 1 , dp , mat);

        dp[i][j] = (up + left) % mod;

        return dp[i][j];

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int dp [][] = new int [obstacleGrid.length][obstacleGrid[0].length];

        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[i].length;j++){

                dp[i][j] = -1;

            }
        }
        
        return find(obstacleGrid.length - 1 , obstacleGrid[0].length - 1 , dp , obstacleGrid);

    }
    
}
