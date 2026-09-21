public class DistinctSubsequences {
    
    public int find(int i , int j , int dp [][] , String s , String t){

        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] =  find(i - 1 , j - 1 , dp , s , t) + find(i - 1 , j , dp , s , t);
        }

        else{
            dp[i][j] = find(i - 1 , j , dp , s , t);
        }

        return dp[i][j];
        
    }

    public int numDistinct(String s, String t) {
        
        int n1 = s.length();
        int n2 = t.length();

        // int dp [][] = new int [n1][n2];

        // for(int i=0;i<n1;i++){
        //     Arrays.fill(dp[i] , -1);
        // }

        // return find(n1 - 1 , n2 - 1 , dp , s , t);

        int dp [][] = new int [n1 + 1][n2 + 1];

        for(int i=0;i<=n1;i++){
            dp[i][0] = 1;
        }

        for(int j=1;j<=n2;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }

                else{
                    dp[i][j] = dp[i - 1][j];
                }

            }

        }

        return dp[n1][n2];
        
    }
    
}
