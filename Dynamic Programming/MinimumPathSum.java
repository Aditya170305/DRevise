public class MinimumPathSum {
    
    public int find(int i , int j , int grid [][] , int dp [][]){

        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return (int)(1e9);

        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + find(i - 1 , j , grid , dp);
        int left = grid[i][j] + find(i , j - 1 , grid , dp);

        dp[i][j] = Math.min(up , left);

        return dp[i][j];

    }

    public int minPathSum(int[][] grid) {
        
        // int n = grid.length;
        // int m = grid[0].length;

        // int dp [][] = new int [n][m];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){

        //         dp[i][j] = -1;

        //     }
        // }

        // return find(n - 1 , m - 1 , grid , dp);

        int n = grid.length;
        int m = grid[0].length;

        int dp [][] = new int [n][m];

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                if(i == 0 && j == 0) dp[i][j] = grid[0][0];

                else{

                    int up = 0;
                    int left = 0;

                    if(i > 0) up = grid[i][j] + dp[i - 1][j];
                    else up = up + (int)(1e9);
                    if(j > 0) left = grid[i][j] + dp[i][j - 1];
                    else left = left + (int)(1e9);
                    dp[i][j] = Math.min(up , left);

                }

            }

        }

        return dp[n - 1][m - 1];

    }
    
}
