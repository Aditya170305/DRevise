public class TwistedPathMirrorCount {
    
    static final int UP = 0;
    static final int LEFT = 1;
    static final int MOD = 1000000007;

    public int find(int i , int j , int [][] grid , int [][][] dp , int n , int m , int cameFrom){

        if(i >= n || j >= m) return 0;

        if(i == n - 1 && j == m - 1) return 1;

        if(dp[i][j][cameFrom] != -1){
            return dp[i][j][cameFrom];
        }

        if(grid[i][j] == 1){

            if(cameFrom == LEFT){
                dp[i][j][cameFrom] = find(i + 1 , j , grid , dp , n , m , UP);
            }

            else{
                dp[i][j][cameFrom] = find(i , j + 1 , grid , dp , n , m , LEFT);
            }

            return dp[i][j][cameFrom];

        }

        int totalPathCount = 0;

        totalPathCount = (totalPathCount + find(i , j + 1 , grid , dp , n , m , LEFT)) % MOD;
        totalPathCount = (totalPathCount + find(i + 1 , j , grid , dp , n , m , UP)) % MOD;

        dp[i][j][cameFrom] = totalPathCount;

        return dp[i][j][cameFrom]; 
       
    }

    public int uniquePaths(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int dp [][][] = new int [n][m][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<2;k++){

                    dp[i][j][k] = -1;

                }

            }

        }

        return find(0 , 0 , grid , dp , n , m , LEFT);

    }
    
}
