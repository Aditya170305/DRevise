import java.util.ArrayList;

public class RateInAMaze {
  
    public static void solve(int i , int j , int arr [][] , int n , ArrayList<String> ans , int [][] vis , String move , int [] di , int [] dj){

        if(i == n-1 && j == n-1){
            ans.add(move);
            return;
        }

        String dir = "DLRU";
        for(int ind=0;ind<4;ind++){
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && arr[nexti][nextj] == 1){
                vis[i][j] = 1;
                solve(nexti , nextj , arr , n , ans , vis , move + dir.charAt(ind) , di , dj);
                vis[i][j] = 0;
            }
        }
    }

    public static ArrayList < String > findSum(int[][] arr, int n) {
        
        ArrayList<String> ans = new ArrayList<>();
        int [][] vis = new int [n][n];
        int di [] = {+1 , 0 , 0 , -1};
        int dj [] = {0 , -1 , +1 , 0};
        if(arr[0][0] == 1) solve(0 , 0 , arr , n , ans , vis , "" , di , dj);
        return ans;
    }
}
