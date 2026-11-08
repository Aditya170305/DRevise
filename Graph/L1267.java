import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Pair {

    int row;
    int col;

    public Pair(int row , int col){

        this.row = row;
        this.col = col;

    }

}

public class L1267 {
    
    public int countServers(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<Pair>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j] == 1){

                    q.add(new Pair(i , j));

                }

            }

        }

        Set<Integer> st = new HashSet<Integer>();

        if(q.isEmpty()) return 0;

        while(!q.isEmpty()){

            Pair it = q.poll();
            int row = it.row;
            int col = it.col;

            boolean flag = false;

            for(int j=col+1;j<m;j++){

                if(grid[row][j] == 1){

                    int value = (row * m) + j;
                    st.add(value);
                    flag =  true;

                }

            }

            for(int i=row+1;i<n;i++){

                if(grid[i][col] == 1){

                    int value = (i * m) + col;
                    st.add(value);
                    flag = true;

                }

            }

            if(flag){

                int value = (row * m) + col;
                st.add(value);

            }

        }

        return st.size();

    }

}
