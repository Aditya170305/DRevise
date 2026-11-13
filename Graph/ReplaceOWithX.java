public class ReplaceOWithX {
    
    public void dfs(int row , int col , int [][] vis , char [][] grid , int [] dr , int [] dc , int n , int m){
        
        vis[row][col] = -1;
        
        for(int i=0;i<4;i++){
            
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            
            if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && grid[nrow][ncol] == 'O' && vis[nrow][ncol] == 0){
                
                dfs(nrow , ncol , vis , grid , dr , dc , n , m);
                
            }
        }
        
    }
    
    public void fill(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int vis [][] = new int [n][m];
        
        int dr [] = {-1 , 0 , +1 , 0};
        int dc [] = {0 , +1 , 0 , -1};
        
        for(int j=0;j<m;j++){
            
            if(grid[0][j] == 'O') dfs(0 , j , vis , grid , dr , dc , n , m);
            
        }
        
        for(int i=0;i<n;i++){
            
            if(grid[i][0] == 'O') dfs(i , 0 , vis , grid , dr , dc , n , m);
            
        }
        
        for(int j=0;j<m;j++){
            
            if(grid[n - 1][j] == 'O') dfs(n - 1 , j , vis , grid , dr , dc , n , m);
            
        }
        
        for(int i=0;i<n;i++){
            
            if(grid[i][m - 1] == 'O') dfs(i , m - 1 , vis , grid , dr , dc , n , m);
            
        }
        
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == 'O' && vis[i][j] != -1) grid[i][j] = 'X';
                
            }
            
        }
        
    }
    
}
