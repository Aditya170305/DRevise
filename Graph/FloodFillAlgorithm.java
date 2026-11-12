public class FloodFillAlgorithm {
    
    public void dfs(int sr , int sc , int newColor , int srcColor , int [][] image , int [][] vis , int [] dr , int [] dc , int n , int m){
        
        vis[sr][sc] = 1;
        image[sr][sc] = newColor;
        
        for(int i=0;i<4;i++){
            
            int nrow = sr + dr[i];
            int ncol = sc - dc[i];
            
            if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0){
                
                if(image[nrow][ncol] == srcColor && vis[nrow][ncol] == 0){
                    
                    dfs(nrow , ncol , newColor , srcColor , image , vis , dr , dc , n , m);
                    
                }
                
            }
            
        }
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int n = image.length;
        int m = image[0].length;
        
        int vis [][] = new int [n][m];
        
        int dr [] = {-1 , 0 , +1 , 0};
        int dc [] = {0 , +1 , 0 , -1};
        
        int srcColor = image[sr][sc];
        
        dfs(sr , sc , newColor , srcColor , image , vis , dr , dc , n , m);
        
        return image;
        
    }
    
}
