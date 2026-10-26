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

public class L3619 {
    
    public long bfs(int row , int col , int val , int [][] grid , int [][] vis , int [] dr , int [] dc , int n , int m){

        Queue<Pair> q = new LinkedList<Pair>();

        q.offer(new Pair(row , col));

        long sum = val;
        vis[row][col] = 1;

        while(!q.isEmpty()){

            Pair it = q.poll();

            int r = it.row;
            int c = it.col;

            for(int i=0;i<4;i++){

                int nrow = dr[i] + r;
                int ncol = dc[i] + c;

                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0){

                    if(grid[nrow][ncol] != 0 && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        sum = sum + grid[nrow][ncol];
                        Pair p = new Pair(nrow , ncol);
                        q.offer(p);
                    }

                }

            }

        }

        return sum;

    }

    public int countIslands(int[][] grid, int k) {
        
        int n = grid.length;
        int m = grid[0].length;
        int vis [][] = new int [n][m];

        int dr [] = {+1 , 0 , -1 , 0};
        int dc [] = {0 , +1 , 0 , -1};

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j] != 0 && vis[i][j] == 0){
                    long sum = bfs(i , j , grid[i][j] , grid , vis , dr , dc , n , m);
                    if(sum % k == 0) ans++;
                }

            }

        }

        return ans;

    }
    
}
