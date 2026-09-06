import java.util.List;

public class Traingle {
    
    public int find(int i , int j , int n , List<List<Integer>> traingle , int dp [][]){

        if(i == n - 1) return traingle.get(n - 1).get(j);

        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int down = traingle.get(i).get(j) + find(i + 1 , j , n , traingle , dp);
        int diagonal = traingle.get(i).get(j) + find(i + 1 , j + 1 , n , traingle , dp);

        dp[i][j] = Math.min(down , diagonal);

        return dp[i][j];

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();

        int dp [][] = new int [n][n];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){

        //         dp[i][j] = Integer.MIN_VALUE;

        //     }
        // }

        // return find(0 , 0 , n , triangle , dp);

        for(int j=0;j<n;j++){
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){

                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down , diagonal);

            }
        }

        return dp[0][0];

    }
    
}
