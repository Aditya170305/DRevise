import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueensOptimal {
    
    public void solve(int col , char [][] board , List<List<String>> ans , int n , int []leftRow , int [] lowerDiagonal , int [] upperDiagonal){

        if(col == n){
            List<String> temp = new ArrayList<String>();

            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for(int row=0 ; row < n ; row++){
            if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                solve(col+1 , board , ans , n , leftRow , lowerDiagonal , upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char [][] board = new char [n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i] , '.');
        }

        // solve(0 , board , ans , n);

        int leftRow [] = new int[n];
        int lowerDiagonal [] = new int[2 * n - 1];
        int upperDiagonal [] = new int[2 * n - 1];

        solve(0 , board , ans , n , leftRow , lowerDiagonal , upperDiagonal);

        return ans;
    }

}
