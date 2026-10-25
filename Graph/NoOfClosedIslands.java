public class NoOfClosedIslands {
    
    public void dfs(int row , int col , int [] dr , int [] dc , int [][] grid , int [][] vis , int n , int m){

        vis[row][col] = 1;

        for(int i=0;i<4;i++){

            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0){

                if(vis[nrow][ncol] == 0 && grid[nrow][ncol] == 0){
                    dfs(nrow , ncol , dr , dc , grid , vis , n , m);
                }

            }

        }

    }

    public void dfs_check(int row , int col , int [] dr , int [] dc , int [][] grid , int [][] vis , int n , int m){

        vis[row][col] = -1;

        for(int i=0;i<4;i++){

            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0){

                if(grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0){
                    dfs_check(nrow , ncol , dr , dc , grid , vis , n , m);
                }

            }

        }

    }

    public int closedIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int vis [][] = new int [n][m];

        int dr [] = {+1 , 0 , -1 , 0};
        int dc [] = {0 , +1 , 0 , -1};

        for(int j=0;j<m;j++){
            if(vis[0][j] == 0 && grid[0][j] == 0){
                dfs_check(0 , j , dr , dc , grid , vis , n , m);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i][0] == 0 && grid[i][0] == 0){
                dfs_check(i , 0 , dr , dc , grid , vis , n , m);
            }
        }

        for(int j=0;j<m;j++){
            if(vis[n - 1][j] == 0 && grid[n - 1][j] == 0){
                dfs_check(n - 1 , j , dr , dc , grid , vis , n , m);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i][m - 1] == 0 && grid[i][m - 1] == 0){
                dfs_check(i , m - 1 , dr , dc , grid , vis , n , m);
            }
        }

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(vis[i][j] != -1 && vis[i][j] != 1 && grid[i][j] == 0){
                    dfs(i , j , dr , dc , grid , vis , n , m);
                    count++;
                }

            }

        }

        return count;

    }
    
}
