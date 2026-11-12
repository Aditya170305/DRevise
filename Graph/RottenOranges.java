import java.util.LinkedList;
import java.util.Queue;

class Pair {
    
    int row;
    int col;
    int time;
    
    public Pair(int row , int col , int time){
        
        this.row = row;
        this.col = col;
        this.time = time;
        
    }
    
}

public class RottenOranges {
    
    public int orangesRot(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        int vis [][] = new int [n][m];
        
        int countFresh = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(mat[i][j] == 2){
                    
                    q.offer(new Pair(i , j , 0));
                    vis[i][j] = 2;
                    
                }
                
                else{
                    
                    vis[i][j] = 0;
                    
                }
                
                if(mat[i][j] == 1) countFresh++;
                
            }
            
        }
        
        int tm = 0;
        int dr [] = {+1 , 0 , -1 , 0};
        int dc [] = {0 , +1 , 0 , -1};
        
        int count = 0;
        
        while(!q.isEmpty()){
            
            Pair it = q.poll();
            int row = it.row;
            int col = it.col;
            int time = it.time;
            
            tm = Math.max(tm , time);
            
            for(int i=0;i<4;i++){
                
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                
                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    
                    Pair p = new Pair(nrow , ncol , time + 1);
                    q.offer(p);
                    vis[nrow][ncol] = 2;
                    count++;
                    
                }
                
            }
            
        }
        
        if(count != countFresh) return -1;
        
        return tm;
        
    }
    
}
