import java.util.PriorityQueue;

class Pair {

    public int time;
    public int row;
    public int col;

    public Pair(int time , int row , int col){

        this.time = time;
        this.row = row;
        this.col = col;

    }

}

public class SwimInRisingWater {

    public int swimInWater(int[][] grid) {
        
        int n = grid.length;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>( (a , b) -> a.time - b.time );

        int vis [][] = new int [n][n];

        pq.add(new Pair(grid[0][0] , 0 , 0));
        vis[0][0] = 1;

        int dr [] = {-1 , 0 , +1 , 0};
        int dc [] = {0 , +1 , 0 , -1};

        while(!pq.isEmpty()){

            Pair it = pq.poll();

            int time = it.time;
            int row = it.row;
            int col = it.col;

            if(row == n - 1 && col == n - 1){
                return time;
            }

            for(int i=0;i<4;i++){

                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0){

                    vis[nrow][ncol] = 1;
                    int newTime = Math.max(time , grid[nrow][ncol]);
                    pq.add(new Pair(newTime , nrow , ncol));

                }

            }

        }

        return -1;

    }

}