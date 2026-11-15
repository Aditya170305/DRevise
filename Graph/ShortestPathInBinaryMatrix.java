import java.util.LinkedList;
import java.util.Queue;

class Pair {

    public int first;
    public int second;
    public int third;

    public Pair(int first , int second , int third){

        this.first = first;
        this.second = second;
        this.third = third;

    }

}

public class ShortestPathInBinaryMatrix {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length;
        int m = grid[0].length;

        int dist [][] = new int [n][m];

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return -1;

        if(n == 1 && m == 1)
            return 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        q.add(new Pair(0 , 0 , 0));

        while(!q.isEmpty()){

            Pair it = q.poll();

            int dis = it.first;
            int row = it.second;
            int col = it.third;

            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){

                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol]){
                        dist[nrow][ncol] = 1 + dis;
                        if(nrow == n-1 && ncol == m-1){
                            return dis + 2;
                        }
                        q.add(new Pair(1 + dis , nrow , ncol));
                    }
                }
            }
        }

        return -1;

    }
    
}
