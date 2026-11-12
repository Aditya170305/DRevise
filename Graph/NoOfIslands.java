public class NoOfIslands {
    
    public void dfs(int row , int col , char [][] grid , int [][] vis , int n , int m){
        
        vis[row][col] = 1;
        
        for(int delr=-1;delr<=1;delr++){
            for(int delc=-1;delc<=1;delc++){
                
                int nrow = row + delr;
                int ncol = col + delc;
                
                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0){
                    
                    if(grid[nrow][ncol] == 'L' && vis[nrow][ncol] == 0){
                        
                        dfs(nrow , ncol , grid , vis , n , m);
                        
                    }
                    
                }
                
            }
            
        }
        
    }
    
    public int countIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int vis [][] = new int [n][m];
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == 'L' && vis[i][j] == 0){
                    
                    dfs(i , j , grid , vis , n , m);
                    ans++;
                    
                }
                
            }
            
        }
        
        return ans;
        
        
    }
    
}
