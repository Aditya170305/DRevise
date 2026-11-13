import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    
    public void dfs(int row , int col , int [][] vis , char [][] grid , ArrayList<String> vec , int row0 , int col0 , int [] dr , int [] dc , int n , int m){

        vis[row][col] = 1;

        vec.add(toString(row - row0 , col - col0));

        for(int i=0;i<4;i++){

            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'L'){

                dfs(nrow , ncol , vis , grid , vec , row0 , col0 , dr , dc , n , m);

            }

        }

    }

    public String toString(int r , int c){

        return Integer.toString(r) + " " + Integer.toString(c);

    }

    public int countDistinctIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int vis [][] = new int [n][m];

        int dr [] = {-1 , 0 , +1 , 0};
        int dc [] = {0 , +1 , 0 , -1};

        HashSet<ArrayList<String>> st = new HashSet<>();

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                if(vis[i][j] == 0 && grid[i][j] == 'L'){

                    ArrayList<String> vec = new ArrayList<String>();
                    dfs(i , j , vis , grid , vec , i , j , dr , dc , n , m);
                    st.add(vec);

                }

            }

        }

        return st.size();

    }
    
}
