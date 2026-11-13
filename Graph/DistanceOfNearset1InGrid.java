import java.util.ArrayList;
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

public class DistanceOfNearset1InGrid {

    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        int vis [][] = new int [n][m];
        
        for(int i=0;i<n;i++){
            
            ans.add(new ArrayList<>());
            
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == 1){
                    
                    Pair p = new Pair(i , j , 0);
                    q.offer(p);
                    vis[i][j] = 1;
                }
                
                ans.get(i).add(0);
                
            }
            
        }
        
        int dr [] = {-1 , 0 , +1 , 0};
        int dc [] = {0 , +1 , 0 , -1};
        
        while(!q.isEmpty()){
            
            Pair it = q.poll();
            int row = it.row;
            int col = it.col;
            int time = it.time;
            
            for(int i=0;i<4;i++){
                
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                
                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0){
                    
                    ans.get(nrow).set(ncol , time + 1);
                    Pair p = new Pair(nrow , ncol , time + 1);
                    q.offer(p);
                    vis[nrow][ncol] = 1;
                    
                }
                
            }
            
        }
        
        return ans;
        
    }

}
