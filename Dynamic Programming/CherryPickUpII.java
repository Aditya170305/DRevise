public class CherryPickUpII {
    
    public int find(int i , int j1 , int j2 , int row , int col , int dp [][][] , int grid [][]){

        if(j1 < 0 || j2 < 0 || j1 >= col || j2 >= col) return (int)(-1e8);

        if(i == row - 1){

            if(j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];

        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = (int)(-1e8);

        for(int dj1=-1;dj1<=1;dj1++){
            
            int value = 0;

            for(int dj2=-1;dj2<=1;dj2++){

                if(j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value = value + find(i + 1 , j1 + dj1 , j2 + dj2 , row , col , dp , grid);

                maxi = Math.max(maxi , value);

            }

        }

        dp[i][j1][j2] = maxi;

        return dp[i][j1][j2];

    }

    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int dp [][][] = new int [n][m][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){

                    dp[i][j][k] = -1;

                }
            }
        }

        return find(0 , 0 , m - 1 , n , m , dp , grid);

    }
    
}
