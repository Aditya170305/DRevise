import java.util.ArrayList;

public class NQueensBrute {
    
    public static boolean isSafe(int row , int col , int [][] board , int n){

        int duprow = row;
        int dupcol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 1) return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        while(col >= 0){
            if(board[row][col] == 1) return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        while(row < n && col >= 0){
            if(board[row][col] == 1) return false;
            row++;
            col--;
        }

        return true;
    }

    public static void solve(int col , int [][] board , ArrayList<ArrayList<Integer>> ans , int n){
        
        if(col == n){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    temp.add(board[i][j]);
                }
            }
            ans.add(temp);

            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row , col , board , n)){
                board[row][col] = 1;
                solve(col + 1 , board , ans , n);
                board[row][col] = 0;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int [][] board = new int [n][n];

        solve(0 , board , ans , n);

        return ans;
    }
}
