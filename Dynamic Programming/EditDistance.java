
public class EditDistance {
    
    public int find(int i , int j , int [][] dp , String word1 , String word2){

        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = 0 + find(i - 1 , j - 1 , dp , word1 , word2);
        }

        else{
            int insert = 1 + find(i , j - 1 , dp , word1 , word2);
            int delete = 1 + find(i - 1 , j , dp , word1 , word2);
            int replace = 1 + find(i - 1 , j - 1 , dp , word1 , word2);

            dp[i][j] = Math.min(insert , Math.min(delete , replace));

        }

        return dp[i][j];

    }
    
    public int minDistance(String word1, String word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();

        // int dp [][] = new int [n1][n2];

        // for(int i=0;i<n1;i++){
        //     Arrays.fill(dp[i] , -1);
        // }

        // return find(n1 - 1 , n2 - 1 , dp , word1 , word2);

        int dp [][] = new int [n1 + 1][n2 + 1];

        for(int i=0;i<=n1;i++){
            dp[i][0] = i;
        }

        for(int j=0;j<=n2;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 0 + dp[i - 1][j - 1];
                }

                else{
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert , Math.min(delete , replace));
                }

            }

        }

        return dp[n1][n2];

    }

}
