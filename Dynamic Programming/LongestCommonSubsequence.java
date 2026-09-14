
public class LongestCommonSubsequence {
    
    public int find(int index1 , int index2 , int dp [][] , String text1 , String text2){

        if(index1 < 0 || index2 < 0){
            return 0;
        }

        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(text1.charAt(index1) == text2.charAt(index2)){
            dp[index1][index2] = 1 + find(index1 - 1 , index2 - 1 , dp , text1 , text2);
            return dp[index1][index2];
        }

        dp[index1][index2] = Math.max(find(index1 - 1 , index2 , dp , text1 , text2) , find(index1 , index2 - 1 , dp , text1 , text2));

        return dp[index1][index2];

    }

    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();

        // int dp [][] = new int [n][m];

        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i] , -1);
        // }

        // return find(n - 1 , m - 1 , dp , text1 , text2);

        int dp [][] = new int [n + 1][m + 1];

        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];

                else dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);

            }
        }

        return dp[n][m];

    }

}
