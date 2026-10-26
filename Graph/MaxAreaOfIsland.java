import java.util.LinkedList;
import java.util.Queue;

class Pair {

    int row;
    int col;

    public Pair(int row , int col){

        this.row = row;
        this.col = col;

    }

}

public class MaxAreaOfIsland {
 
    public int bfs(int row , int col , int [][] grid , int [][] vis , int [] dr , int [] dc , int n , int m){

        Queue<Pair> q = new LinkedList<Pair>();

        q.offer(new Pair(row , col));
        vis[row][col] = 1;

        int maxi = 0;

        while(!q.isEmpty()){

            Pair it = q.poll();
            int r = it.row;
            int c = it.col;
            maxi++;

            for(int i=0;i<4;i++){

                int nrow = dr[i] + r;
                int ncol = dc[i] + c;

                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0){

                    if(grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        Pair p = new Pair(nrow , ncol);
                        q.offer(p);
                    }

                }

            }

        }

        return maxi;

    }

    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int vis [][] = new int [n][m];

        int dr [] = {+1 , 0 , -1 , 0};
        int dc [] = {0 , +1 , 0 , -1};

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j] == 1 && vis[i][j] == 0){
                    int maxi = bfs(i , j , grid , vis , dr , dc , n , m);
                    ans = Math.max(maxi , ans);
                }

            }

        }

        return ans;

    }

}
