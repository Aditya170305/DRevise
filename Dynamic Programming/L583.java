public class L583 {
    
    public int find(int n1 , int n2 , int dp [][] , String word1 , String word2){

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];

                else dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);

            }

        }

        return dp[n1][n2];

    }

    public int minDistance(String word1, String word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();

        int dp [][] = new int [n1 + 1][n2 + 1];

        int lcs =  find(n1 , n2 , dp , word1 , word2);

        int deletions = n1 - lcs;
        int insertions = n2 - lcs;

        return deletions + insertions;

    }
    
}
