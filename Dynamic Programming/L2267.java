public class L2267 {
    
    public boolean find(int i , int j , int n , int m , char [][] grid , int dp [][][] , int count){

        if(count < 0) return false;

        if(i < 0 || j < 0){

            return false;

        }

        if(i == 0 && j == 0){

            if(grid[i][j] == ')') count++;
            else count--;

            return (count == 0);

        }

        if(dp[i][j][count] != -1){

            return dp[i][j][count] == 1 ? true : false;

        }

        boolean top = false;
        boolean left = false;

        if(grid[i][j] == ')'){

            top = find(i - 1 , j , n , m , grid , dp , count + 1);
            left = find(i , j - 1 , n , m , grid , dp , count + 1);
        
        }

        else{

            top = find(i - 1 , j , n , m , grid , dp , count - 1);
            left = find(i , j - 1 , n , m , grid , dp , count - 1);

        }

        dp[i][j][count] = (top || left) ? 1 : 0;

        return top || left;

    }

    public boolean hasValidPath(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int dp [][][] = new int [n][m][n + m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return find(n - 1 , m - 1 , n , m , grid , dp , 0);

    }
    
}
