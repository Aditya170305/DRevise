public class LongestPalindromicSubsequence {
    
    public int find(int n , int dp [][] , String s1 , String s2){

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){

                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);

            }

        }

        return dp[n][n];

    }

    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();

        int dp [][] = new int [n + 1][n + 1];

        char arr [] = s.toCharArray();

        int i = 0;

        while(i < n / 2){

            char ch = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = ch;

            i++;

        }

        return find(n , dp , s , new String(arr));

    }
    
}
